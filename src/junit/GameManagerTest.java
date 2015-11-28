package junit;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.manager.GameManager;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

/**
 * The class <code>GameManagerTest</code> contains tests for the class <code>{@link GameManager}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:57 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class GameManagerTest {
	/**
	 * Run the GameManager(double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testGameManager_1()
		throws Exception {
		double gameSize = 1.0;

		GameManager result = new GameManager(gameSize);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
		assertNotNull(result);
	}

	/**
	 * Run the void checkConditions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testCheckConditions_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.checkConditions();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void checkConditions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testCheckConditions_2()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.checkConditions();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void checkConditions() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testCheckConditions_3()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.checkConditions();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void endLevel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testEndLevel_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.endLevel();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the Pane getGameView() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testGetGameView_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		Pane result = fixture.getGameView();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
		assertNotNull(result);
	}

	/**
	 * Run the void initializeAnimation(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testInitializeAnimation_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		double fl = 1.0;

		fixture.initializeAnimation(fl);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void receiveKeyPressed(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testReceiveKeyPressed_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		KeyCode code = KeyCode.A;

		fixture.receiveKeyPressed(code);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void receiveKeyReleased(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testReceiveKeyReleased_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		KeyCode code = KeyCode.A;

		fixture.receiveKeyReleased(code);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void restartGame() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testRestartGame_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.restartGame();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void startGame() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testStartGame_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.startGame();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void startLevel(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testStartLevel_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		IGameUniverse level = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(level);

		fixture.startLevel(level);

		// add additional test code here
		EasyMock.verify(level);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void switchLevel(ConditionType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testSwitchLevel_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		ConditionType type = ConditionType.LOSING;

		fixture.switchLevel(type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void switchLevel(ConditionType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testSwitchLevel_2()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		ConditionType type = ConditionType.LOSING;

		fixture.switchLevel(type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void switchLevel(ConditionType) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testSwitchLevel_3()
		throws Exception {
		GameManager fixture = new GameManager(1.0);
		ConditionType type = ConditionType.LOSING;

		fixture.switchLevel(type);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Run the void updateGame() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testUpdateGame_1()
		throws Exception {
		GameManager fixture = new GameManager(1.0);

		fixture.updateGame();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		//       at com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController.<init>(ViewController.java:19)
		//       at com.syntacticsugar.vooga.gameplayer.manager.GameManager.<init>(GameManager.java:48)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameManagerTest.class);
	}
}