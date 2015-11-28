package junit;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.util.tools.Path;
import com.syntacticsugar.vooga.util.tools.PathFinder;
import com.syntacticsugar.vooga.util.tools.Paths;

/**
 * The class <code>PathFinderTest</code> contains tests for the class <code>{@link PathFinder}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class PathFinderTest {
	/**
	 * Run the PathFinder(Map<Point,DecoratorTile>,int,Point,Point) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPathFinder_1()
		throws Exception {
		Map<Point, DecoratorTile> tileMap = EasyMock.createMock(Map.class);
		int size = 1;
		Point start = new Point();
		Point end = new Point();
		// add mock object expectations here

		EasyMock.replay(tileMap);

		com.syntacticsugar.vooga.gameplayer.utilities.PathFinder result = new com.syntacticsugar.vooga.gameplayer.utilities.PathFinder(tileMap, size, start, end);

		// add additional test code here
		EasyMock.verify(tileMap);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.fillMap(PathFinder.java:35)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.<init>(PathFinder.java:56)
		assertNotNull(result);
	}

	/**
	 * Run the PathFinder(Map<Point,DecoratorTile>,int,List<Point>,List<Point>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPathFinder_2()
		throws Exception {
		Map<Point, DecoratorTile> tileMap = EasyMock.createMock(Map.class);
		int size = 1;
		List<Point> start = EasyMock.createMock(List.class);
		List<Point> end = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(tileMap);
		EasyMock.replay(start);
		EasyMock.replay(end);

		com.syntacticsugar.vooga.gameplayer.utilities.PathFinder result = new com.syntacticsugar.vooga.gameplayer.utilities.PathFinder(tileMap, size, start, end);

		// add additional test code here
		EasyMock.verify(tileMap);
		EasyMock.verify(start);
		EasyMock.verify(end);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.fillMap(PathFinder.java:35)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.<init>(PathFinder.java:30)
		assertNotNull(result);
	}

	/**
	 * Run the PathFinder(Map<Point,Boolean>,int,int,Point,Point) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPathFinder_3()
		throws Exception {
		Map<Point, Boolean> pathGrid = EasyMock.createMock(Map.class);
		int rows = 1;
		int cols = 1;
		Point start = new Point();
		Point end = new Point();
		// add mock object expectations here

		EasyMock.replay(pathGrid);

		com.syntacticsugar.vooga.gameplayer.utilities.PathFinder result = new com.syntacticsugar.vooga.gameplayer.utilities.PathFinder(pathGrid, rows, cols, start, end);

		// add additional test code here
		EasyMock.verify(pathGrid);
		assertNotNull(result);
	}

	/**
	 * Run the PathFinder(Map<Point,Boolean>,int,int,Point,Point) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPathFinder_4()
		throws Exception {
		Map<Point, Boolean> pathGrid = EasyMock.createMock(Map.class);
		int rows = 1;
		int cols = 1;
		Point start = new Point();
		Point end = new Point();
		// add mock object expectations here

		EasyMock.replay(pathGrid);

		com.syntacticsugar.vooga.gameplayer.utilities.PathFinder result = new com.syntacticsugar.vooga.gameplayer.utilities.PathFinder(pathGrid, rows, cols, start, end);

		// add additional test code here
		EasyMock.verify(pathGrid);
		assertNotNull(result);
	}

	/**
	 * Run the PathFinder(Map<Point,Boolean>,int,int,List<Point>,List<Point>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPathFinder_5()
		throws Exception {
		Map<Point, Boolean> pathGrid = EasyMock.createMock(Map.class);
		int rows = 1;
		int cols = 1;
		List<Point> start = EasyMock.createMock(List.class);
		List<Point> end = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(pathGrid);
		EasyMock.replay(start);
		EasyMock.replay(end);

		com.syntacticsugar.vooga.gameplayer.utilities.PathFinder result = new com.syntacticsugar.vooga.gameplayer.utilities.PathFinder(pathGrid, rows, cols, start, end);

		// add additional test code here
		EasyMock.verify(pathGrid);
		EasyMock.verify(start);
		EasyMock.verify(end);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.findPaths(PathFinder.java:84)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.<init>(PathFinder.java:52)
		assertNotNull(result);
	}

	/**
	 * Run the com.syntacticsugar.vooga.gameplayer.utilities.Path getPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPath_1()
		throws Exception {
		PathFinder fixture = new com.syntacticsugar.vooga.gameplayer.utilities.PathFinder(EasyMock.createNiceMock(Map.class), 1, 1, EasyMock.createNiceMock(List.class), EasyMock.createNiceMock(List.class));

		com.syntacticsugar.vooga.gameplayer.utilities.Path result = fixture.getPath();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.findPaths(PathFinder.java:84)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.PathFinder.<init>(PathFinder.java:52)
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
		new org.junit.runner.JUnitCore().run(PathFinderTest.class);
	}
}