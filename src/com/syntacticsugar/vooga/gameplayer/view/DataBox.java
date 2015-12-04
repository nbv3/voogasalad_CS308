package com.syntacticsugar.vooga.gameplayer.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DataBox extends VBox {

	private final static double CONTENT_SPACING = 20.0;

	private HBox myContent;

	public DataBox() {
		myContent = new HBox(CONTENT_SPACING);
		myContent.getStyleClass().add("data");
		this.getChildren().addAll(myContent);
	}

	public void addContent(Node... dataContent) {
		myContent.getChildren().addAll(dataContent);
	}

}
