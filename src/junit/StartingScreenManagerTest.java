package junit;

import javafx.stage.Stage;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.view.implementation.StartingScreenManager;

/**
 * The class <code>StartingScreenManagerTest</code> contains tests for the class <code>{@link StartingScreenManager}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class StartingScreenManagerTest {
	/**
	 * Run the StartingScreenManager(Stage) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testStartingScreenManager_1()
		throws Exception {
		Stage stage = new Stage();

		StartingScreenManager result = new StartingScreenManager(stage);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		assertNotNull(result);
	}

	/**
	 * Run the void launchEditor() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testLaunchEditor_1()
		throws Exception {
		StartingScreenManager fixture = new StartingScreenManager(new Stage());

		fixture.launchEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
	}

	/**
	 * Run the void launchGame() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testLaunchGame_1()
		throws Exception {
		StartingScreenManager fixture = new StartingScreenManager(new Stage());

		fixture.launchGame();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
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
		new org.junit.runner.JUnitCore().run(StartingScreenManagerTest.class);
	}
}