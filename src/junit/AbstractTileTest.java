package junit;

import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.AbstractTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.PathTile;

/**
 * The class <code>AbstractTileTest</code> contains tests for the class <code>{@link AbstractTile}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AbstractTileTest {
	/**
	 * Run the Point2D getPoint() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetPoint_1()
		throws Exception {
		AbstractTile fixture = new PathTile(new Point2D(1.0, 1.0));

		Point2D result = fixture.getPoint();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Point2D [x = 1.0, y = 1.0]", result.toString());
		assertEquals(1.4142135623730951, result.magnitude(), 1.0);
		assertEquals(1.0, result.getY(), 1.0);
		assertEquals(1.0, result.getX(), 1.0);
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
		new org.junit.runner.JUnitCore().run(AbstractTileTest.class);
	}
}