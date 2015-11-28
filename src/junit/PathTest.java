package junit;

import java.awt.Point;
import java.util.List;
import java.util.Stack;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.tools.Path;

/**
 * The class <code>PathTest</code> contains tests for the class <code>{@link Path}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class PathTest {
	/**
	 * Run the Path() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPath_1()
		throws Exception {

		com.syntacticsugar.vooga.gameplayer.utilities.Path result = new com.syntacticsugar.vooga.gameplayer.utilities.Path();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getNext());
	}

	/**
	 * Run the Path(Stack<Point>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testPath_2()
		throws Exception {
		Stack<Point> path = new Stack();

		com.syntacticsugar.vooga.gameplayer.utilities.Path result = new com.syntacticsugar.vooga.gameplayer.utilities.Path(path);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getNext());
	}

	/**
	 * Run the Point getDestination() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetDestination_1()
		throws Exception {
		Path fixture = new com.syntacticsugar.vooga.gameplayer.utilities.Path(new Stack());

		Point result = fixture.getDestination();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.EmptyStackException
		//       at java.util.Stack.peek(Unknown Source)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.Path.getDestination(Path.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the List<Point> getList() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetList_1()
		throws Exception {
		Path fixture = new com.syntacticsugar.vooga.gameplayer.utilities.Path(new Stack());

		List<Point> result = fixture.getList();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Point getNext() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetNext_1()
		throws Exception {
		Path fixture = new com.syntacticsugar.vooga.gameplayer.utilities.Path(new Stack());

		Point result = fixture.getNext();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Point getNext() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetNext_2()
		throws Exception {
		Path fixture = new com.syntacticsugar.vooga.gameplayer.utilities.Path(new Stack());

		Point result = fixture.getNext();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Stack<Point> getStack() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetStack_1()
		throws Exception {
		Path fixture = new com.syntacticsugar.vooga.gameplayer.utilities.Path(new Stack());

		Stack<Point> result = fixture.getStack();

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
		new org.junit.runner.JUnitCore().run(PathTest.class);
	}
}