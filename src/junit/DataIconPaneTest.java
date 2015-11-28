package junit;

import java.io.File;
import authoring.library.DataIconPane;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>DataIconPaneTest</code> contains tests for the class <code>{@link DataIconPane}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class DataIconPaneTest {
	/**
	 * Run the DataIconPane() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testDataIconPane_1()
		throws Exception {

		DataIconPane result = new DataIconPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		//       at authoring.library.DataIconPane.<init>(DataIconPane.java:17)
		assertNotNull(result);
	}

	/**
	 * Run the void showImageOptionsFromXML(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testShowImageOptionsFromXML_1()
		throws Exception {
		DataIconPane fixture = new DataIconPane();
		File XMLDirectory = new File("");

		fixture.showImageOptionsFromXML(XMLDirectory);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		//       at authoring.library.DataIconPane.<init>(DataIconPane.java:17)
	}

	/**
	 * Run the void showImageOptionsFromXML(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testShowImageOptionsFromXML_2()
		throws Exception {
		DataIconPane fixture = new DataIconPane();
		File XMLDirectory = new File("");

		fixture.showImageOptionsFromXML(XMLDirectory);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		//       at authoring.library.DataIconPane.<init>(DataIconPane.java:17)
	}

	/**
	 * Run the void showImageOptionsFromXML(File) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testShowImageOptionsFromXML_3()
		throws Exception {
		DataIconPane fixture = new DataIconPane();
		File XMLDirectory = new File("");

		fixture.showImageOptionsFromXML(XMLDirectory);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		//       at authoring.library.DataIconPane.<init>(DataIconPane.java:17)
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
		new org.junit.runner.JUnitCore().run(DataIconPaneTest.class);
	}
}