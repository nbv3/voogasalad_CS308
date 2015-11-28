package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.engine.modules.StateEngine;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

/**
 * The class <code>StateEngineTest</code> contains tests for the class <code>{@link StateEngine}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class StateEngineTest {
	/**
	 * Run the void updateState(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateState_1()
		throws Exception {
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		StateEngine.updateState(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.engine.modules.StateEngine.updateState(StateEngine.java:9)
	}

	/**
	 * Run the void updateState(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateState_2()
		throws Exception {
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		StateEngine.updateState(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.engine.modules.StateEngine.updateState(StateEngine.java:9)
	}

	/**
	 * Run the void updateState(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateState_3()
		throws Exception {
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		StateEngine.updateState(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.engine.modules.StateEngine.updateState(StateEngine.java:9)
	}

	/**
	 * Run the void updateState(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateState_4()
		throws Exception {
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		StateEngine.updateState(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.engine.modules.StateEngine.updateState(StateEngine.java:9)
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
		new org.junit.runner.JUnitCore().run(StateEngineTest.class);
	}
}