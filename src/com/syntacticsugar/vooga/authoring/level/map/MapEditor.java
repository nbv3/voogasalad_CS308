package com.syntacticsugar.vooga.authoring.level.map;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.dragdrop.DragDropManager;
import com.syntacticsugar.vooga.authoring.dragdrop.ObjectClippableItem;
import com.syntacticsugar.vooga.authoring.dragdrop.TileClippableItem;
import com.syntacticsugar.vooga.authoring.icon.Icon;
import com.syntacticsugar.vooga.authoring.tooltips.TileInfoTooltip;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.SliderDialogFactory;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.TileData;
import com.syntacticsugar.vooga.xml.data.TileImplementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MapEditor implements IMapEditor {
	
	private static final Effect TILE_EFFECT = createEffect();
	private static final String DEFAULT_TILE_IMAGE = "scenery_gray.png";

	private ObservableSet<TileData> myTileSelection;
	private Map<TileData, Icon> myTileIconMap;

	private MapData myMapData;
	private int myMapSize;
	private GridPane myMapGrid;
	
	public MapEditor() throws Exception {
		myMapSize = inputMapSize();
		myTileSelection = buildSelectionSet();
		myMapData = new MapData(myMapSize, DEFAULT_TILE_IMAGE);
		myMapGrid = new GridPane();
		initializeMapView(myMapData);
	}

	private static Effect createEffect() {
		InnerShadow shadow = new InnerShadow();
		shadow.setColor(Color.RED);
		return shadow;
	}
	
	public void loadMapData(MapData loadedMap) {
		myTileSelection = buildSelectionSet();
		myMapData = loadedMap;
		myMapSize = loadedMap.getMapSize();
		initializeMapView(myMapData);
	}
	
	private ObservableSet<TileData> buildSelectionSet() {
		ObservableSet<TileData> set = FXCollections.observableSet();
		set.addListener(new SetChangeListener<TileData>() {
			@Override
			public void onChanged(javafx.collections.SetChangeListener.Change<? extends TileData> change) {
				if (change.wasAdded())
					tileEffectOn(myTileIconMap.get(change.getElementAdded()));
				else if (change.wasRemoved()) {
					tileEffectOff(myTileIconMap.get(change.getElementRemoved()));
				}
			}
		});
		return set;
	}
	
	private int inputMapSize() throws Exception {
		double size = SliderDialogFactory.createSliderDialog("Input Map Size", 10, 40, 1);
		if (size == Double.MIN_VALUE) {
			throw new Exception("Must select a map size before editing");
		}
		return (int) size;
	}
	
	private void initializeMapView(MapData mapData) {
		myMapGrid.getChildren().clear();
		myTileIconMap = new HashMap<>();
		for (int i=0; i<myMapSize; i++) {
			for (int j=0; j<myMapSize; j++) {
				TileData tile = mapData.getTileData(i, j);
				Icon icon = new Icon(tile.getImagePath());
				myTileIconMap.put(tile, icon);
				Tooltip.install(icon, new TileInfoTooltip(tile));
				icon.setOnMouseEntered(e -> mouseOverHandler(tile, e.isControlDown(), e.isShiftDown()));
				icon.setOnMouseClicked(e -> mouseClickHandler(tile));
				icon.setOnDragOver((DragEvent event) -> DragDropManager.dragOverHandler(event));
				icon.setOnDragEntered((DragEvent event) -> DragDropManager.dragEnteredHandler(icon, event)); 
				icon.setOnDragExited((DragEvent event) -> DragDropManager.dragExitedHandler(icon, event));
				icon.setOnDragDropped(new EventHandler<DragEvent>() {
					public void handle(DragEvent event) {
						/* data dropped */
						/* if there is a string data on dragboard, read it and use it */

						// To Do:
						// Localise the ClippableTile string

						Dragboard db = event.getDragboard();
						boolean success = false;
						if (db.hasContent(DataFormat.lookupMimeType("ClippableTile"))) {
							System.out.println("DB contains the dataformat.");
							DragDropManager.undoDragOverState(icon);				
							if(Clipboard.getSystemClipboard().getContent(DataFormat.lookupMimeType("ClippableTile")) instanceof TileClippableItem){
								System.out.println("Tile is being set from Clipboard");
								TileClippableItem tileItem = (TileClippableItem) Clipboard.getSystemClipboard().getContent(DataFormat.lookupMimeType("ClippableTile"));
								tile.setImagePath(tileItem.getImagePath());
								tile.setImplementation(TileImplementation.valueOf(tileItem.getImplementationType()));
								System.out.println("Tile item image Path is " + tileItem.getImagePath());
								icon.setImage(new Image(getClass().getClassLoader().getResourceAsStream(tileItem.getImagePath())));
								System.out.println("Tile Implementation is" +tile.getImplementation());
							} else {

								// To implement ObjectClippable Item
								ObjectClippableItem objectItem = (ObjectClippableItem) Clipboard.getSystemClipboard().getContent(DataFormat.lookupMimeType("ClippableTile"));
								tile.setImagePath(objectItem.getImagePath());


							}
							success = true;
						}
						/* let the source know whether the string was successfully 
						 * transferred and used */
						event.setDropCompleted(success);

						event.consume();
					}

				});
				myMapGrid.add(icon, i, j, 1, 1);
			}
		}
	}

	
//	private TileImplementation recreateImplementationObject(StringBuilder newPathName) {
//		TileImplementation enumTileImp = TileImplementation.valueOf(newPathName.toString());
//		return enumTileImp;
//	}
//
//	private StringBuilder extractImplementationType(Dragboard db) {
//		// Must ensure that each image file has path_ or scenery_ in front of it
//		String pathType = db.getString().split("_")[0];
//		char firstChar = Character.toUpperCase(pathType.charAt(0));
//		StringBuilder newPathName = new StringBuilder();
//		newPathName.append(firstChar);
//		for(int i=1;i<pathType.length();i++){
//			newPathName.append(pathType.charAt(i));
//		}
//		return newPathName;
//	}
	
	private void mouseOverHandler(TileData tile, boolean isControlDown, boolean isShiftDown) {
		multiSelectTile(tile, isControlDown, isShiftDown);
	}

	private void mouseClickHandler(TileData tile) {
		toggleTileSelection(tile);
	}
	
	private void multiSelectTile(TileData tile, boolean isControlDown, boolean isShiftDown) {
		if (isControlDown) {
			myTileSelection.add(tile);
		}
		else if (isShiftDown) {
			myTileSelection.remove(tile);
		}
	}
	
	private void toggleTileSelection(TileData tile) {
		if (myTileSelection.contains(tile))
				myTileSelection.remove(tile);
		else
			myTileSelection.add(tile);
	}

	private void tileEffectOff(Icon icon) {
		icon.setEffect(null);
	}

	private void tileEffectOn(Icon icon) {
		icon.setEffect(TILE_EFFECT);
	}

	@Override
	public void selectAllTiles() {
		myTileSelection.clear();
		myTileSelection.addAll(myMapData.getTiles());
	}

	@Override
	public void clearAllTiles() {
		myTileSelection.clear();
	}

	@Override
	public void setAsDestination(boolean isDestination) {
		boolean alertFlag = false;
		for (TileData tile : myTileSelection) {
			if (tile.getImplementation().equals(TileImplementation.Scenery) && isDestination)
				alertFlag = true;
			else 
				tile.setDestination(isDestination);
		}
		if (alertFlag)
			AlertBoxFactory.createObject("Can only set Path tiles as destinations.");
	}

	@Override
	public void setImplementation(TileImplementation impl) {
		for (TileData tile : myTileSelection) {
			tile.setImplementation(impl);
		}
	}

	@Override
	public void setImagePath(String imagePath) {
		for (TileData tile : myTileSelection) {
			tile.setImagePath(imagePath);
			myTileIconMap.get(tile).setImage(new Image(ResourceManager.getResource(this, imagePath)));
		}
	}

	public GridPane getContent() {
		return myMapGrid;
	}
	
	public MapData getMapData() {
		return myMapData;
	}

}
