package junit;

import javafx.scene.input.KeyCode;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.IControlAction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.MoveDownCardinal;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

/**
 * The class <code>MovementControlAttributeTest</code> contains tests for the class <code>{@link MovementControlAttribute}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class MovementControlAttributeTest {
	/**
	 * Run the MovementControlAttribute() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testMovementControlAttribute_1()
		throws Exception {

		MovementControlAttribute result = new MovementControlAttribute();

		// add additional test code here
		assertNotNull(result);
		assertEquals(3.0, result.getSpeed(), 1.0);
		assertEquals(0.0, result.getYVelocity(), 1.0);
		assertEquals(0.0, result.getXVelocity(), 1.0);
		assertEquals(null, result.getParent());
	}

	/**
	 * Run the void addKeyBinding(KeyCode,IControlAction) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testAddKeyBinding_1()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();
		KeyCode code = KeyCode.A;
		IControlAction action = new MoveDownCardinal();

		fixture.addKeyBinding(code, action);

		// add additional test code here
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
		MovementControlAttribute fixture = new MovementControlAttribute();

		fixture.move();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute.move(MovementControlAttribute.java:77)
	}

	/**
	 * Run the void processKeyInput() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testProcessKeyInput_1()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();

		fixture.processKeyInput();

		// add additional test code here
	}

	/**
	 * Run the void processKeyInput() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testProcessKeyInput_2()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();

		fixture.processKeyInput();

		// add additional test code here
	}

	/**
	 * Run the void removeKeyBinding(KeyCode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testRemoveKeyBinding_1()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();
		KeyCode code = KeyCode.A;

		fixture.removeKeyBinding(code);

		// add additional test code here
	}

	/**
	 * Run the void setDefaultKeyBindings() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetDefaultKeyBindings_1()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();

		fixture.setDefaultKeyBindings();

		// add additional test code here
	}

	/**
	 * Run the void updateKeyInput(IKeyInputStorage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateKeyInput_1()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();
		IKeyInputStorage universeKeyInput = EasyMock.createMock(IKeyInputStorage.class);
		// add mock object expectations here

		EasyMock.replay(universeKeyInput);

		fixture.updateKeyInput(universeKeyInput);

		// add additional test code here
		EasyMock.verify(universeKeyInput);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute.updateKeyInput(MovementControlAttribute.java:51)
	}

	/**
	 * Run the void updateKeyInput(IKeyInputStorage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateKeyInput_2()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();
		IKeyInputStorage universeKeyInput = EasyMock.createMock(IKeyInputStorage.class);
		// add mock object expectations here

		EasyMock.replay(universeKeyInput);

		fixture.updateKeyInput(universeKeyInput);

		// add additional test code here
		EasyMock.verify(universeKeyInput);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute.updateKeyInput(MovementControlAttribute.java:51)
	}

	/**
	 * Run the void updateKeyInput(IKeyInputStorage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testUpdateKeyInput_3()
		throws Exception {
		MovementControlAttribute fixture = new MovementControlAttribute();
		IKeyInputStorage universeKeyInput = EasyMock.createMock(IKeyInputStorage.class);
		// add mock object expectations here

		EasyMock.replay(universeKeyInput);

		fixture.updateKeyInput(universeKeyInput);

		// add additional test code here
		EasyMock.verify(universeKeyInput);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute.updateKeyInput(MovementControlAttribute.java:51)
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
		MovementControlAttribute fixture = new MovementControlAttribute();
		IGameUniverse universe = EasyMock.createMock(IGameUniverse.class);
		// add mock object expectations here

		EasyMock.replay(universe);

		fixture.updateSelf(universe);

		// add additional test code here
		EasyMock.verify(universe);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute.updateKeyInput(MovementControlAttribute.java:51)
		//       at com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute.updateSelf(MovementControlAttribute.java:67)
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
		new org.junit.runner.JUnitCore().run(MovementControlAttributeTest.class);
	}
}