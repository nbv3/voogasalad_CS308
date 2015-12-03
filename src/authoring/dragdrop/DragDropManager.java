package authoring.dragdrop;

import authoring.icons.implementations.Icon;
import authoring.level.MapEditor;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/*
 * Basic Documentation:
 * This class implements the Drag and Drop function that handles copying of string data to the clipboard.
 * The dragDropped event method must be implemented individually.
 */

public class DragDropManager {
	public DragDropManager() {

	}
	
	public static void createDragClipBoards(Icon icon, MouseEvent event) {
		Dragboard db = icon.startDragAndDrop(TransferMode.ANY);
		System.out.println("Dragboard and Clipboard created");
		ClipboardContent content = new ClipboardContent();
		content.putString(icon.getImagePath());
		db.setContent(content);
		event.consume();
	}

	public static void dragOverHandler(DragEvent event) {
		/* data is dragged over the target */
		/*
		 * accept it only if it is not dragged from the same node and if it has
		 * a string data
		 */
		Dragboard db = event.getDragboard();
		System.out.println(db);
		/* allow for both copying and moving, whatever user chooses */
		System.out.println("Tile is ready to accept dragged object");
		event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

		event.consume();
	}

	public static void dragEnteredHandler(Icon icon, DragEvent event) {
		/* the drag-and-drop gesture entered the target */
		/* show to the user that it is an actual gesture target */

		if (event.getGestureSource() != icon && event.getDragboard().hasString()) {
			// Upgrade in the next revision.
			setDragOverState(icon);
		}
	}

	public static void dragExitedHandler(Icon icon, DragEvent event) {
		if (event.getGestureSource() != icon && event.getDragboard().hasString()) {
			undoDragOverState(icon);
		}
	}

	public static void dragDropHandler(MapEditor editor, Icon icon, DragEvent event) {
		/* data dropped */
		/* if there is a string data on dragboard, read it and use it */
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasString()) {
			icon.setOpacity(1);
			// May need to pass in both the image file and the tile
			// implementation

			// this.setImplementation();
			editor.setImagePath(db.getString());
			icon.setImage(new Image(editor.getClass().getClassLoader().getResourceAsStream(db.getString())));
			success = true;
		}
		/*
		 * let the source know whether the string was successfully transferred
		 * and used
		 */
		event.setDropCompleted(success);

		event.consume();
	}

	public static void undoDragOverState(Icon icon) {
		icon.setOpacity(1);
	}

	public static void setDragOverState(Icon icon) {
		icon.setOpacity(0);
	}
}
