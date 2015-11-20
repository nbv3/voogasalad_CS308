package editor;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import simple.universe.map.ISimpleGameMap;
import tiles.DecoratorTile;

public class ToolbarOptions extends VBox{
	
	public ToolbarOptions(List<DecoratorTile> myTileSelection, ISimpleGameMap myMap){
		addToolbars(new LevelToolBar(), new TileToolBar(myTileSelection, myMap));
	}
	
	private void addToolbars(EditorToolbar... toolbars){
		for(EditorToolbar tool: toolbars){
			Label title = new Label(tool.getToolName());
			this.getChildren().addAll(title, tool);
		}
	}

}
