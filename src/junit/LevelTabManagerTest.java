package junit;

import javafx.scene.control.TabPane;
import authoring.level.LevelTabManager;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>LevelTabManagerTest</code> contains tests for the class <code>{@link LevelTabManager}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class LevelTabManagerTest {
	/**
	 * Run the LevelTabManager() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testLevelTabManager_1()
		throws Exception {

		LevelTabManager result = new LevelTabManager();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at authoring.level.LevelTabManager.<init>(LevelTabManager.java:13)
		assertNotNull(result);
	}

	/**
	 * Run the void addNewLevel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddNewLevel_1()
		throws Exception {
		LevelTabManager fixture = new LevelTabManager();

		fixture.addNewLevel();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TabPane
		//       at authoring.level.LevelTabManager.<init>(LevelTabManager.java:13)
	}

	/**
	 * Run the void addNewLevel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddNewLevel_2()
		throws Exception {
		LevelTabManager fixture = new LevelTabManager();

		fixture.addNewLevel();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TabPane
		//       at authoring.level.LevelTabManager.<init>(LevelTabManager.java:13)
	}

	/**
	 * Run the TabPane getTabPane() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetTabPane_1()
		throws Exception {
		LevelTabManager fixture = new LevelTabManager();

		TabPane result = fixture.getTabPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.TabPane
		//       at authoring.level.LevelTabManager.<init>(LevelTabManager.java:13)
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
		new org.junit.runner.JUnitCore().run(LevelTabManagerTest.class);
	}
}