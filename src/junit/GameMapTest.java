package junit;

import java.util.Collection;
import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

/**
 * The class <code>GameMapTest</code> contains tests for the class <code>{@link GameMap}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class GameMapTest {
	/**
	 * Run the GameMap(int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameMap_1()
		throws Exception {
		int dim = 1;

		GameMap result = new GameMap(dim);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the GameMap(int) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGameMap_2()
		throws Exception {
		int dim = 0;

		GameMap result = new GameMap(dim);

		// add additional test code here
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
		GameMap fixture = new GameMap(1);
		Point2D p = new Point2D(1.0, 1.0);

		IGameTile result = fixture.getTile(p);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ArrayIndexOutOfBoundsException: 1
		//       at com.syntacticsugar.vooga.gameplayer.universe.map.GameMap.getTile(GameMap.java:72)
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
		GameMap fixture = new GameMap(1);

		Collection<DecoratorTile> result = fixture.getTiles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the Collection<DecoratorTile> getTiles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetTiles_2()
		throws Exception {
		GameMap fixture = new GameMap(1);

		Collection<DecoratorTile> result = fixture.getTiles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	/**
	 * Run the Collection<DecoratorTile> getTiles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetTiles_3()
		throws Exception {
		GameMap fixture = new GameMap(1);

		Collection<DecoratorTile> result = fixture.getTiles();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
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
		GameMap fixture = new GameMap(1);

		boolean[][] result = fixture.isPlaceable();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(1, result[0].length);
		assertEquals(true, result[0][0]);
	}

	/**
	 * Run the boolean[][] isPlaceable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsPlaceable_2()
		throws Exception {
		GameMap fixture = new GameMap(1);

		boolean[][] result = fixture.isPlaceable();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(1, result[0].length);
		assertEquals(true, result[0][0]);
	}

	/**
	 * Run the boolean[][] isPlaceable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsPlaceable_3()
		throws Exception {
		GameMap fixture = new GameMap(0);

		boolean[][] result = fixture.isPlaceable();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
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
		GameMap fixture = new GameMap(1);

		boolean[][] result = fixture.isWalkable();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(1, result[0].length);
		assertEquals(false, result[0][0]);
	}

	/**
	 * Run the boolean[][] isWalkable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsWalkable_2()
		throws Exception {
		GameMap fixture = new GameMap(1);

		boolean[][] result = fixture.isWalkable();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.length);
		assertNotNull(result[0]);
		assertEquals(1, result[0].length);
		assertEquals(false, result[0][0]);
	}

	/**
	 * Run the boolean[][] isWalkable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsWalkable_3()
		throws Exception {
		GameMap fixture = new GameMap(0);

		boolean[][] result = fixture.isWalkable();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.length);
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
		new org.junit.runner.JUnitCore().run(GameMapTest.class);
	}
}