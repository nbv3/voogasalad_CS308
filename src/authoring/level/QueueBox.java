package authoring.level;

import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;

import authoring.icons.panes.ImageIconPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QueueBox {
	private VBox myEnemy;
	private ImageView myImage;
	private HBox mySpawnCount;
	private HBox myHealth;

	// public QueueBox(List<ObjectData> data) {
	// myEnemy = new VBox();
	// addImage(data.get(0).getImagePath());
	// addSpawnCount(data.size());
	// }

	public QueueBox() {
		myEnemy = new VBox();
		addImage("enemy_ghost_1.png");
		addSpawnCount(10);
	}

	private void addImage(String path) {
		myImage = new ImageView(path);
		myImage.setFitHeight(80);
		myImage.setPreserveRatio(true);
		myEnemy.getChildren().add(myImage);
	}

	private void addSpawnCount(int size) {
		mySpawnCount = new HBox();
		Label spawnText = new Label("Count: " + size);
		mySpawnCount.getChildren().add(spawnText);
		myEnemy.getChildren().add(mySpawnCount);
	}

	public VBox getContent() {
		return myEnemy;
	}

}
