package editor.sidepanes;

import java.util.List;

import objects.SpawnerObject;
import tiles.DecoratorTile;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TilePropertyPane {

	private List<DecoratorTile> tiles;
	private VBox tilePropertyPane;
	private TilePane spawnQueuePane;
	private SpawnerPropertyBox spawnerProperty;
	private ObjectProperty<ImageView> selectImg = new SimpleObjectProperty<ImageView>();
	
	public TilePropertyPane(List<DecoratorTile> tiles) {
		this.tiles = tiles;
		tilePropertyPane = new VBox();
		tilePropertyPane.getChildren().addAll(createSpawnerQueueText("Spawner Queue"),createSpawnQueuePane());
		spawnerProperty = new SpawnerPropertyBox();
		spawnerProperty.getMaxHpTF().setDisable(true);
		spawnerProperty.getDmgAmtTF().setDisable(true);
		spawnerProperty.getSpawnNumTF().setDisable(true);
		tilePropertyPane.getChildren().add(spawnerProperty.getNode());
	}

	private TilePane createSpawnQueuePane() {
		spawnQueuePane = new TilePane();
		spawnQueuePane.getStyleClass().add("properties-module");
		for (SpawnerObject i: tiles.get(0).getSpawnerList()) {
			ImageView img = i.getImage();
			img.setOnMouseClicked(e -> {
				selectImg.setValue(img);
				if (e.getClickCount() == 1) {
					displaySelectSpawnerProperties(i);
				}
				if (e.getClickCount() == 2) {
					removeSpawnerFromList(i,img);
				}
			});
			
			selectImg.addListener((o,s1,s2) -> {
				if (s1 == null) {
					s2.setEffect(new Glow(0.7));
					return;
				}
				s1.setEffect(null);
				s2.setEffect(new Glow(0.7));
			});
			
			spawnQueuePane.getChildren().add(i.getImage());
		}
		
		return spawnQueuePane;
	}
	
	private void removeSpawnerFromList(SpawnerObject i, ImageView img) {
		spawnQueuePane.getChildren().remove(img);
		tiles.get(0).getSpawnerList().remove(i);
		System.out.println("The spawner list size reduced to " + tiles.get(0).getSpawnerList().size());
	}

	private void displaySelectSpawnerProperties(SpawnerObject i) {
		spawnerProperty.setMaxHp(i.getMaxHealth());
		spawnerProperty.setDamage(i.getDamage());
		spawnerProperty.setSpawnNum(i.getSpawnNum());
	}

	private Text createSpawnerQueueText(String str) {
		Text spawnerTitle = new Text(str);
		spawnerTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		return spawnerTitle;
	}
	
	public VBox getPaneNode() {
		return tilePropertyPane;
	}
}
