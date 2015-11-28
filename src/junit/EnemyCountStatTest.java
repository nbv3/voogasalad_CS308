package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.utilities.EnemyCountStat;

/**
 * The class <code>EnemyCountStatTest</code> contains tests for the class <code>{@link EnemyCountStat}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class EnemyCountStatTest {
	/**
	 * Run the EnemyCountStat() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testEnemyCountStat_1()
		throws Exception {

		EnemyCountStat result = new EnemyCountStat();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void receiveObject(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveObject_1()
		throws Exception {
		EnemyCountStat fixture = new EnemyCountStat();
		IGameObject object = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(object);

		fixture.receiveObject(object);

		// add additional test code here
		EasyMock.verify(object);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.EnemyCountStat.receiveObject(EnemyCountStat.java:16)
	}

	/**
	 * Run the void receiveObject(IGameObject) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testReceiveObject_2()
		throws Exception {
		EnemyCountStat fixture = new EnemyCountStat();
		IGameObject object = EasyMock.createMock(IGameObject.class);
		// add mock object expectations here

		EasyMock.replay(object);

		fixture.receiveObject(object);

		// add additional test code here
		EasyMock.verify(object);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.utilities.EnemyCountStat.receiveObject(EnemyCountStat.java:16)
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
		new org.junit.runner.JUnitCore().run(EnemyCountStatTest.class);
	}
}