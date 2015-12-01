package authoring.level;

import java.nio.file.Path;
import java.nio.file.Paths;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class MapEditor implements IMapEditor {
	
	private static final Effect TILE_EFFECT = createEffect();
	private static final String DEFAULT_TILE_IMAGE = "gray.png";

	private ObservableSet<TileData> myTileSelection;
	private Map<TileData, AbstractIcon> myTileIconMap;

	private MapData myMapData;
	private int myMapSize;
	private double mapDisplayWidth = Screen.getPrimary().getVisualBounds().getHeight()/1.5;
	private GridPane myMapGrid;
	
	public MapEditor() throws Exception {
		myTileSelection = buildSelectionSet();
		myMapSize = inputMapSize();
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
		initializeMapView(loadedMap);
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
		double size = SliderDialogFactory.createSliderDialog("Input Map Size", 10, 30, 1);
		if (size == Double.MIN_VALUE) {
			throw new Exception("Must select a map size before editing");
		}
		return (int) size;
	}
	
	private void initializeMapView(MapData mapData) {
		myMapGrid.getChildren().clear();
		myTileIconMap = new HashMap<TileData, AbstractIcon>();
		myMapGrid.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		myMapGrid.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		for (int i=0; i<myMapSize; i++) {
			for (int j=0; j<myMapSize; j++) {
				TileData tile = mapData.getTileData(i, j);
				AbstractIcon icon = new ImageIcon(tile.getImagePath(),  mapDisplayWidth/(1.0*myMapSize));
				TileInfoTooltip tileInfo = new TileInfoTooltip(tile);
				myTileIconMap.put(tile, icon);
				Tooltip.install(icon, tileInfo);
				icon.setOnMouseEntered(e -> mouseOverHandler(tile, e.isControlDown(), e.isShiftDown()));
				icon.setOnMouseClicked(e -> mouseClickHandler(tile));
				myMapGrid.getChildren().add(icon);
				GridPane.setConstraints(icon, i, j, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS, null);
			}
		}
	}

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

	private void tileEffectOff(AbstractIcon icon) {
		icon.setEffect(null);
	}

	private void tileEffectOn(AbstractIcon icon) {
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
			if (tile.getImplementation().equals(TileImplementation.Scenery))
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
