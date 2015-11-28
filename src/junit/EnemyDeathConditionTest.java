package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.conditions.EnemyDeathCondition;
import com.syntacticsugar.vooga.gameplayer.universe.IObjectCollection;

/**
 * The class <code>EnemyDeathConditionTest</code> contains tests for the class <code>{@link EnemyDeathCondition}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class EnemyDeathConditionTest {
	/**
	 * Run the EnemyDeathCondition() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testEnemyDeathCondition_1()
		throws Exception {

		EnemyDeathCondition result = new EnemyDeathCondition();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean checkCondition(IObjectCollection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCheckCondition_1()
		throws Exception {
		EnemyDeathCondition fixture = new EnemyDeathCondition();
		IObjectCollection universe = EasyMock.createMock(IObjectCollection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		boolean result = fixture.checkCondition(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.conditions.EnemyDeathCondition.checkCondition(EnemyDeathCondition.java:22)
		assertTrue(result);
	}

	/**
	 * Run the boolean checkCondition(IObjectCollection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCheckCondition_2()
		throws Exception {
		EnemyDeathCondition fixture = new EnemyDeathCondition();
		IObjectCollection universe = EasyMock.createMock(IObjectCollection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		boolean result = fixture.checkCondition(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.conditions.EnemyDeathCondition.checkCondition(EnemyDeathCondition.java:22)
		assertTrue(result);
	}

	/**
	 * Run the boolean checkCondition(IObjectCollection) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testCheckCondition_3()
		throws Exception {
		EnemyDeathCondition fixture = new EnemyDeathCondition();
		IObjectCollection universe = EasyMock.createMock(IObjectCollection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		boolean result = fixture.checkCondition(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.conditions.EnemyDeathCondition.checkCondition(EnemyDeathCondition.java:22)
		assertTrue(result);
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
		new org.junit.runner.JUnitCore().run(EnemyDeathConditionTest.class);
	}
}