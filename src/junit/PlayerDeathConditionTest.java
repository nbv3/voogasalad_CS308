package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

/**
 * The class <code>PlayerDeathConditionTest</code> contains tests for the class <code>{@link PlayerDeathCondition}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class PlayerDeathConditionTest {
	/**
	 * Run the PlayerDeathCondition() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testPlayerDeathCondition_1()
		throws Exception {

		PlayerDeathCondition result = new PlayerDeathCondition();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean checkCondition(IObjectCollection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testCheckCondition_1()
		throws Exception {
		PlayerDeathCondition fixture = new PlayerDeathCondition();
		IObjectCollection universe = EasyMock.createMock(IObjectCollection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		boolean result = fixture.checkCondition(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition.checkCondition(PlayerDeathCondition.java:22)
		assertTrue(result);
	}

	/**
	 * Run the boolean checkCondition(IObjectCollection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testCheckCondition_2()
		throws Exception {
		PlayerDeathCondition fixture = new PlayerDeathCondition();
		IObjectCollection universe = EasyMock.createMock(IObjectCollection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		boolean result = fixture.checkCondition(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition.checkCondition(PlayerDeathCondition.java:22)
		assertTrue(result);
	}

	/**
	 * Run the boolean checkCondition(IObjectCollection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testCheckCondition_3()
		throws Exception {
		PlayerDeathCondition fixture = new PlayerDeathCondition();
		IObjectCollection universe = EasyMock.createMock(IObjectCollection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		boolean result = fixture.checkCondition(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition.checkCondition(PlayerDeathCondition.java:22)
		assertTrue(result);
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
		new org.junit.runner.JUnitCore().run(PlayerDeathConditionTest.class);
	}
}