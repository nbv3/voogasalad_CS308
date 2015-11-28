package authoring.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import authoring.data.TileData;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class MapEditor {

	private Map<TileData, ImageView> myTileImageMap;
	private Collection<TileData> myTileSelection;
	
	private TileData[][] myMapData;
	
	private int myMapSize;
	private int mapDisplayWidth = 600;;
	private int mapDisplayHeight = 600;
	private GridPane myMapGrid;
	
	
	public MapEditor() throws NumberFormatException {
		myTileImageMap = new HashMap<TileData, ImageView>();
		myTileSelection = new ArrayList<TileData>();
		myMapSize = inputMapSize();
		initializeMap();
	}
	public int getMapDisplayWidth() {
		return mapDisplayWidth;
	}

	public void setMapDisplayWidth(int mapDisplayWidth) {
		this.mapDisplayWidth = mapDisplayWidth;
	}

	public int getMapDisplayHeight() {
		return mapDisplayHeight;
	}

	public void setMapDisplayHeight(int mapDisplayHeight) {
		this.mapDisplayHeight = mapDisplayHeight;
	}

	public void applyTileChanges(String impl, String imagePath) {
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
			throw new NumberFormatException("Input a positive integer");
		}
		return size;
	}

	private void initializeMap() {
		myMapData = new TileData[myMapSize][myMapSize];
		myMapGrid = new GridPane();
		myMapGrid.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		myMapGrid.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		String default_img_path = "scenery_grass_1.png";
		Image default_img = new Image(getClass().getClassLoader().getResourceAsStream(default_img_path));
		for (int i=0; i<myMapSize; i++) {
			for (int j=0; j<myMapSize; j++) {
				StackPane pane = new StackPane();
				TileData tile = new TileData(default_img_path);
				myMapData[i][j] = tile;
				ImageView iv = new ImageView(default_img);
				myTileImageMap.put(tile, iv);
				iv.setFitWidth(mapDisplayWidth/myMapSize);
				iv.setFitHeight(mapDisplayHeight/myMapSize);
				iv.setOnMouseEntered(e -> multiSelectTile(tile, iv, e.isControlDown(), e.isShiftDown()));
				iv.setOnMouseClicked(e -> toggleTileSelection(tile, iv));
				pane.getChildren().add(iv);
				pane.setAlignment(Pos.CENTER);
				myMapGrid.add(pane, i, j, 1, 1);
			}
		}
	}

	private void multiSelectTile(TileData tile, ImageView tileView, boolean controlDown, boolean shiftDown) {
		if (controlDown) {
			selectTile(tile, tileView);
		}
		else if (shiftDown) {
			deselectTile(tile, tileView);
		}
	}

	private void toggleTileSelection(TileData tile, ImageView tileView) {
		if (myTileSelection.contains(tile)) {
			deselectTile(tile, tileView);
		}
		else {
			selectTile(tile, tileView);
		}
	}

	private void selectTile(TileData tile, ImageView tileView) {
		if (!myTileSelection.contains(tile)) {
			myTileSelection.add(tile);
			tileOpacityOn(tileView);
		}
	}

	private void deselectTile(TileData tile, ImageView tileView) {
		if (myTileSelection.contains(tile)) {
			myTileSelection.remove(tile);
			tileOpacityOff(tileView);
		}
	}
	
	private void tileOpacityOff(ImageView iv) {
		iv.getStyleClass().remove("tile-select-on");
	}

	private void tileOpacityOn(ImageView iv) {
		iv.getStyleClass().add("tile-select-on");
	}

	public void selectAllTiles() {
		for (TileData tile : myTileSelection) {
			tileOpacityOff(myTileImageMap.get(tile));
		}
		myTileSelection.clear();
		for (TileData tile : myTileImageMap.keySet()) {
			selectTile(tile, myTileImageMap.get(tile));
		}
	}
	
	public void clearAllTiles() {
		for (TileData tile : myTileImageMap.keySet()) {
			deselectTile(tile, myTileImageMap.get(tile));
		}
	}
	
	public GridPane getMapGrid() {
		return myMapGrid;
	}

}
