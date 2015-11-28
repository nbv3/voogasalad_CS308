package junit;

import javafx.scene.Node;
import javafx.scene.control.Button;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.view.AbstractGameMenu;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;
import com.syntacticsugar.vooga.gameplayer.view.implementation.GameMenu;

/**
 * The class <code>AbstractGameMenuTest</code> contains tests for the class <code>{@link AbstractGameMenu}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AbstractGameMenuTest {
	/**
	 * Run the Button createButton(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCreateButton_1()
		throws Exception {
		AbstractGameMenu fixture = new GameMenu(EasyMock.createNiceMock(IViewManager.class), 1.0, 1.0, "");
		String name = "";

		Button result = fixture.createButton(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameMenu
		assertNotNull(result);
	}

	/**
	 * Run the void generateOptions(Node[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGenerateOptions_1()
		throws Exception {
		AbstractGameMenu fixture = new GameMenu(EasyMock.createNiceMock(IViewManager.class), 1.0, 1.0, "");

		fixture.generateOptions();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
	}

	/**
	 * Run the void generateOptions(Node[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGenerateOptions_2()
		throws Exception {
		AbstractGameMenu fixture = new GameMenu(EasyMock.createNiceMock(IViewManager.class), 1.0, 1.0, "");

		fixture.generateOptions();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameMenu
	}

	/**
	 * Run the void launchEditor() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testLaunchEditor_1()
		throws Exception {
		AbstractGameMenu fixture = new GameMenu(EasyMock.createNiceMock(IViewManager.class), 1.0, 1.0, "");

		fixture.launchEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameMenu
	}

	/**
	 * Run the void launchGame() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testLaunchGame_1()
		throws Exception {
		AbstractGameMenu fixture = new GameMenu(EasyMock.createNiceMock(IViewManager.class), 1.0, 1.0, "");

		fixture.launchGame();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameMenu
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
		new org.junit.runner.JUnitCore().run(AbstractGameMenuTest.class);
	}
}