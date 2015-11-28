package junit;

import javafx.stage.Stage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>MainTest</code> contains tests for the class <code>{@link Main}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class MainTest {
	/**
	 * Run the void main(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testMain_1()
		throws Exception {
		String[] args = new String[] {};

		Main.main(args);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.RuntimeException: No toolkit found
		//       at com.sun.javafx.tk.Toolkit.getToolkit(Unknown Source)
		//       at com.sun.javafx.application.PlatformImpl.startup(Unknown Source)
		//       at com.sun.javafx.application.LauncherImpl.startToolkit(Unknown Source)
		//       at com.sun.javafx.application.LauncherImpl.launchApplication1(Unknown Source)
		//       at com.sun.javafx.application.LauncherImpl.lambda$launchApplication$156(Unknown Source)
		//       at java.lang.Thread.run(Unknown Source)
	}

	/**
	 * Run the void start(Stage) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testStart_1()
		throws Exception {
		Main fixture = new Main();
		Stage stage = new Stage();

		fixture.start(stage);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.stage.Window.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
		//       at javafx.stage.Stage.<init>(Unknown Source)
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
		new org.junit.runner.JUnitCore().run(MainTest.class);
	}
}