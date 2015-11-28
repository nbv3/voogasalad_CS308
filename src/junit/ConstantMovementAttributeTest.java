package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.ConstantMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.AbstractMovementType;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.MoveDownCardinal;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

/**
 * The class <code>ConstantMovementAttributeTest</code> contains tests for the class <code>{@link ConstantMovementAttribute}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ConstantMovementAttributeTest {
	/**
	 * Run the ConstantMovementAttribute(AbstractMovementType,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testConstantMovementAttribute_1()
		throws Exception {
		AbstractMovementType movementType = new MoveDownCardinal();
		double speed = 1.0;

		ConstantMovementAttribute result = new ConstantMovementAttribute(movementType, speed);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getSpeed(), 1.0);
		assertEquals(0.0, result.getYVelocity(), 1.0);
		assertEquals(0.0, result.getXVelocity(), 1.0);
		assertEquals(null, result.getParent());
	}

	/**
	 * Run the void move() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testMove_1()
		throws Exception {
		ConstantMovementAttribute fixture = new ConstantMovementAttribute(new MoveDownCardinal(), 1.0);

		fixture.move();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.ConstantMovementAttribute.move(ConstantMovementAttribute.java:27)
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateSelf_1()
		throws Exception {
		ConstantMovementAttribute fixture = new ConstantMovementAttribute(new MoveDownCardinal(), 1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AbstractMovementAttribute.setDirection(AbstractMovementAttribute.java:72)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.MoveDownCardinal.setMovement(MoveDownCardinal.java:14)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.ConstantMovementAttribute.updateSelf(ConstantMovementAttribute.java:21)
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
		new org.junit.runner.JUnitCore().run(ConstantMovementAttributeTest.class);
	}
}