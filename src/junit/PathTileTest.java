package junit;

import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.PathTile;

/**
 * The class <code>PathTileTest</code> contains tests for the class <code>{@link PathTile}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:57 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class PathTileTest {
	/**
	 * Run the PathTile(Point2D) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testPathTile_1()
		throws Exception {
		Point2D point = new Point2D(1.0, 1.0);

		PathTile result = new PathTile(point);

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.isPlaceable());
		assertEquals(true, result.isWalkable());
		assertEquals(true, result.isDestination());
	}

	/**
	 * Run the boolean isDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testIsDestination_1()
		throws Exception {
		PathTile fixture = new PathTile(new Point2D(1.0, 1.0));

		boolean result = fixture.isDestination();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isPlaceable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testIsPlaceable_1()
		throws Exception {
		PathTile fixture = new PathTile(new Point2D(1.0, 1.0));

		boolean result = fixture.isPlaceable();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isWalkable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testIsWalkable_1()
		throws Exception {
		PathTile fixture = new PathTile(new Point2D(1.0, 1.0));

		boolean result = fixture.isWalkable();

		// add additional test code here
		assertEquals(true, result);
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
		new org.junit.runner.JUnitCore().run(PathTileTest.class);
	}
}