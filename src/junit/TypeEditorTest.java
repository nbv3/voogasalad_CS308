package junit;

import javafx.scene.Scene;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.objecteditor.IChangeObjectEditorScene;
import com.syntacticsugar.vooga.authoring.objecteditor.TypeEditor;

/**
 * The class <code>TypeEditorTest</code> contains tests for the class <code>{@link TypeEditor}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class TypeEditorTest {
	/**
	 * Run the TypeEditor(IChangeObjectEditorScene) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testTypeEditor_1()
		throws Exception {
		IChangeObjectEditorScene ichange = EasyMock.createMock(IChangeObjectEditorScene.class);
		// add mock object expectations here

		EasyMock.replay(ichange);

		TypeEditor result = new TypeEditor(ichange);

		// add additional test code here
		EasyMock.verify(ichange);
		assertNotNull(result);
	}

	/**
	 * Run the Scene createScene() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCreateScene_1()
		throws Exception {
		TypeEditor fixture = new TypeEditor(EasyMock.createNiceMock(IChangeObjectEditorScene.class));

		Scene result = fixture.createScene();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.layout.BorderPane
		//       at com.syntacticsugar.vooga.authoring.objecteditor.TypeEditor.createScene(TypeEditor.java:23)
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
		new org.junit.runner.JUnitCore().run(TypeEditorTest.class);
	}
}