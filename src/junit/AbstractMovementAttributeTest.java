package junit;

import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute;

/**
 * The class <code>AbstractMovementAttributeTest</code> contains tests for the class <code>{@link AbstractMovementAttribute}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AbstractMovementAttributeTest {
	/**
	 * Run the double getSpeed() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSpeed_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();

		double result = fixture.getSpeed();

		// add additional test code here
		assertEquals(3.0, result, 0.1);
	}

	/**
	 * Run the double getXVelocity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetXVelocity_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();

		double result = fixture.getXVelocity();

		// add additional test code here
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double getYVelocity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetYVelocity_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();

		double result = fixture.getYVelocity();

		// add additional test code here
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the void resetVelocity() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testResetVelocity_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();

		fixture.resetVelocity();

		// add additional test code here
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
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		Direction dir = Direction.DOWN;

		fixture.setDirection(dir);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute.setDirection(AbstractMovementAttribute.java:72)
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
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		double rotation = 1.0;

		fixture.setRotate(rotation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute.setRotate(AbstractMovementAttribute.java:67)
	}

	/**
	 * Run the void setSpeed(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetSpeed_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		double speed = 1.0;

		fixture.setSpeed(speed);

		// add additional test code here
	}

	/**
	 * Run the void setXVelocity(HDirection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetXVelocity_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		HDirection xDir = HDirection.LEFT;

		fixture.setXVelocity(xDir);

		// add additional test code here
	}

	/**
	 * Run the void setXVelocity(HDirection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetXVelocity_2()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		HDirection xDir = HDirection.LEFT;

		fixture.setXVelocity(xDir);

		// add additional test code here
	}

	/**
	 * Run the void setXVelocity(HDirection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetXVelocity_3()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		HDirection xDir = HDirection.LEFT;

		fixture.setXVelocity(xDir);

		// add additional test code here
	}

	/**
	 * Run the void setYVelocity(VDirection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetYVelocity_1()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		VDirection yDir = VDirection.DOWN;

		fixture.setYVelocity(yDir);

		// add additional test code here
	}

	/**
	 * Run the void setYVelocity(VDirection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetYVelocity_2()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		VDirection yDir = VDirection.DOWN;

		fixture.setYVelocity(yDir);

		// add additional test code here
	}

	/**
	 * Run the void setYVelocity(VDirection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetYVelocity_3()
		throws Exception {
		AbstractMovementAttribute fixture = new AIMovementAttribute();
		VDirection yDir = VDirection.DOWN;

		fixture.setYVelocity(yDir);

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
		new org.junit.runner.JUnitCore().run(AbstractMovementAttributeTest.class);
	}
}