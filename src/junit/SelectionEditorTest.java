package junit;

import javafx.scene.Scene;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.objecteditor.IChangeObjectEditorScene;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.authoring.objecteditor.SelectionEditor;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

/**
 * The class <code>SelectionEditorTest</code> contains tests for the class <code>{@link SelectionEditor}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class SelectionEditorTest {
	/**
	 * Run the SelectionEditor(IChangeObjectEditorScene,GameObjectType,ObjectData) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSelectionEditor_1()
		throws Exception {
		IChangeObjectEditorScene change = EasyMock.createMock(IChangeObjectEditorScene.class);
		GameObjectType type = GameObjectType.ENEMY;
		ObjectData myData = new ObjectData();
		// add mock object expectations here

		EasyMock.replay(change);

		SelectionEditor result = new SelectionEditor(change, type, myData);

		// add additional test code here
		EasyMock.verify(change);
		assertNotNull(result);
	}

	/**
	 * Run the Scene createScene() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testCreateScene_1()
		throws Exception {
		SelectionEditor fixture = new SelectionEditor(EasyMock.createNiceMock(IChangeObjectEditorScene.class), GameObjectType.ENEMY, new ObjectData());

		Scene result = fixture.createScene();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.layout.BorderPane
		//       at com.syntacticsugar.vooga.authoring.objecteditor.SelectionEditor.createScene(SelectionEditor.java:51)
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
		new org.junit.runner.JUnitCore().run(SelectionEditorTest.class);
	}
}