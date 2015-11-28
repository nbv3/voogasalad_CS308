package junit;

import java.awt.Point;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.tools.Path;
import com.syntacticsugar.vooga.util.tools.Paths;

/**
 * The class <code>PathsTest</code> contains tests for the class <code>{@link Paths}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class PathsTest {
	/**
	 * Run the Paths(List<Stack<Point>>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPaths_1()
		throws Exception {
		List<Stack<Point>> paths = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(paths);

		Paths result = new Paths(paths);

		// add additional test code here
		EasyMock.verify(paths);
		assertNotNull(result);
	}

	/**
	 * Run the Paths(List<Stack<Point>>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPaths_2()
		throws Exception {
		List<Stack<Point>> paths = EasyMock.createMock(List.class);
		// add mock object expectations here

		EasyMock.replay(paths);

		Paths result = new Paths(paths);

		// add additional test code here
		EasyMock.verify(paths);
		assertNotNull(result);
	}

	/**
	 * Run the Set<Path> getAllPaths() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetAllPaths_1()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));

		Set<Path> result = fixture.getAllPaths();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Path getPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPath_1()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));

		Path result = fixture.getPath();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: bound must be positive
		//       at java.util.Random.nextInt(Unknown Source)
		//       at com.syntacticsugar.vooga.util.tools.Paths.getPath(Paths.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Path getPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPath_2()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));

		Path result = fixture.getPath();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: bound must be positive
		//       at java.util.Random.nextInt(Unknown Source)
		//       at com.syntacticsugar.vooga.util.tools.Paths.getPath(Paths.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Path getPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPath_3()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));

		Path result = fixture.getPath();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: bound must be positive
		//       at java.util.Random.nextInt(Unknown Source)
		//       at com.syntacticsugar.vooga.util.tools.Paths.getPath(Paths.java:53)
		assertNotNull(result);
	}

	/**
	 * Run the Set<Path> getRandomPaths() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetRandomPaths_1()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));

		Set<Path> result = fixture.getRandomPaths();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Set<Path> getRandomPaths(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetRandomPaths_2()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));
		int num = 1;

		Set<Path> result = fixture.getRandomPaths(num);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Set<Path> getRandomPaths(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetRandomPaths_3()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));
		int num = -1;

		Set<Path> result = fixture.getRandomPaths(num);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Set<Path> getRandomPaths(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetRandomPaths_4()
		throws Exception {
		Paths fixture = new Paths(EasyMock.createNiceMock(List.class));
		int num = 0;

		Set<Path> result = fixture.getRandomPaths(num);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
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
		new org.junit.runner.JUnitCore().run(PathsTest.class);
	}
}