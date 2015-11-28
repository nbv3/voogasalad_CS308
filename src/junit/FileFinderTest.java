package junit;

import java.io.File;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.util.filefinder.FileFinder;

/**
 * The class <code>FileFinderTest</code> contains tests for the class <code>{@link FileFinder}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class FileFinderTest {
	/**
	 * Run the FileFinder() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testFileFinder_1()
		throws Exception {

		FileFinder result = new FileFinder();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> chooseXML() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testChooseXML_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.chooseXML();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getEnemyImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetEnemyImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getEnemyImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the String getGameXML(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetGameXML_1()
		throws Exception {
		FileFinder fixture = new FileFinder();
		String name = "";

		String result = fixture.getGameXML(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getGameXMLFiles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetGameXMLFiles_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getGameXMLFiles();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<String> getGameXMLsContents() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetGameXMLsContents_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<String> result = fixture.getGameXMLsContents();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getImages(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();
		String path = "";

		List<File> result = fixture.getImages(path);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getImages(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetImages_2()
		throws Exception {
		FileFinder fixture = new FileFinder();
		String path = "";

		List<File> result = fixture.getImages(path);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getItemImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetItemImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getItemImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getObstacleImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetObstacleImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getObstacleImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getPlayerImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPlayerImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getPlayerImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getProjectileImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetProjectileImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getProjectileImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the String getSaveXML(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSaveXML_1()
		throws Exception {
		FileFinder fixture = new FileFinder();
		String name = "";

		String result = fixture.getSaveXML(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getSaveXMLFiles() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSaveXMLFiles_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getSaveXMLFiles();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<String> getSaveXMLsContents() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSaveXMLsContents_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<String> result = fixture.getSaveXMLsContents();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getTileImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetTileImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getTileImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
		assertNotNull(result);
	}

	/**
	 * Run the List<File> getTowerImages() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetTowerImages_1()
		throws Exception {
		FileFinder fixture = new FileFinder();

		List<File> result = fixture.getTowerImages();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key tiles
		//       at java.util.ResourceBundle.getObject(Unknown Source)
		//       at java.util.ResourceBundle.getString(Unknown Source)
		//       at com.syntacticsugar.vooga.util.filefinder.FileFinder.<init>(FileFinder.java:38)
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
		new org.junit.runner.JUnitCore().run(FileFinderTest.class);
	}
}