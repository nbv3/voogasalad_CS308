package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.xml.data.ObjectData;

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
	}

	private void addImage(String path) {
		myImage = new ImageView(path);
		myImage.setFitHeight(80);
		myImage.setFitWidth(80);
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
		double db = ((HealthAttribute) ((ArrayList<IAttribute>) myData.getAttributes()).get(0)).getHealth();
		myHealth = new Label(String.format("Health: %d", (int) db));
		// mySpawnCount.getChildren().add(spawnText);
		myEnemy.getChildren().add(myHealth);
	}

	public VBox getContent() {
		return myEnemy;
	}

}
