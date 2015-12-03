package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DataBox extends VBox {
	
	private final static double CONTENT_SPACING = 20.0;
	
	private HBox myContent;
	
	public DataBox(String name){
		Label title = new Label(name);
		title.getStyleClass().add("title");
		myContent = new HBox(CONTENT_SPACING);
		this.getChildren().addAll(title, myContent);
	}
	
	public void addContent(Node dataContent){
		myContent.getChildren().add(dataContent);
	}

}
