package junit;

import java.util.Map;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent;

/**
 * The class <code>HealthChangeEventTest</code> contains tests for the class <code>{@link HealthChangeEvent}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:57 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class HealthChangeEventTest {
	/**
	 * Run the HealthChangeEvent(double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testHealthChangeEvent_1()
		throws Exception {
		double deltaHealth = 1.0;

		HealthChangeEvent result = new HealthChangeEvent(deltaHealth);

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getDeltaHealth(), 1.0);
	}

	/**
	 * Run the void executeEvent(Map<String,IAttribute>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testExecuteEvent_1()
		throws Exception {
		HealthChangeEvent fixture = new HealthChangeEvent(1.0);
		Map<String, IAttribute> targetAttributes = EasyMock.createMock(Map.class);
		// add mock object expectations here

		EasyMock.replay(targetAttributes);

		fixture.executeEvent(targetAttributes);

		// add additional test code here
		EasyMock.verify(targetAttributes);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent.executeEvent(HealthChangeEvent.java:20)
	}

	/**
	 * Run the double getDeltaHealth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	@Test
	public void testGetDeltaHealth_1()
		throws Exception {
		HealthChangeEvent fixture = new HealthChangeEvent(1.0);

		double result = fixture.getDeltaHealth();

		// add additional test code here
		assertEquals(1.0, result, 0.1);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
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
	 * @generatedBy CodePro at 11/28/15 12:57 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(HealthChangeEventTest.class);
	}
}