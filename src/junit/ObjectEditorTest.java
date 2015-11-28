package junit;

import javafx.scene.Parent;
import javafx.scene.Scene;
import org.junit.*;
import authoring.objectediting.ObjectEditor;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.editor.LevelToolBar;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

/**
 * The class <code>ObjectEditorTest</code> contains tests for the class <code>{@link ObjectEditor}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ObjectEditorTest {
	/**
	 * Run the ObjectEditor() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testObjectEditor_1()
		throws Exception {

		com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor result = new com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at com.syntacticsugar.vooga.authoring.objecteditor.TypeEditor.createScene(TypeEditor.java:23)
		//       at com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor.<init>(ObjectEditor.java:20)
		assertNotNull(result);
	}

	/**
	 * Run the void initSelectionScene(GameObjectType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testInitSelectionScene_1()
		throws Exception {
		com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor fixture = new com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor();
		fixture.initSelectionScene(GameObjectType.ENEMY);
		fixture.typeScene = new Scene(new LevelToolBar());
		GameObjectType type = GameObjectType.ENEMY;

		fixture.initSelectionScene(type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.layout.BorderPane
		//       at com.syntacticsugar.vooga.authoring.objecteditor.TypeEditor.createScene(TypeEditor.java:23)
		//       at com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor.<init>(ObjectEditor.java:20)
	}

	/**
	 * Run the void resetToTypeScene() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testResetToTypeScene_1()
		throws Exception {
		com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor fixture = new com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor();
		fixture.initSelectionScene(GameObjectType.ENEMY);
		fixture.typeScene = new Scene(new LevelToolBar());

		fixture.resetToTypeScene();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.layout.BorderPane
		//       at com.syntacticsugar.vooga.authoring.objecteditor.TypeEditor.createScene(TypeEditor.java:23)
		//       at com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor.<init>(ObjectEditor.java:20)
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
		new org.junit.runner.JUnitCore().run(ObjectEditorTest.class);
	}
}