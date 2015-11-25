package com.syntacticsugar.vooga.authoring.editor;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ToolbarOptions extends VBox {
	
	public ToolbarOptions(List<DecoratorTile> myTileSelection, IGameMap myMap, ViewController viewController){
		addToolbars(new LevelToolBar(), new TileToolBar(myTileSelection, myMap, viewController));
	}
	
	private void addToolbars(EditorToolbar... toolbars){
		for(EditorToolbar tool: toolbars){
			Label title = new Label(tool.getToolName());
			this.getChildren().addAll(title, tool);
		}
	}

}
