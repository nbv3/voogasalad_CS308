package com.syntacticsugar.vooga.authoring.editor;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController;

import javafx.scene.control.Button;

public class TileToolBar extends EditorToolbar{

	public TileToolBar(List<DecoratorTile> myTileSelection, IGameMap myMap, ViewController viewController) {
		super("TileTools");
		createSelectAllOption(myTileSelection, myMap, viewController);
		createDeselectAllOption(myTileSelection, viewController);
	}
	
	private void createSelectAllOption(List<DecoratorTile> myTileSelection , IGameMap myMap, ViewController viewController) {
		Button selectAll = createToolbarItem("Select All");
		selectAll.setOnAction(e -> selectAllTiles(myTileSelection, myMap, viewController));
	}
	
	private void createDeselectAllOption(List<DecoratorTile> myTileSelection, ViewController viewController) {
		Button deselectAll = createToolbarItem("Clear All");
		deselectAll.setOnAction(e -> clearTileSelection(myTileSelection, viewController));
	}

	private void clearTileSelection(List<DecoratorTile> myTileSelection, ViewController viewController) {
		for (DecoratorTile tile: myTileSelection) {
			viewController.getViewMap().get(tile).getImageView().getStyleClass().add("tile-select-off");
			viewController.getViewMap().get(tile).getImageView().getStyleClass().remove("tile-select-on");	
		}
		myTileSelection.clear();
	}
	
	public void selectAllTiles(List<DecoratorTile> myTileSelection, IGameMap myMap, ViewController viewController) {
		myTileSelection.clear();
		for (int i = 0; i < myMap.getTiles().length; i++) {
			for (int j = 0; j < myMap.getTiles()[0].length; j++) {
				DecoratorTile tile = (DecoratorTile) myMap.getTiles()[i][j];
				toggleTileSelection(tile, myTileSelection, viewController);
			}
		}
	}
	
	private void toggleTileSelection(DecoratorTile t, List<DecoratorTile> myTileSelection, ViewController viewController) {
		if (myTileSelection.contains(t)) {
			myTileSelection.remove(t);
			viewController.getViewMap().get(t).getImageView().getStyleClass().add("tile-select-off");
			viewController.getViewMap().get(t).getImageView().getStyleClass().remove("tile-select-on");
		}
		
		else {
			myTileSelection.add(t);
			viewController.getViewMap().get(t).getImageView().getStyleClass().add("tile-select-on");
			viewController.getViewMap().get(t).getImageView().getStyleClass().remove("tile-select-off");	
		}
	}
	
}
