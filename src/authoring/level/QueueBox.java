package authoring.level;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;

import authoring.data.ObjectData;
import authoring.icons.panes.ImageIconPane;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QueueBox {
	private VBox myEnemy;
	private ImageView myImage;
	private HBox mySpawnCount;
	private Label myHealth;
	private ObjectData myData;

	public QueueBox(ObjectData data) {
		myData = data;
		myEnemy = new VBox();
		addImage(data.getImagePath());
		addHealth();
		//	 addSpawnCount(data.size());
	}

//	public QueueBox() {
//		myEnemy = new VBox();
//		addImage("enemy_ghost_1.png");
//		addSpawnCount(10);
//	}

	private void addImage(String path) {
		myImage = new ImageView(path);
		myImage.setFitHeight(30);
		myImage.setFitWidth(30);
		myImage.setPreserveRatio(true);
		myEnemy.getChildren().add(myImage);
	}

	private void addSpawnCount(int size) {
		mySpawnCount = new HBox();
		Label spawnText = new Label("Count: " + size);
		mySpawnCount.getChildren().add(spawnText);
		myEnemy.getChildren().add(mySpawnCount);
	}
	
	private void addHealth() {
		System.out.println(myData.getAttributes().size());
		double db = ((HealthAttribute)((ArrayList<IAttribute>) myData.getAttributes()).get(0)).getHealth();
		myHealth = new Label(String.format("Health: %d",(int) db));
//		mySpawnCount.getChildren().add(spawnText);
		myEnemy.getChildren().add(myHealth);
	}

	public VBox getContent() {
		return myEnemy;
	}

}
