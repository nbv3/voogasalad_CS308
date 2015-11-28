package junit;

import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.AbstractTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.PathTile;

/**
 * The class <code>DecoratorTileTest</code> contains tests for the class <code>{@link DecoratorTile}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class DecoratorTileTest {
	/**
	 * Run the DecoratorTile(Point2D,double,double,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testDecoratorTile_1()
		throws Exception {
		Point2D point = new Point2D(1.0, 1.0);
		double width = 1.0;
		double height = 1.0;
		String path = "";

		DecoratorTile result = new DecoratorTile(point, width, height, path);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.isPlaceable());
		assertEquals(false, result.isWalkable());
		assertEquals(false, result.isDestination());
		assertEquals("", result.getPath());
	}

	/**
	 * Run the AbstractTile getImplementation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetImplementation_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		AbstractTile result = fixture.getImplementation();

		// add additional test code here
		assertNotNull(result);
		assertEquals(false, result.isPlaceable());
		assertEquals(true, result.isWalkable());
	}

	/**
	 * Run the Point2D getPoint() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPoint_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		Point2D result = fixture.getPoint();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Point2D [x = 1.0, y = 1.0]", result.toString());
		assertEquals(1.4142135623730951, result.magnitude(), 1.0);
		assertEquals(1.0, result.getY(), 1.0);
		assertEquals(1.0, result.getX(), 1.0);
	}

	/**
	 * Run the boolean isDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsDestination_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		boolean result = fixture.isDestination();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsDestination_2()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		boolean result = fixture.isDestination();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsDestination_3()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(false);

		boolean result = fixture.isDestination();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isPlaceable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsPlaceable_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		boolean result = fixture.isPlaceable();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isPlaceable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsPlaceable_2()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		boolean result = fixture.isPlaceable();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean isWalkable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsWalkable_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		boolean result = fixture.isWalkable();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean isWalkable() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIsWalkable_2()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);

		boolean result = fixture.isWalkable();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the void setDestination(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetDestination_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);
		boolean isDestination = true;

		fixture.setDestination(isDestination);

		// add additional test code here
	}

	/**
	 * Run the void setImplementation(AbstractTile) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetImplementation_1()
		throws Exception {
		DecoratorTile fixture = new DecoratorTile(new Point2D(1.0, 1.0), 1.0, 1.0, "");
		fixture.setImplementation(new PathTile(new Point2D(1.0, 1.0)));
		fixture.setDestination(true);
		AbstractTile implementation = new PathTile(new Point2D(1.0, 1.0));

		fixture.setImplementation(implementation);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(DecoratorTileTest.class);
	}
}