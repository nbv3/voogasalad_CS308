package com.syntacticsugar.vooga.authoring.editor;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ToolbarOptions extends VBox{
	
	public ToolbarOptions(List<DecoratorTile> myTileSelection, IGameMap myMap){
		addToolbars(new LevelToolBar(), new TileToolBar(myTileSelection, myMap));
	}
	
	private void addToolbars(EditorToolbar... toolbars){
		for(EditorToolbar tool: toolbars){
			Label title = new Label(tool.getToolName());
			this.getChildren().addAll(title, tool);
		}
	}

}
