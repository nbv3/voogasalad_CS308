package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;
import com.syntacticsugar.vooga.gameplayer.view.implementation.StartingMenu;

/**
 * The class <code>StartingMenuTest</code> contains tests for the class <code>{@link StartingMenu}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class StartingMenuTest {
	/**
	 * Run the StartingMenu(IViewManager,double,double,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testStartingMenu_1()
		throws Exception {
		IViewManager manager = EasyMock.createMock(IViewManager.class);
		double width = 1.0;
		double height = 1.0;
		String title = "";
		// add mock object expectations here

		EasyMock.replay(manager);

		StartingMenu result = new StartingMenu(manager, width, height, title);

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
		new org.junit.runner.JUnitCore().run(StartingMenuTest.class);
	}
}