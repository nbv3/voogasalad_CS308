package junit;

import java.util.Map;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.implementation.GameView;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ObjectView;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController;

/**
 * The class <code>ViewControllerTest</code> contains tests for the class <code>{@link ViewController}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ViewControllerTest {
	/**
	 * Run the ViewController(double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testViewController_1()
		throws Exception {
		double size = 1.0;

		ViewController result = new ViewController(size);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the void addViewObject(IViewableObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testAddViewObject_1()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IViewableObject obj = EasyMock.createMock(IViewableObject.class);
		// add mock object expectations here

		EasyMock.replay(obj);

		fixture.addViewObject(obj);

		// add additional test code here
		EasyMock.verify(obj);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the GameView getGameView() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetGameView_1()
		throws Exception {
		ViewController fixture = new ViewController(1.0);

		GameView result = fixture.getGameView();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the Map<IViewableObject, ObjectView> getViewMap() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetViewMap_1()
		throws Exception {
		ViewController fixture = new ViewController(1.0);

		Map<IViewableObject, ObjectView> result = fixture.getViewMap();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		assertNotNull(result);
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_1()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_2()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_3()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_4()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_5()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_6()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_7()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void initializeView(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testInitializeView_8()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.initializeView(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
	}

	/**
	 * Run the void removeViewObject(IViewableObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testRemoveViewObject_1()
		throws Exception {
		ViewController fixture = new ViewController(1.0);
		IViewableObject obj = EasyMock.createMock(IViewableObject.class);
		// add mock object expectations here

		EasyMock.replay(obj);

		fixture.removeViewObject(obj);

		// add additional test code here
		EasyMock.verify(obj);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
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
		new org.junit.runner.JUnitCore().run(ViewControllerTest.class);
	}
}