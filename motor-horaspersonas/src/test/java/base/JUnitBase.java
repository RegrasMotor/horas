package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.RuntimeDroolsException;
import org.drools.audit.WorkingMemoryFileLogger;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.ide.common.client.modeldriven.dt52.GuidedDecisionTable52;
import org.drools.ide.common.server.util.GuidedDTDRLPersistence;
import org.drools.ide.common.server.util.GuidedDTXMLPersistence;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.springframework.util.StreamUtils;

import com.prosegur.rulesEngine.factsmodel.horaspersonas.FactRequest;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.RequestHoraspersonas;
import com.prosegur.rulesEngine.services.soapService.model.horaspersonas.factsformat.FactsFormat;

public abstract class JUnitBase {
	private static KnowledgeBase kbase;
	protected StatefulKnowledgeSession ksession; 
	protected WorkingMemoryFileLogger logger;

	protected static final double delta = 0.009;
	
	protected final static String logsDir = "src/test/java/log/";
	
	private static final String webbasedDecisionTableExtension = ".gdst";
	private static final String webbasedDecisionTableCompiledExtension = ".drl";
	private static final String technicalRuleExtension = ".drl";
	private static final String changeSetExtension = ".xml";
	private static final String functionExtension = ".function";	
	private final static String importSettings = "import com.prosegur.rulesEngine.horaspersonas.model.factsmodel.*;\n";
	
	protected static KnowledgeBase readKnowledgeBase(String resourceFile) {
		final KnowledgeBuilder kbuilder = readKnowledgeBuilder(resourceFile);

		final KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
	
	public static KnowledgeBuilder readKnowledgeBuilder(String resourceFile) {
		final KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		for (String file : resourceFile.split(";")) {
			Resource resource = null;
			ResourceType resourceType = null;
			
			if (file.endsWith(technicalRuleExtension)) {
				resourceType = ResourceType.DRL;
			} else if (file.endsWith(changeSetExtension)) {
				resourceType = ResourceType.CHANGE_SET;
			} else if (file.endsWith(webbasedDecisionTableExtension)) {
				resource = ResourceFactory.newFileResource(compileWebbasedDecisionTable (file));
				resourceType = ResourceType.DRL;
			} else if (file.endsWith(functionExtension)) {
				resourceType = ResourceType.DRL;
			} else {
				throw new RuntimeException(file + ". Format type not supported");
			}
			
			kbuilder.add((resource==null)?ResourceFactory.newClassPathResource(file):resource, resourceType);
		}

		if (kbuilder.hasErrors()) {
			for (KnowledgeBuilderError error : kbuilder.getErrors()) {
				System.err.println(error);
			}
			throw new RuntimeDroolsException("Errores de compilación en las reglas importadas");
		}
		
		return kbuilder;
	}
	
    public static File compileWebbasedDecisionTable (String name) {
    	File drlFile = null;
    	
    	try {
    		File gdstFile = new File(URLDecoder.decode(JUnitBase.class.getClassLoader().getResource(name).getPath(), "UTF-8"));
    		//copiamos el DRL a un fichero en la misma ruta con el mismo nombre de entrada y extension .drl
	    	String outputName = gdstFile.getName().substring(0, gdstFile.getName().lastIndexOf('.')) + webbasedDecisionTableCompiledExtension;
    		String outputPath = gdstFile.getAbsolutePath().substring(0, gdstFile.getAbsolutePath().lastIndexOf(File.separator))+File.separator;
    		drlFile = new File(outputPath+outputName);
			//obtenemos el fichero de entrada y copiamos el contenido a una cadena
			byte[] input = StreamUtils.copyToByteArray(new FileInputStream (gdstFile));
			String xml = new String( input );
			//convertimos el XML a un modelo de objetos
			GuidedDecisionTable52 model = GuidedDTXMLPersistence.getInstance().unmarshal( xml );
			//compilamos el modelo de objetos a lenguaje DRL
			String drl = importSettings + GuidedDTDRLPersistence.getInstance().marshal( model );
	    	//escribimos el fichero
	    	FileOutputStream output = new FileOutputStream (drlFile);
	    	output.write(drl.getBytes());
	    	output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return drlFile;	    	
    }	
	
    public FactRequest insertRequestFromFile (String file) {
		RequestHoraspersonas request = null;
		
		try {
			JAXBContext jc = JAXBContext.newInstance(RequestHoraspersonas.class);
	        final Unmarshaller u = jc.createUnmarshaller();
	        
	        request = (RequestHoraspersonas)u.unmarshal(new File(JUnitBase.class.getClassLoader().getResource(file).getFile()));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		FactRequest factRequest = FactsFormat.parse(request);
		
		ksession.insert(factRequest.getParams());
        ksession.insert(factRequest.getOt());
        ksession.insert(factRequest.getEsquemaOperativo());
        ksession.insert(factRequest.getEscala());
        ksession.insert(factRequest.getTipoPuesto());
        ksession.insert(factRequest.getCategoriaSalarial());
        ksession.insert(factRequest.getEscalaXcategoria());
		
		return factRequest;
    }
    
	public static void initialize (String file) {
		kbase = readKnowledgeBase (file);
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		//Liberación de recursos, escritura en el log...
	}
	
	@Before
    public void setUp() {
		//Inicialización de variables antes de cada Test
		ksession = kbase.newStatefulKnowledgeSession();
		
		logger = new WorkingMemoryFileLogger(ksession);
    }
	
	@After
    public void tearDown() {
		//Tareas a realizar después de cada test
		logger.writeToDisk();
		
		ksession.dispose();
    }
}

