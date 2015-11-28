package junit;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import authoring.library.LabeledIcon;
import authoring.library.IconPane;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>IconPaneTest</code> contains tests for the class <code>{@link IconPane}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class IconPaneTest {
	/**
	 * Run the IconPane() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testIconPane_1()
		throws Exception {

		IconPane result = new IconPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the ScrollPane getIconPane() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetIconPane_1()
		throws Exception {
		IconPane fixture = new IconPane();

		ScrollPane result = fixture.getIconPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the Image getSelectedImage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSelectedImage_1()
		throws Exception {
		IconPane fixture = new IconPane();

		Image result = fixture.getSelectedImage();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the String getSelectedImagePath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetSelectedImagePath_1()
		throws Exception {
		IconPane fixture = new IconPane();

		String result = fixture.getSelectedImagePath();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the LabeledIcon makeAddButtonIcon() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testMakeAddButtonIcon_1()
		throws Exception {
		IconPane fixture = new IconPane();

		LabeledIcon result = fixture.makeAddButtonIcon();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
		assertNotNull(result);
	}

	/**
	 * Run the void registerAddButtonMouseClickHandler(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testRegisterAddButtonMouseClickHandler_1()
		throws Exception {
		IconPane fixture = new IconPane();
		String[] fileTypes = new String[] {};

		fixture.registerAddButtonMouseClickHandler(fileTypes);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
	}

	/**
	 * Run the void registerMouseClickHandler(LabeledIcon) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testRegisterMouseClickHandler_1()
		throws Exception {
		IconPane fixture = new IconPane();
		LabeledIcon icon = new LabeledIcon(new Image(""), 1.0);

		fixture.registerMouseClickHandler(icon);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
	}

	/**
	 * Run the void showImageOptions(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testShowImageOptions_1()
		throws Exception {
		IconPane fixture = new IconPane();
		String[] iconPath = new String[] {""};

		fixture.showImageOptions(iconPath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
	}

	/**
	 * Run the void showImageOptions(String[]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testShowImageOptions_2()
		throws Exception {
		IconPane fixture = new IconPane();
		String[] iconPath = new String[] {};

		fixture.showImageOptions(iconPath);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.ScrollPane
		//       at authoring.library.IconPane.<init>(IconPane.java:37)
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
		new org.junit.runner.JUnitCore().run(IconPaneTest.class);
	}
}