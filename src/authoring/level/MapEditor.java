package authoring.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.SliderDialogFactory;

import authoring.data.MapData;
import authoring.data.TileData;
import authoring.data.TileImplementation;
import authoring.icons.implementations.AbstractIcon;
import authoring.icons.implementations.ImageIcon;
import javafx.geometry.Pos;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class MapEditor {
	
	private static final String DEFAULT_TILE_IMAGE = "gray.png";

	private Map<TileData, AbstractIcon> myTileImageMap;
	private Collection<TileData> myTileSelection;

	private MapData myMapData;
	
	private int myMapSize;
	private double mapDisplayWidth = 600.0;
	private double mapDisplayHeight = 600.0;
	private GridPane myMapGrid;
	
	public MapEditor() throws Exception {
		myTileImageMap = new HashMap<TileData, AbstractIcon>();
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

	private int inputMapSize() throws Exception {
		double size = SliderDialogFactory.createSliderDialog("Input Map Size", 10, 50, 10);
		if (size == Double.MIN_VALUE) {
			throw new Exception("Must select a map size before editing");
		}
		return (int) size;
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
		for (int i=0; i<myMapSize; i++) {
			for (int j=0; j<myMapSize; j++) {
				TileData tile = myMapData.getTileData(i, j);
				AbstractIcon icon = new ImageIcon(tile.getImagePath(), mapDisplayWidth/myMapSize-2);
				TileInfoTooltip tileInfo = new TileInfoTooltip(tile);
				Tooltip.install(icon, tileInfo);
				myTileImageMap.put(tile, icon);
				icon.setOnMouseEntered(e -> mouseOverHandler(tile, tileInfo, e.isControlDown(), e.isShiftDown()));
				icon.setOnMouseClicked(e -> mouseClickHandler(tile));
				myMapGrid.add(icon, i, j, 1, 1);
			}
		}
	}

	private void mouseOverHandler(TileData tile, TileInfoTooltip tileInfo, boolean isControlDown, boolean isShiftDown) {
		multiSelectTile(tile, isControlDown, isShiftDown);
	}
	
	private void multiSelectTile(TileData tile, boolean isControlDown, boolean isShiftDown) {
		if (isControlDown) {
			selectTile(tile);
		}
		else if (isShiftDown) {
			deselectTile(tile);
		}
	}

	private void mouseClickHandler(TileData tile) {
		toggleTileSelection(tile);
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
	
	private void tileEffectOff(AbstractIcon icon) {
		icon.setEffect(null);
	}

	private void tileEffectOn(AbstractIcon icon) {
		InnerShadow shadow = new InnerShadow();
		shadow.setColor(Color.RED);
		shadow.setWidth(icon.getWidth());
		shadow.setHeight(icon.getHeight());
		icon.setEffect(shadow);
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
			myTileImageMap.get(tile).getImageView().setImage(newImage);
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
