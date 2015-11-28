package junit;

import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.attribute.control.KeyData;

/**
 * The class <code>KeyDataTest</code> contains tests for the class <code>{@link KeyData}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class KeyDataTest {
	/**
	 * Run the KeyData(KeyCode,EventType<KeyEvent>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testKeyData_1()
		throws Exception {
		KeyCode code = KeyCode.A;
		EventType<KeyEvent> type = new EventType();

		KeyData result = new KeyData(code, type);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		KeyData fixture = new KeyData(KeyCode.A, new EventType());
		Object o = new KeyData(KeyCode.A, new EventType());

		boolean result = fixture.equals(o);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: EventType "javafx.event.EventType@7387fead"with parent "EVENT" already exists
		//       at javafx.event.EventType.register(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		KeyData fixture = new KeyData(KeyCode.A, new EventType());
		Object o = new KeyData(KeyCode.A, new EventType());

		boolean result = fixture.equals(o);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: EventType "javafx.event.EventType@78f381ad"with parent "EVENT" already exists
		//       at javafx.event.EventType.register(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		KeyData fixture = new KeyData(KeyCode.A, new EventType());
		Object o = new KeyData(KeyCode.A, new EventType());

		boolean result = fixture.equals(o);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: EventType "javafx.event.EventType@1ee90174"with parent "EVENT" already exists
		//       at javafx.event.EventType.register(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		assertTrue(result);
	}

	/**
	 * Run the KeyCode getKeyCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetKeyCode_1()
		throws Exception {
		KeyData fixture = new KeyData(KeyCode.A, new EventType());

		KeyCode result = fixture.getKeyCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: EventType "javafx.event.EventType@3de77374"with parent "EVENT" already exists
		//       at javafx.event.EventType.register(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		assertNotNull(result);
	}

	/**
	 * Run the EventType<KeyEvent> getKeyEventType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetKeyEventType_1()
		throws Exception {
		KeyData fixture = new KeyData(KeyCode.A, new EventType());

		EventType<KeyEvent> result = fixture.getKeyEventType();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: EventType "javafx.event.EventType@49f0b4e0"with parent "EVENT" already exists
		//       at javafx.event.EventType.register(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		KeyData fixture = new KeyData(KeyCode.A, new EventType());

		int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: EventType "javafx.event.EventType@78442aca"with parent "EVENT" already exists
		//       at javafx.event.EventType.register(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		//       at javafx.event.EventType.<init>(Unknown Source)
		assertEquals(0, result);
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
		new org.junit.runner.JUnitCore().run(KeyDataTest.class);
	}
}