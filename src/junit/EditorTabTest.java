package junit;

import javafx.scene.Node;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.editor.LevelToolBar;
import com.syntacticsugar.vooga.authoring.editor.sidepanes.EditorTab;

/**
 * The class <code>EditorTabTest</code> contains tests for the class <code>{@link EditorTab}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class EditorTabTest {
	/**
	 * Run the Node getContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetContent_1()
		throws Exception {
		EditorTab fixture = new EditorTab();
		fixture.setTabDescription("");
		fixture.setContent(new LevelToolBar());

		Node result = fixture.getContent();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		assertNotNull(result);
	}

	/**
	 * Run the String getTabDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetTabDescription_1()
		throws Exception {
		EditorTab fixture = new EditorTab();
		fixture.setTabDescription("");
		fixture.setContent(new LevelToolBar());

		String result = fixture.getTabDescription();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.authoring.editor.LevelToolBar
		assertNotNull(result);
	}

	/**
	 * Run the void setContent(Node) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetContent_1()
		throws Exception {
		EditorTab fixture = new EditorTab();
		fixture.setTabDescription("");
		fixture.setContent(new LevelToolBar());
		Node content = new LevelToolBar();

		fixture.setContent(content);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.authoring.editor.LevelToolBar
	}

	/**
	 * Run the void setTabDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetTabDescription_1()
		throws Exception {
		EditorTab fixture = new EditorTab();
		fixture.setTabDescription("");
		fixture.setContent(new LevelToolBar());
		String tabDescription = "";

		fixture.setTabDescription(tabDescription);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.authoring.editor.LevelToolBar
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
		new org.junit.runner.JUnitCore().run(EditorTabTest.class);
	}
}