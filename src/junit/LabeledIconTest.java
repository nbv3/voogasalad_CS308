package junit;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.*;
import authoring.library.LabeledIcon;
import static org.junit.Assert.*;

/**
 * The class <code>LabeledIconTest</code> contains tests for the class <code>{@link LabeledIcon}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class LabeledIconTest {
	/**
	 * Run the LabeledIcon(Image,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testLabeledIcon_1()
		throws Exception {
		Image image = new Image("");
		double dimension = 1.0;

		LabeledIcon result = new LabeledIcon(image, dimension);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: URL must not be empty
		//       at javafx.scene.image.Image.validateUrl(Unknown Source)
		//       at javafx.scene.image.Image.<init>(Unknown Source)
		assertNotNull(result);
	}

	/**
	 * Run the LabeledIcon(String,Image,double) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testLabeledIcon_2()
		throws Exception {
		String label = "";
		Image image = new Image("");
		double dimension = 1.0;

		LabeledIcon result = new LabeledIcon(label, image, dimension);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: URL must not be empty
		//       at javafx.scene.image.Image.validateUrl(Unknown Source)
		//       at javafx.scene.image.Image.<init>(Unknown Source)
		assertNotNull(result);
	}

	/**
	 * Run the String getIconLabel() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetIconLabel_1()
		throws Exception {
		LabeledIcon fixture = new LabeledIcon(new Image(""), 1.0);

		String result = fixture.getIconLabel();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: URL must not be empty
		//       at javafx.scene.image.Image.validateUrl(Unknown Source)
		//       at javafx.scene.image.Image.<init>(Unknown Source)
		assertNotNull(result);
	}

	/**
	 * Run the ImageView getImageView() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetImageView_1()
		throws Exception {
		LabeledIcon fixture = new LabeledIcon(new Image(""), 1.0);

		ImageView result = fixture.getImageView();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: URL must not be empty
		//       at javafx.scene.image.Image.validateUrl(Unknown Source)
		//       at javafx.scene.image.Image.<init>(Unknown Source)
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
		new org.junit.runner.JUnitCore().run(LabeledIconTest.class);
	}
}