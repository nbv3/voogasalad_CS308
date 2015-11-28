package junit;

import javafx.geometry.Point2D;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.objects.AbstractViewableObject;
import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;

/**
 * The class <code>AbstractViewableObjectTest</code> contains tests for the class <code>{@link AbstractViewableObject}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class AbstractViewableObjectTest {
	/**
	 * Run the BoundingBox getBoundingBox() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetBoundingBox_1()
		throws Exception {
		AbstractViewableObject fixture = new GameObject(new ObjectData(), new Point2D(1.0, 1.0), 1.0, 1.0);

		BoundingBox result = fixture.getBoundingBox();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1.0, result.getHeight(), 1.0);
		assertEquals(1.0, result.getWidth(), 1.0);
		assertEquals(0.0, result.getRotate(), 1.0);
		assertEquals(0, result.countObservers());
		assertEquals(false, result.hasChanged());
	}

	/**
	 * Run the String getPath() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetPath_1()
		throws Exception {
		AbstractViewableObject fixture = new GameObject(new ObjectData(), new Point2D(1.0, 1.0), 1.0, 1.0);

		String result = fixture.getPath();

		// add additional test code here
		assertEquals(null, result);
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
		new org.junit.runner.JUnitCore().run(AbstractViewableObjectTest.class);
	}
}