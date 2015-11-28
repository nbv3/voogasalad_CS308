package junit;

import java.util.Collection;
import javafx.event.EventTarget;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

/**
 * The class <code>GameUniverseTest</code> contains tests for the class <code>{@link GameUniverse}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class GameUniverseTest {
	/**
	 * Run the GameUniverse() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameUniverse_1()
		throws Exception {

		GameUniverse result = new GameUniverse();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void addGameObject(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddGameObject_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject toAdd = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(toAdd);

		fixture.addGameObject(toAdd);

		// add additional test code here
		EasyMock.verify(toAdd);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void addPlayer(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddPlayer_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject player = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(player);

		fixture.addPlayer(player);

		// add additional test code here
		EasyMock.verify(player);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void addPlayer(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddPlayer_2()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject player = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(player);

		fixture.addPlayer(player);

		// add additional test code here
		EasyMock.verify(player);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void addToGraveYard(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddToGraveYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject toRemove = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(toRemove);

		fixture.addToGraveYard(toRemove);

		// add additional test code here
		EasyMock.verify(toRemove);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void addToSpawnYard(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAddToSpawnYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject toAdd = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(toAdd);

		fixture.addToSpawnYard(toAdd);

		// add additional test code here
		EasyMock.verify(toAdd);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void clearGraveYard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testClearGraveYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		fixture.clearGraveYard();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void clearSpawnYard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testClearSpawnYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		fixture.clearSpawnYard();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the Collection<KeyCode> getCurrentKeyInput() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetCurrentKeyInput_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		Collection<KeyCode> result = fixture.getCurrentKeyInput();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<IGameObject> getGameObjects() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetGameObjects_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		Collection<IGameObject> result = fixture.getGameObjects();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<IGameObject> getGraveYard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetGraveYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		Collection<IGameObject> result = fixture.getGraveYard();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<IGameObject> getPlayers() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetPlayers_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		Collection<IGameObject> result = fixture.getPlayers();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<IGameObject> getSpawnYard() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetSpawnYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		Collection<IGameObject> result = fixture.getSpawnYard();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the IGameTile getTile(Point2D) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetTile_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		Point2D p = new Point2D(1.0, 1.0);

		IGameTile result = fixture.getTile(p);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<DecoratorTile> getTiles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetTiles_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		Collection<DecoratorTile> result = fixture.getTiles();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the boolean[][] isPlaceable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsPlaceable_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		boolean[][] result = fixture.isPlaceable();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the boolean[][] isWalkable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsWalkable_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));

		boolean[][] result = fixture.isWalkable();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the void receiveKeyPress(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveKeyPress_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		KeyCode code = KeyCode.A;

		fixture.receiveKeyPress(code);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void receiveKeyPress(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveKeyPress_2()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		KeyCode code = KeyCode.A;

		fixture.receiveKeyPress(code);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void receiveKeyRelease(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveKeyRelease_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		KeyCode code = KeyCode.A;

		fixture.receiveKeyRelease(code);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void receiveKeyRelease(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveKeyRelease_2()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		KeyCode code = KeyCode.A;

		fixture.receiveKeyRelease(code);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void receiveMouseEvent(MouseEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveMouseEvent_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		MouseEvent mouseEvent = new MouseEvent(new EventType(), 1.0, 1.0, 1.0, 1.0, MouseButton.MIDDLE, 1, true, true, true, true, true, true, true, true, true, true, new PickResult(EasyMock.createNiceMock(EventTarget.class), 1.0, 1.0));

		fixture.receiveMouseEvent(mouseEvent);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void removeGameObject(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testRemoveGameObject_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject toRemove = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(toRemove);

		fixture.removeGameObject(toRemove);

		// add additional test code here
		EasyMock.verify(toRemove);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void removeGameObject(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testRemoveGameObject_2()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		IGameObject toRemove = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(toRemove);

		fixture.removeGameObject(toRemove);

		// add additional test code here
		EasyMock.verify(toRemove);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void setSpawnYard(Collection<IGameObject>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetSpawnYard_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		Collection<IGameObject> spawnyard = EasyMock.createMock(Collection.class);
		// add mock object expectations here

		EasyMock.replay(spawnyard);

		fixture.setSpawnYard(spawnyard);

		// add additional test code here
		EasyMock.verify(spawnyard);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
	}

	/**
	 * Run the void setTowers(Collection<IGameObject>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetTowers_1()
		throws Exception {
		GameUniverse fixture = new GameUniverse();
		fixture.setTowers(EasyMock.createNiceMock(Collection.class));
		fixture.receiveKeyPress(KeyCode.A);
		fixture.addPlayer(EasyMock.createNiceMock(IGameObject.class));
		fixture.addToGraveYard(EasyMock.createNiceMock(IGameObject.class));
		fixture.addGameObject(EasyMock.createNiceMock(IGameObject.class));
		Collection<IGameObject> towers = EasyMock.createMock(Collection.class);
		// add mock object expectations here

		EasyMock.replay(towers);

		fixture.setTowers(towers);

		// add additional test code here
		EasyMock.verify(towers);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.universe.GameUniverse.addPlayer(GameUniverse.java:40)
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
		new org.junit.runner.JUnitCore().run(GameUniverseTest.class);
	}
}