package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

/**
 * The class <code>AIMovementAttributeTest</code> contains tests for the class <code>{@link AIMovementAttribute}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AIMovementAttributeTest {
	/**
	 * Run the AIMovementAttribute() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testAIMovementAttribute_1()
		throws Exception {

		AIMovementAttribute result = new AIMovementAttribute();

		// add additional test code here
		assertNotNull(result);
		assertEquals(3.0, result.getSpeed(), 1.0);
		assertEquals(0.0, result.getYVelocity(), 1.0);
		assertEquals(0.0, result.getXVelocity(), 1.0);
		assertEquals(null, result.getParent());
	}

	/**
	 * Run the void move() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testMove_1()
		throws Exception {
		AIMovementAttribute fixture = new AIMovementAttribute();

		fixture.move();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.EmptyStackException
		//       at java.util.Stack.peek(Unknown Source)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.Path.getDestination(Path.java:39)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute.nextPoint(AIMovementAttribute.java:52)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute.move(AIMovementAttribute.java:72)
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateSelf_1()
		throws Exception {
		AIMovementAttribute fixture = new AIMovementAttribute();
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.EmptyStackException
		//       at java.util.Stack.peek(Unknown Source)
		//       at com.syntacticsugar.vooga.gameplayer.utilities.Path.getDestination(Path.java:39)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute.nextPoint(AIMovementAttribute.java:52)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute.move(AIMovementAttribute.java:72)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute.updateSelf(AIMovementAttribute.java:67)
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
		new org.junit.runner.JUnitCore().run(AIMovementAttributeTest.class);
	}
}