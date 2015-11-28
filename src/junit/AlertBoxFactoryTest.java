package junit;

import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

/**
 * The class <code>AlertBoxFactoryTest</code> contains tests for the class <code>{@link AlertBoxFactory}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AlertBoxFactoryTest {
	/**
	 * Run the AlertBoxFactory() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testAlertBoxFactory_1()
		throws Exception {

		AlertBoxFactory result = new AlertBoxFactory();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void createObject(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCreateObject_1()
		throws Exception {
		String id = "";

		AlertBoxFactory.createObject(id);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.Alert.<init>(Unknown Source)
		//       at javafx.scene.control.Alert.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory.createObject(AlertBoxFactory.java:13)
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
		new org.junit.runner.JUnitCore().run(AlertBoxFactoryTest.class);
	}
}