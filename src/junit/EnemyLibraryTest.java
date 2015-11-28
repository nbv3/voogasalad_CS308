package junit;

import java.io.File;
import org.junit.*;
import authoring.library.EnemyLibrary;
import static org.junit.Assert.*;

/**
 * The class <code>EnemyLibraryTest</code> contains tests for the class <code>{@link EnemyLibrary}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class EnemyLibraryTest {
	/**
	 * Run the EnemyLibrary(File) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testEnemyLibrary_1()
		throws Exception {
		File XMLDirectory = new File("");

		EnemyLibrary result = new EnemyLibrary(XMLDirectory);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.Error: Unresolved compilation problem: 
		//       The method showImageOptionsFromXML(File) is undefined for the type IconPane
		//       
		//       at authoring.library.AbstractObjectLibrary.populateOptionIcons(AbstractObjectLibrary.java:30)
		//       at authoring.library.AbstractObjectLibrary.<init>(AbstractObjectLibrary.java:16)
		//       at authoring.library.EnemyLibrary.<init>(EnemyLibrary.java:8)
		assertNotNull(result);
	}

	/**
	 * Run the void populateIconPane() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testPopulateIconPane_1()
		throws Exception {
		EnemyLibrary fixture = new EnemyLibrary(new File(""));

		fixture.populateIconPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.Error: Unresolved compilation problem: 
		//       The method showImageOptionsFromXML(File) is undefined for the type IconPane
		//       
		//       at authoring.library.AbstractObjectLibrary.populateOptionIcons(AbstractObjectLibrary.java:30)
		//       at authoring.library.AbstractObjectLibrary.<init>(AbstractObjectLibrary.java:16)
		//       at authoring.library.EnemyLibrary.<init>(EnemyLibrary.java:8)
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
		new org.junit.runner.JUnitCore().run(EnemyLibraryTest.class);
	}
}