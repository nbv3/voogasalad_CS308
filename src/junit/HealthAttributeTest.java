package junit;

import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

/**
 * The class <code>HealthAttributeTest</code> contains tests for the class <code>{@link HealthAttribute}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class HealthAttributeTest {
	/**
	 * Run the HealthAttribute(double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testHealthAttribute_1()
		throws Exception {
		double maxHealth = 1.0;

		HealthAttribute result = new HealthAttribute(maxHealth);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getParent());
	}

	/**
	 * Run the void changeHealth(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testChangeHealth_1()
		throws Exception {
		HealthAttribute fixture = new HealthAttribute(1.0);
		double healthChange = -4.9E-324;

		fixture.changeHealth(healthChange);

		// add additional test code here
	}

	/**
	 * Run the void changeHealth(double) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testChangeHealth_2()
		throws Exception {
		HealthAttribute fixture = new HealthAttribute(1.0);
		double healthChange = 1.0;

		fixture.changeHealth(healthChange);

		// add additional test code here
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
		HealthAttribute fixture = new HealthAttribute(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateSelf_2()
		throws Exception {
		HealthAttribute fixture = new HealthAttribute(1.0);
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
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
		new org.junit.runner.JUnitCore().run(HealthAttributeTest.class);
	}
}