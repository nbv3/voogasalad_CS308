package editor;

import java.util.List;

import environment.GameMap;
import javafx.scene.control.Button;
import tiles.DecoratorTile;

public class TileToolBar extends EditorToolbar{

	public TileToolBar(List<DecoratorTile> myTileSelection, GameMap myMap) {
		super("TileTools");
		createSelectAllOption(myTileSelection, myMap);
		createDeselectAllOption(myTileSelection);
	}
	
	private void createSelectAllOption(List<DecoratorTile> myTileSelection , GameMap myMap) {
		Button selectAll = createToolbarItem("Select All");
		selectAll.setOnAction(e -> selectAllTiles(myTileSelection, myMap));
	}
	
	private void createDeselectAllOption(List<DecoratorTile> myTileSelection) {
		Button deselectAll = createToolbarItem("Clear All");
		deselectAll.setOnAction(e -> clearTileSelection(myTileSelection));
	}

	private void clearTileSelection(List<DecoratorTile> myTileSelection) {
		for (DecoratorTile tile: myTileSelection) {
			tile.getView().setOpacity(1);
		}
		myTileSelection.clear();
	}
	
	public void selectAllTiles(List<DecoratorTile> myTileSelection, GameMap myMap) {
		myTileSelection.clear();
		for (DecoratorTile tile: myMap.getTileMap().values()) {
			toggleTileSelection(tile, myTileSelection);
		}
	}
	
	private void toggleTileSelection(DecoratorTile t, List<DecoratorTile> myTileSelection) {
		if (myTileSelection.contains(t)) {
			myTileSelection.remove(t);
			t.getView().getStyleClass().add("tile-select-off");
			t.getView().getStyleClass().remove("tile-select-on");		
		}
		
		else {
			myTileSelection.add(t);
			t.getView().getStyleClass().add("tile-select-on");
			t.getView().getStyleClass().remove("tile-select-off");		
		}
	}
	
}
