package com.syntacticsugar.vooga.authoring.dragdrop;

import com.syntacticsugar.vooga.authoring.icon.Icon;

import com.syntacticsugar.vooga.authoring.icon.IconPane;
import com.syntacticsugar.vooga.authoring.level.map.MapView;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TileData;
import com.syntacticsugar.vooga.xml.data.TileImplementation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/*
 * NOTES:
 * 
 * This class implements the Drag and Drop function that handles copying of string data to the clipboard.
 * 		createDragClipBoards() needs to be implemented for: the Icon that is being dragged.
 * 		dragOverHandler(), dragEnteredHandler(), dragExitedHandler() must be implemented for: the Icon that is receiving the dragged item.
 * 		undoDragOverState(), setDragOverState() implements UI features to show effects of an object being dragged.
 * The dragDropped event method must be implemented individually.
 */

public class DragDropManager {
	private static DataFormat tileDataFormat = new DataFormat("TileData");
	private static DataFormat objectDataFormat = new DataFormat("ObjectData");

	public DragDropManager() {

		}
		

	public static void createClipboard(TileData tileData, ImageView previewTile, MouseEvent event) {
		Dragboard db = previewTile.startDragAndDrop(TransferMode.ANY);
		System.out.println("Dragboard and Clipboard created");
		ClipboardContent content = new ClipboardContent();
		content.put(tileDataFormat, tileData);
		db.setContent(content); 
		event.consume();
	}
	
	public static void createClipboard(ObjectData objectData, ImageView previewTile, MouseEvent event){
		Dragboard db = previewTile.startDragAndDrop(TransferMode.ANY);
		System.out.println("Dragboard and Clipboard created");
		ClipboardContent content = new ClipboardContent();
		content.put(objectDataFormat, objectData);
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
		//System.out.println(db);
		/* allow for both copying and moving, whatever user chooses */
		//System.out.println("Tile is ready to accept dragged object");
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

	public static void undoDragOverState(Icon icon) {
		icon.getImageView().setOpacity(1);
	}

	public static void setDragOverState(Icon icon) {
		icon.getImageView().setOpacity(0);
	}
}
