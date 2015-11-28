package junit;

import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;

/**
 * The class <code>BoundingBoxTest</code> contains tests for the class <code>{@link BoundingBox}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class BoundingBoxTest {
	/**
	 * Run the BoundingBox(Point2D,double,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testBoundingBox_1()
		throws Exception {
		Point2D point = new Point2D(1.0, 1.0);
		double width = 1.0;
		double height = 1.0;

		BoundingBox result = new BoundingBox(point, width, height);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getHeight(), 1.0);
		assertEquals(1.0, result.getWidth(), 1.0);
		assertEquals(0.0, result.getRotate(), 1.0);
		assertEquals(0, result.countObservers());
		assertEquals(false, result.hasChanged());
	}

	/**
	 * Run the Direction getDirection() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetDirection_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);

		Direction result = fixture.getDirection();

		// add additional test code here
		assertNotNull(result);
		assertEquals("DOWN", result.name());
		assertEquals("DOWN", result.toString());
		assertEquals(1, result.ordinal());
	}

	/**
	 * Run the double getHeight() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetHeight_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);

		double result = fixture.getHeight();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
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
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);

		Point2D result = fixture.getPoint();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Point2D [x = 1.0, y = 1.0]", result.toString());
		assertEquals(1.4142135623730951, result.magnitude(), 1.0);
		assertEquals(1.0, result.getY(), 1.0);
		assertEquals(1.0, result.getX(), 1.0);
	}

	/**
	 * Run the double getRotate() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetRotate_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);

		double result = fixture.getRotate();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the double getWidth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetWidth_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);

		double result = fixture.getWidth();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the void setDirection(Direction) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetDirection_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);
		Direction dir = Direction.DOWN;

		fixture.setDirection(dir);

		// add additional test code here
	}

	/**
	 * Run the void setHeight(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetHeight_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);
		double height = 1.0;

		fixture.setHeight(height);

		// add additional test code here
	}

	/**
	 * Run the void setPoint(Point2D) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetPoint_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);
		Point2D point = new Point2D(1.0, 1.0);

		fixture.setPoint(point);

		// add additional test code here
	}

	/**
	 * Run the void setRotate(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetRotate_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);
		double rotation = 1.0;

		fixture.setRotate(rotation);

		// add additional test code here
	}

	/**
	 * Run the void setWidth(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetWidth_1()
		throws Exception {
		BoundingBox fixture = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		fixture.setRotate(1.0);
		fixture.setDirection(Direction.DOWN);
		double width = 1.0;

		fixture.setWidth(width);

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
		new org.junit.runner.JUnitCore().run(BoundingBoxTest.class);
	}
}