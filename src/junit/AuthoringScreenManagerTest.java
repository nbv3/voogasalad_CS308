package junit;

import org.junit.*;
import authoring.AuthoringScreenManager;
import static org.junit.Assert.*;

/**
 * The class <code>AuthoringScreenManagerTest</code> contains tests for the class <code>{@link AuthoringScreenManager}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AuthoringScreenManagerTest {
	/**
	 * Run the AuthoringScreenManager() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testAuthoringScreenManager_1()
		throws Exception {

		AuthoringScreenManager result = new AuthoringScreenManager();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at authoring.level.LevelTabManager.<init>(LevelTabManager.java:13)
		//       at authoring.AuthoringScreenManager.initLevelEditor(AuthoringScreenManager.java:69)
		//       at authoring.AuthoringScreenManager.<init>(AuthoringScreenManager.java:25)
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
		new org.junit.runner.JUnitCore().run(AuthoringScreenManagerTest.class);
	}
}