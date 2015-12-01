package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InformationBox extends VBox{
	
	private final static double CONTENT_SPACING = 20.0;
	
	public InformationBox(){
		Label title = new Label("Game Statistics");
		HBox content = new HBox(CONTENT_SPACING);
		this.getChildren().addAll(title, content);
	}

}
