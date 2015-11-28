package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;
import com.syntacticsugar.vooga.gameplayer.view.implementation.GameMenu;

/**
 * The class <code>GameMenuTest</code> contains tests for the class <code>{@link GameMenu}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class GameMenuTest {
	/**
	 * Run the GameMenu(IViewManager,double,double,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameMenu_1()
		throws Exception {
		IViewManager manager = EasyMock.createMock(IViewManager.class);
		double width = 1.0;
		double height = 1.0;
		String title = "";
		// add mock object expectations here

		EasyMock.replay(manager);

		GameMenu result = new GameMenu(manager, width, height, title);

		// add additional test code here
		EasyMock.verify(manager);
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
		new org.junit.runner.JUnitCore().run(GameMenuTest.class);
	}
}