package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TowerBox extends VBox{
	
	private final static double CONTENT_SPACING = 20.0;

	public TowerBox() {
		Label title = new Label("Tower Controls");
		VBox content = new VBox(CONTENT_SPACING);
		this.getChildren().addAll(title, content);
	}
}
