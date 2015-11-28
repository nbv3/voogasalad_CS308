package junit;

import java.util.Observable;
import javafx.geometry.Point2D;
import javafx.scene.layout.StackPane;
import org.junit.*;
import static org.junit.Assert.*;
import com.syntacticsugar.vooga.gameplayer.objects.BoundingBox;
import com.syntacticsugar.vooga.gameplayer.view.implementation.GameView;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ObjectView;

/**
 * The class <code>ObjectViewTest</code> contains tests for the class <code>{@link ObjectView}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:55 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class ObjectViewTest {
	/**
	 * Run the ObjectView(String,BoundingBox,GameView) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testObjectView_1()
		throws Exception {
		String path = "";
		BoundingBox box = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		GameView myGameView = new GameView(1.0);

		ObjectView result = new ObjectView(path, box, myGameView);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		assertNotNull(result);
	}

	/**
	 * Run the StackPane getViewPane() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testGetViewPane_1()
		throws Exception {
		ObjectView fixture = new ObjectView("", new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0), new GameView(1.0));

		StackPane result = fixture.getViewPane();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
		assertNotNull(result);
	}

	/**
	 * Run the void update(Observable,Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:55 AM
	 */
	@Test
	public void testUpdate_1()
		throws Exception {
		ObjectView fixture = new ObjectView("", new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0), new GameView(1.0));
		Observable obs = new BoundingBox(new Point2D(1.0, 1.0), 1.0, 1.0);
		Object arg1 = new Object();

		fixture.update(obs, arg1);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class com.syntacticsugar.vooga.gameplayer.view.implementation.GameView
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
		new org.junit.runner.JUnitCore().run(ObjectViewTest.class);
	}
}