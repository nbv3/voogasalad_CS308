package junit;

import java.util.Enumeration;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.ResourceManager;

/**
 * The class <code>ResourceManagerTest</code> contains tests for the class <code>{@link ResourceManager}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ResourceManagerTest {
	/**
	 * Run the ResourceManager() constructor test.
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testResourceManager_1()
		throws Exception {
		ResourceManager result = new ResourceManager();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the boolean containsKey(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testContainsKey_1()
		throws Exception {
		String key = "";

		boolean result = ResourceManager.containsKey(key);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean containsKey(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testContainsKey_2()
		throws Exception {
		String key = "";

		boolean result = ResourceManager.containsKey(key);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the Enumeration<String> getKeys() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetKeys_1()
		throws Exception {

		Enumeration<String> result = ResourceManager.getKeys();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.hasMoreElements());
		assertEquals("type_editor_y", result.nextElement());
	}

	/**
	 * Run the String getString(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetString_1()
		throws Exception {
		String key = "";

		String result = ResourceManager.getString(key);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key 
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.ResourceManager.getString(ResourceManager.java:15)
		assertNotNull(result);
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
		new org.junit.runner.JUnitCore().run(ResourceManagerTest.class);
	}
}