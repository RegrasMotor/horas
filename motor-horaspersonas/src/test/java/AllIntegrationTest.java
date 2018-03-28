import integration.N0;
import integration.N1;
import integration.N2;
import integration.N3;
import integration.N4;
import integration.N5;
import integration.N6;
import integration.N7;
import integration.N8;
import integration.N9;
import integration.N9bis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
	N0.class,
	N1.class,
	N2.class,
	N3.class,
	N4.class,
	N5.class,
	N6.class,
	N7.class,
	N8.class,
	N9.class,
	N9bis.class}
)

// the actual class is empty
public class AllIntegrationTest {
}