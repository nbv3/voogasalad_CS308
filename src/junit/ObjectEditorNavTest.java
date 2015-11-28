package junit;

import javafx.scene.Node;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.objecteditor.IChangeObjectEditorScene;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditorNav;

/**
 * The class <code>ObjectEditorNavTest</code> contains tests for the class <code>{@link ObjectEditorNav}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ObjectEditorNavTest {
	/**
	 * Run the ObjectEditorNav(IChangeObjectEditorScene) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testObjectEditorNav_1()
		throws Exception {
		IChangeObjectEditorScene ichange = EasyMock.createMock(IChangeObjectEditorScene.class);
		// add mock object expectations here

		EasyMock.replay(ichange);

		ObjectEditorNav result = new ObjectEditorNav(ichange);

		// add additional test code here
		EasyMock.verify(ichange);
		assertNotNull(result);
	}

	/**
	 * Run the Node createNavBar() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCreateNavBar_1()
		throws Exception {
		ObjectEditorNav fixture = new ObjectEditorNav(EasyMock.createNiceMock(IChangeObjectEditorScene.class));

		Node result = fixture.createNavBar();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.layout.HBox
		//       at com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditorNav.createNavBar(ObjectEditorNav.java:19)
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
		new org.junit.runner.JUnitCore().run(ObjectEditorNavTest.class);
	}
}