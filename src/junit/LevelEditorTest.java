package junit;

import javafx.scene.control.Tab;
import authoring.level.LevelEditor;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>LevelEditorTest</code> contains tests for the class <code>{@link LevelEditor}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:57 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class LevelEditorTest {
	/**
	 * Run the LevelEditor() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testLevelEditor_1()
		throws Exception {

		LevelEditor result = new LevelEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		//       at authoring.level.LevelEditor.<init>(LevelEditor.java:21)
		assertNotNull(result);
	}

	/**
	 * Run the LevelEditor() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testLevelEditor_2()
		throws Exception {

		LevelEditor result = new LevelEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		//       at authoring.level.LevelEditor.<init>(LevelEditor.java:21)
		assertNotNull(result);
	}

	/**
	 * Run the Tab getTab() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testGetTab_1()
		throws Exception {
		LevelEditor fixture = new LevelEditor();

		Tab result = fixture.getTab();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		//       at authoring.level.LevelEditor.<init>(LevelEditor.java:21)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(LevelEditorTest.class);
	}
}