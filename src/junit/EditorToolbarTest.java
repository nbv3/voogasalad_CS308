package junit;

import javafx.scene.control.Button;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.editor.EditorToolbar;
import com.syntacticsugar.vooga.authoring.editor.LevelToolBar;

/**
 * The class <code>EditorToolbarTest</code> contains tests for the class <code>{@link EditorToolbar}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class EditorToolbarTest {
	/**
	 * Run the Button createToolbarItem(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testCreateToolbarItem_1()
		throws Exception {
		EditorToolbar fixture = new LevelToolBar();
		String actionName = "";

		Button result = fixture.createToolbarItem(actionName);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.authoring.editor.LevelToolBar
		assertNotNull(result);
	}

	/**
	 * Run the String getToolName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetToolName_1()
		throws Exception {
		EditorToolbar fixture = new LevelToolBar();

		String result = fixture.getToolName();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
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
		new org.junit.runner.JUnitCore().run(EditorToolbarTest.class);
	}
}