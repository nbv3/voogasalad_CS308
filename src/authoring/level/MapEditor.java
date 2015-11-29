package authoring.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import authoring.data.MapData;
import authoring.data.TileData;
import authoring.data.TileImplementation;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MapEditor {
	
	private static final String DEFAULT_TILE_IMAGE = "default-tile.png";

	private Map<TileData, ImageView> myTileImageMap;
	private Collection<TileData> myTileSelection;

	private MapData myMapData;
	
	private int myMapSize;
	private double mapDisplayWidth = 600.0;
	private double mapDisplayHeight = 600.0;
	private GridPane myMapGrid;
	
	public MapEditor() throws NumberFormatException {
		myTileImageMap = new HashMap<TileData, ImageView>();
		myTileSelection = new ArrayList<TileData>();
		myMapSize = inputMapSize();
		initializeMap();
	}
	
	public double getMapDisplayWidth() {
		return mapDisplayWidth;
	}

	public void setMapDisplayWidth(double mapDisplayWidth) {
		this.mapDisplayWidth = mapDisplayWidth;
	}

	public double getMapDisplayHeight() {
		return mapDisplayHeight;
	}

	public void setMapDisplayHeight(double mapDisplayHeight) {
		this.mapDisplayHeight = mapDisplayHeight;
	}

	private int inputMapSize() throws NumberFormatException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setHeaderText(null);
		dialog.setContentText("Enter size of grid");
		dialog.setTitle("Input Map Size");
		dialog.showAndWait();
		String result = dialog.getResult();
		int size = 0;
		try {
			size = Integer.parseInt(result);
		} catch (NumberFormatException e) {
			
		}
		if (size < 5 || size > 49) {
			throw new NumberFormatException("Map size must be between 5 and 49");
		}
		return size;
	}

	private void initializeMap() {
		initializeMapData();
		initializeMapView();
	}
	
	private void initializeMapData() {
		myMapData = new MapData(myMapSize, DEFAULT_TILE_IMAGE);
	}
	
	private void initializeMapView() {
		myMapGrid = new GridPane();
		myMapGrid.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		myMapGrid.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		Image defaultImage = new Image(ResourceManager.getResource(this, DEFAULT_TILE_IMAGE));
		for (int i=0; i<myMapSize; i++) {
			for (int j=0; j<myMapSize; j++) {
				StackPane pane = new StackPane();
				TileData tile = myMapData.getTileData(i, j);
				ImageView iv = new ImageView(defaultImage);
				myTileImageMap.put(tile, iv);
				iv.setFitWidth(mapDisplayWidth/myMapSize);
				iv.setFitHeight(mapDisplayHeight/myMapSize);
				iv.setOnMouseEntered(e -> multiSelectTile(tile, e.isControlDown(), e.isShiftDown()));
				iv.setOnMouseClicked(e -> toggleTileSelection(tile));
				pane.getChildren().add(iv);
				pane.setAlignment(Pos.CENTER);
				myMapGrid.add(pane, i, j, 1, 1);
			}
		}
	}

	private void multiSelectTile(TileData tile, boolean controlDown, boolean shiftDown) {
		if (controlDown) {
			selectTile(tile);
		}
		else if (shiftDown) {
			deselectTile(tile);
		}
	}

	private void toggleTileSelection(TileData tile) {
		if (myTileSelection.contains(tile)) {
			deselectTile(tile);
		}
		else {
			selectTile(tile);
		}
	}

	private void selectTile(TileData tile) {
		if (!myTileSelection.contains(tile)) {
			myTileSelection.add(tile);
			tileEffectOn(myTileImageMap.get(tile));
		}
	}

	private void deselectTile(TileData tile) {
		if (myTileSelection.contains(tile)) {
			myTileSelection.remove(tile);
			tileEffectOff(myTileImageMap.get(tile));
		}
	}
	
	private void tileEffectOff(ImageView iv) {
		iv.setEffect(null);
	}

	private void tileEffectOn(ImageView iv) {
		InnerShadow shadow = new InnerShadow();
		shadow.setColor(Color.RED);
		shadow.setWidth(iv.getFitWidth());
		shadow.setHeight(iv.getFitHeight());
		iv.setEffect(shadow);
	}

	public void selectAllTiles() {
		for (TileData tile : myTileSelection) {
			tileEffectOff(myTileImageMap.get(tile));
		}
		myTileSelection.clear();
		for (TileData tile : myTileImageMap.keySet()) {
			selectTile(tile);
		}
	}
	
	public void clearAllTiles() {
		for (TileData tile : myTileImageMap.keySet()) {
			deselectTile(tile);
		}
	}
	
	public void applyTileChanges(TileImplementation impl, String imagePath) {
		Image newImage = null;
		try {
			newImage = new Image(getClass().getClassLoader().getResourceAsStream(imagePath));
		} catch (Exception e) {
			AlertBoxFactory.createObject("Must select an image.");
			return;
		}
		for (TileData tile : myTileSelection) {
			tile.setImplementation(impl);
			tile.setImagePath(imagePath);
			myTileImageMap.get(tile).setImage(newImage);
		}
		clearAllTiles(); // clear tile selection after having applied the changes.
	}
	
	public void markDestination() {
		
	}
	
	public void unmarkDestination() {
		
	}
	
	public GridPane getMapGrid() {
		return myMapGrid;
	}

}
