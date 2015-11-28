package junit;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.junit.*;
import authoring.level.MapEditor;
import static org.junit.Assert.*;

/**
 * The class <code>MapEditorTest</code> contains tests for the class <code>{@link MapEditor}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class MapEditorTest {
	/**
	 * Run the MapEditor() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testMapEditor_1()
		throws Exception {

		MapEditor result = new MapEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		assertNotNull(result);
	}

	/**
	 * Run the MapEditor() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testMapEditor_2()
		throws Exception {

		MapEditor result = new MapEditor();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		assertNotNull(result);
	}

	/**
	 * Run the int getMapDisplayHeight() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetMapDisplayHeight_1()
		throws Exception {
		MapEditor fixture = new MapEditor();
		fixture.setMapDisplayWidth(1);
		fixture.setMapDisplayHeight(1);

		int result = fixture.getMapDisplayHeight();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		assertEquals(0, result);
	}

	/**
	 * Run the int getMapDisplayWidth() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetMapDisplayWidth_1()
		throws Exception {
		MapEditor fixture = new MapEditor();
		fixture.setMapDisplayWidth(1);
		fixture.setMapDisplayHeight(1);

		int result = fixture.getMapDisplayWidth();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		assertEquals(0, result);
	}

	/**
	 * Run the GridPane getMapGrid() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetMapGrid_1()
		throws Exception {
		MapEditor fixture = new MapEditor();
		fixture.setMapDisplayWidth(1);
		fixture.setMapDisplayHeight(1);

		GridPane result = fixture.getMapGrid();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		assertNotNull(result);
	}

	/**
	 * Run the VBox getTileControls() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetTileControls_1()
		throws Exception {
		MapEditor fixture = new MapEditor();
		fixture.setMapDisplayWidth(1);
		fixture.setMapDisplayHeight(1);

		VBox result = fixture.getTileControls();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
		assertNotNull(result);
	}

	/**
	 * Run the void setMapDisplayHeight(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetMapDisplayHeight_1()
		throws Exception {
		MapEditor fixture = new MapEditor();
		fixture.setMapDisplayWidth(1);
		fixture.setMapDisplayHeight(1);
		int mapDisplayHeight = 1;

		fixture.setMapDisplayHeight(mapDisplayHeight);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
	}

	/**
	 * Run the void setMapDisplayWidth(int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testSetMapDisplayWidth_1()
		throws Exception {
		MapEditor fixture = new MapEditor();
		fixture.setMapDisplayWidth(1);
		fixture.setMapDisplayHeight(1);
		int mapDisplayWidth = 1;

		fixture.setMapDisplayWidth(mapDisplayWidth);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.DialogPane
		//       at javafx.scene.control.Dialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at javafx.scene.control.TextInputDialog.<init>(Unknown Source)
		//       at authoring.level.MapEditor.inputMapSize(MapEditor.java:139)
		//       at authoring.level.MapEditor.<init>(MapEditor.java:49)
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
		new org.junit.runner.JUnitCore().run(MapEditorTest.class);
	}
}