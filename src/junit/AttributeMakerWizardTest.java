package junit;

import org.junit.*;
import authoring.objectediting.AttributeMakerWizard;
import static org.junit.Assert.*;

/**
 * The class <code>AttributeMakerWizardTest</code> contains tests for the class <code>{@link AttributeMakerWizard}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AttributeMakerWizardTest {
	/**
	 * Run the AttributeMakerWizard() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAttributeMakerWizard_1()
		throws Exception {

		AttributeMakerWizard result = new AttributeMakerWizard();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at authoring.objectediting.AttributeMakerWizard.<init>(AttributeMakerWizard.java:19)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
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
	 * @generatedBy CodePro at 11/28/15 12:55 AM
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
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(AttributeMakerWizardTest.class);
	}
}