package com.syntacticsugar.vooga.gameplayer.view;

import java.util.Observable;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class TowerBox extends Observable{
	
	private final static double CONTENT_SPACING = 20.0;
	private VBox myContent;

	public TowerBox() {
		myContent = new VBox();
		Label title = new Label("Tower Controls");
		VBox content = new VBox(CONTENT_SPACING);
		testDragAndDrop(content);
		myContent.getChildren().addAll(title, content);
	}

	private void testDragAndDrop(VBox content) {
		ImageView myTower = new ImageView(new Image(this.getClass().getClassLoader().getResourceAsStream("tower_1.png")));
		myTower.setOnMouseClicked(e -> selectedTower());
		content.getChildren().add(myTower);
	}

	private void selectedTower() {
		setChanged();
		notifyObservers();
	}
	
	public VBox getContent(){
		return myContent;
	}
}
