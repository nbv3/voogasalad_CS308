package junit;

import javafx.event.ActionEvent;
import authoring.level.TileEditor;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>TileEditorTest</code> contains tests for the class <code>{@link TileEditor}</code>.
 *
 * @generatedBy CodePro at 11/28/15 12:56 AM
 * @author Henry
 * @version $Revision: 1.0 $
 */
public class TileEditorTest {
	/**
	 * Run the TileEditor(EventHandler<ActionEvent>,EventHandler<ActionEvent>) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testTileEditor_1()
		throws Exception {
		EventHandler<ActionEvent> selectAll = EasyMock.createMock(EventHandler.class);
		EventHandler<ActionEvent> clearAll = EasyMock.createMock(EventHandler.class);
		// add mock object expectations here

		EasyMock.replay(selectAll);
		EasyMock.replay(clearAll);

		TileEditor result = new TileEditor(selectAll, clearAll);

		// add additional test code here
		EasyMock.verify(selectAll);
		EasyMock.verify(clearAll);
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.ExceptionInInitializerError
		//       at authoring.level.TileEditor.buildSelectAllButton(TileEditor.java:39)
		//       at authoring.level.TileEditor.<init>(TileEditor.java:23)
		assertNotNull(result);
	}

	/**
	 * Run the VBox getContent() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 11/28/15 12:56 AM
	 */
	@Test
	public void testGetContent_1()
		throws Exception {
		TileEditor fixture = new TileEditor(EasyMock.createNiceMock(EventHandler.class), EasyMock.createNiceMock(EventHandler.class));

		VBox result = fixture.getContent();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NoClassDefFoundError: Could not initialize class javafx.scene.control.Button
		//       at authoring.level.TileEditor.buildSelectAllButton(TileEditor.java:39)
		//       at authoring.level.TileEditor.<init>(TileEditor.java:23)
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
		new org.junit.runner.JUnitCore().run(TileEditorTest.class);
	}
}