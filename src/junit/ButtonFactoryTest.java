package junit;

import javafx.scene.control.Button;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.gui.factory.ButtonFactory;

/**
 * The class <code>ButtonFactoryTest</code> contains tests for the class <code>{@link ButtonFactory}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ButtonFactoryTest {
	/**
	 * Run the ButtonFactory() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testButtonFactory_1()
		throws Exception {

		ButtonFactory result = new ButtonFactory();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Button createObject(String,double,double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCreateObject_1()
		throws Exception {
		ButtonFactory fixture = new ButtonFactory();
		String id = "";
		double width = 1.0;
		double height = 1.0;

		Button result = fixture.createObject(id, width, height);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at com.syntacticsugar.vooga.util.gui.factory.ButtonFactory.createObject(ButtonFactory.java:11)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ButtonFactoryTest.class);
	}
}