package editor.sidepanes;

import java.util.List;

import objects.SpawnerObject;
import tiles.DecoratorTile;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class TilePropertyPane {

	private List<DecoratorTile> tiles;
	private VBox tilePropertyPane;
	//private TilePane spawnQueuePane;
	
	public TilePropertyPane(List<DecoratorTile> tiles) {
		this.tiles = tiles;
		tilePropertyPane = new VBox();
		tilePropertyPane.getChildren().add(CreateSpawnQueuePane());
	}

	private TilePane CreateSpawnQueuePane() {
		TilePane spawnQueuePane = new TilePane();
		spawnQueuePane.getStyleClass().add("properties-module");
		for (SpawnerObject i: tiles.get(0).getSpawnerList()) {
			spawnQueuePane.getChildren().add(i.getImage());
		}
		
		return spawnQueuePane;
	}
	
	public VBox getPaneNode() {
		return tilePropertyPane;
	}
}
