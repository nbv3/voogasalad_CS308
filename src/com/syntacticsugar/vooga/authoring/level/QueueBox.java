package com.syntacticsugar.vooga.authoring.level;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.authoring.tooltips.ObjectTooltip;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class QueueBox implements IVisualElement {
	
	private VBox myView;
	private ImageView myImage;
	private HBox mySpawnCount;
	private ObjectData myData;

	public QueueBox(ObjectData data) {
		myData = data;
		myView = new VBox();
		addImage(data.getImagePath());
		Tooltip.install(myView, new ObjectTooltip(myData));
	}

	private void addImage(String path) {
		myImage = new ImageView(path);
		myImage.setFitHeight(80);
		myImage.setFitWidth(80);
		myImage.setPreserveRatio(true);
		myView.getChildren().add(myImage);
	}

	private void addSpawnCount(int size) {
		mySpawnCount = new HBox();
		Label spawnText = new Label("Count: " + size);
		mySpawnCount.getChildren().add(spawnText);
		myView.getChildren().add(mySpawnCount);
	}

	@Override
	public Node getView() {
		return myView;
	}

}
