package junit;

import javafx.scene.input.KeyCode;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

/**
 * The class <code>WeaponAttributeTest</code> contains tests for the class <code>{@link WeaponAttribute}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class WeaponAttributeTest {
	/**
	 * Run the WeaponAttribute(String,double,KeyCode) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testWeaponAttribute_1()
		throws Exception {
		String bulletImagePath = "";
		double bulletDamage = 1.0;
		KeyCode fireKeyCode = KeyCode.A;

		WeaponAttribute result = new WeaponAttribute(bulletImagePath, bulletDamage, fireKeyCode);

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getParent());
	}

	/**
	 * Run the void processKeyInput() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testProcessKeyInput_1()
		throws Exception {
		WeaponAttribute fixture = new WeaponAttribute("", 1.0, KeyCode.A);
		fixture.updateSelf(EasyMock.createNiceMock(IGameUniverse.class));

		fixture.processKeyInput();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateKeyInput(WeaponAttribute.java:47)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateSelf(WeaponAttribute.java:35)
	}

	/**
	 * Run the void updateKeyInput(IKeyInputStorage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateKeyInput_1()
		throws Exception {
		WeaponAttribute fixture = new WeaponAttribute("", 1.0, KeyCode.A);
		fixture.updateSelf(EasyMock.createNiceMock(IGameUniverse.class));
		IKeyInputStorage universeKeyInput = EasyMock.createMock(IKeyInputStorage.class);
		// add mock object expectations here

		EasyMock.replay(universeKeyInput);

		fixture.updateKeyInput(universeKeyInput);

		// add additional test code here
		EasyMock.verify(universeKeyInput);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateKeyInput(WeaponAttribute.java:47)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateSelf(WeaponAttribute.java:35)
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
		WeaponAttribute fixture = new WeaponAttribute("", 1.0, KeyCode.A);
		fixture.updateSelf(EasyMock.createNiceMock(IGameUniverse.class));
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateKeyInput(WeaponAttribute.java:47)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateSelf(WeaponAttribute.java:35)
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateSelf_2()
		throws Exception {
		WeaponAttribute fixture = new WeaponAttribute("", 1.0, KeyCode.A);
		fixture.updateSelf(EasyMock.createNiceMock(IGameUniverse.class));
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateKeyInput(WeaponAttribute.java:47)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateSelf(WeaponAttribute.java:35)
	}

	/**
	 * Run the void updateSelf(IGameUniverse) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdateSelf_3()
		throws Exception {
		WeaponAttribute fixture = new WeaponAttribute("", 1.0, KeyCode.A);
		fixture.updateSelf(EasyMock.createNiceMock(IGameUniverse.class));
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateKeyInput(WeaponAttribute.java:47)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute.updateSelf(WeaponAttribute.java:35)
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
		new org.junit.runner.JUnitCore().run(WeaponAttributeTest.class);
	}
}