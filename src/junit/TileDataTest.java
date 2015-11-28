package junit;

import org.junit.*;
import authoring.data.TileData;
import static org.junit.Assert.*;

/**
 * The class <code>TileDataTest</code> contains tests for the class <code>{@link TileData}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class TileDataTest {
	/**
	 * Run the TileData(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testTileData_1()
		throws Exception {
		String imagePath = "";

		TileData result = new TileData(imagePath);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getImagePath());
		assertEquals("com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.SceneryTile", result.getImplementation());
		assertEquals(false, result.isDestination());
	}

	/**
	 * Run the String getImagePath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetImagePath_1()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(true);

		String result = fixture.getImagePath();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the String getImplementation() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetImplementation_1()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(true);

		String result = fixture.getImplementation();

		// add additional test code here
		assertEquals("com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.SceneryTile", result);
	}

	/**
	 * Run the boolean isDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsDestination_1()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
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
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testIsDestination_2()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(false);

		boolean result = fixture.isDestination();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the void setDestination(boolean) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetDestination_1()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(true);
		boolean isDestination = true;

		fixture.setDestination(isDestination);

		// add additional test code here
	}

	/**
	 * Run the void setImagePath(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetImagePath_1()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(true);
		String path = "";

		fixture.setImagePath(path);

		// add additional test code here
	}

	/**
	 * Run the void setImplementation(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetImplementation_1()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(true);
		String impl = "";

		fixture.setImplementation(impl);

		// add additional test code here
	}

	/**
	 * Run the void setImplementation(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testSetImplementation_2()
		throws Exception {
		TileData fixture = new TileData("");
		fixture.setImagePath("");
		fixture.setDestination(true);
		String impl = "Path";

		fixture.setImplementation(impl);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(TileDataTest.class);
	}
}