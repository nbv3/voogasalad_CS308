package editor.sidepanes;

import java.util.List;

import objects.SpawnerObject;
import tiles.DecoratorTile;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		if (tiles.size() != 1) {
			showAlertBox("Cannot view properties for multiple tiles");
			return spawnQueuePane;
		}
		
		for (SpawnerObject i: tiles.get(0).getSpawnerList()) {
			spawnQueuePane.getChildren().add(i.getImage());
		}
		
		return spawnQueuePane;
	}
	
	private void showAlertBox(String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(str);
		alert.showAndWait();
	}
	
	
	public VBox getPaneNode() {
		return tilePropertyPane;
	}
}
