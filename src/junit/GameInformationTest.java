package junit;

import java.util.Collection;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.utilities.GameInformation;

/**
 * The class <code>GameInformationTest</code> contains tests for the class <code>{@link GameInformation}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class GameInformationTest {
	/**
	 * Run the void getObservableStats() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetObservableStats_1()
		throws Exception {
		GameInformation fixture = new GameInformation();

		fixture.getObservableStats();

		// add additional test code here
	}

	/**
	 * Run the void updateGameInformation(Collection<IGameObject>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateGameInformation_1()
		throws Exception {
		GameInformation fixture = new GameInformation();
		Collection<IGameObject> universe = EasyMock.createMock(Collection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateGameInformation(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.GameInformation.updateGameInformation(GameInformation.java:15)
	}

	/**
	 * Run the void updateGameInformation(Collection<IGameObject>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateGameInformation_2()
		throws Exception {
		GameInformation fixture = new GameInformation();
		Collection<IGameObject> universe = EasyMock.createMock(Collection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateGameInformation(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.GameInformation.updateGameInformation(GameInformation.java:15)
	}

	/**
	 * Run the void updateGameInformation(Collection<IGameObject>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateGameInformation_3()
		throws Exception {
		GameInformation fixture = new GameInformation();
		Collection<IGameObject> universe = EasyMock.createMock(Collection.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateGameInformation(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.GameInformation.updateGameInformation(GameInformation.java:15)
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
		new org.junit.runner.JUnitCore().run(GameInformationTest.class);
	}
}