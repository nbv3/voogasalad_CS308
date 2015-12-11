// This entire file is part of my Masterpiece.
// Henry Yuen
package com.syntacticsugar.vooga.authoring.dragdrop;

import com.syntacticsugar.vooga.authoring.icon.Icon;
import com.syntacticsugar.vooga.util.properties.PropertiesManager;
import com.syntacticsugar.vooga.xml.data.IData;
import com.syntacticsugar.vooga.xml.data.TileData;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * This class implements the Drag and Drop function that handles copying of string data to the clipboard.
 * 		createDragClipBoards() needs to be implemented for: the Icon that is being dragged.
 * 		dragOverHandler(), handleDragEntered(), handleDragExited() must be implemented for: the Icon that is receiving the dragged item.
 * 		undoDragOverState(), setDragOverState() implements UI features to show effects of an object being dragged.
 * The dragDropped event method must be implemented individually.
 * @author Henry Yuen
 *
 */
public class DragDropManager {
	private static PropertiesManager propManager = new PropertiesManager("com/syntacticsugar/vooga/resources/View");
	private static DataFormat tileDataFormat = new DataFormat("TileData");
	private static DataFormat objectDataFormat = new DataFormat("ObjectData");
	private static ClipboardContent content; 
	private static Dragboard dragboard;

	public DragDropManager() {
		}
		
	private static Dragboard initNewClipboard(ImageView previewTile) {
		dragboard = previewTile.startDragAndDrop(TransferMode.ANY);
		content = new ClipboardContent();
		return dragboard;
	}
	
	public static void createClipboard(TileData tileData, ImageView previewTile, MouseEvent event) {
		dragboard = initNewClipboard(previewTile);
		content.put(tileDataFormat, tileData);
		dragboard.setContent(content); 
		event.consume();
	}
	
	public static void createClipboard(IData objectData, ImageView previewTile, MouseEvent event){
		dragboard = initNewClipboard(previewTile);
		content.put(objectDataFormat, objectData.getImagePath());
		dragboard.setContent(content); 
		event.consume();
	}
	
	public static void dragOverHandler(DragEvent event) {
		event.getDragboard();
		event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		event.consume();
	}

	public static void handleDragEntered(Icon icon, DragEvent event) {
		if (event.getGestureSource() != icon) setDragOverState(icon);
	}

	public static void handleDragExited(Icon icon, DragEvent event) {
		if (event.getGestureSource() != icon) undoDragOverState(icon);
	}

	private static void undoDragOverState(Icon icon) {
		icon.getImageView().setOpacity(Double.parseDouble(propManager.getProperty("DragOverOpacityHigh")));
	}

	private static void setDragOverState(Icon icon) {
		icon.getImageView().setOpacity(Double.parseDouble(propManager.getProperty("DragOverOpacityLow")));
	}
}
