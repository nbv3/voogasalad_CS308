package junit;

import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;

/**
 * The class <code>MsgInputBoxFactoryTest</code> contains tests for the class <code>{@link MsgInputBoxFactory}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class MsgInputBoxFactoryTest {
	/**
	 * Run the MsgInputBoxFactory(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testMsgInputBoxFactory_1()
		throws Exception {
		String str = "";

		MsgInputBoxFactory result = new MsgInputBoxFactory(str);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory.<init>(MsgInputBoxFactory.java:21)
		assertNotNull(result);
	}

	/**
	 * Run the double getInputValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetInputValue_1()
		throws Exception {
		MsgInputBoxFactory fixture = new MsgInputBoxFactory("");

		double result = fixture.getInputValue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory.<init>(MsgInputBoxFactory.java:21)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double getInputValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetInputValue_2()
		throws Exception {
		MsgInputBoxFactory fixture = new MsgInputBoxFactory("");

		double result = fixture.getInputValue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory.<init>(MsgInputBoxFactory.java:21)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double getInputValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetInputValue_3()
		throws Exception {
		MsgInputBoxFactory fixture = new MsgInputBoxFactory("");

		double result = fixture.getInputValue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory.<init>(MsgInputBoxFactory.java:21)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double getInputValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetInputValue_4()
		throws Exception {
		MsgInputBoxFactory fixture = new MsgInputBoxFactory("");

		double result = fixture.getInputValue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory.<init>(MsgInputBoxFactory.java:21)
		assertEquals(0.0, result, 0.1);
	}

	/**
	 * Run the double getValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetValue_1()
		throws Exception {
		MsgInputBoxFactory fixture = new MsgInputBoxFactory("");

		double result = fixture.getValue();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.stage.Screen
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory.<init>(MsgInputBoxFactory.java:21)
		assertEquals(0.0, result, 0.1);
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
		new org.junit.runner.JUnitCore().run(MsgInputBoxFactoryTest.class);
	}
}