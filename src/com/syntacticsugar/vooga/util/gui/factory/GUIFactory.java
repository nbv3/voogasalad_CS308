package com.syntacticsugar.vooga.util.gui.factory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class GUIFactory {

	public static AnchorPane buildAnchorPane(Node left, Node right) {
		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().addAll(left, right);
		AnchorPane.setLeftAnchor(left, 0.0);
		AnchorPane.setRightAnchor(right, 0.0);
		return anchor;
	}
	
	public static Button buildButton(String label, EventHandler<ActionEvent> action, Double width, Double height) {
		Button button = new Button(label);
		if (width!=null)  button.setPrefWidth(width);
		if (height!=null) button.setPrefHeight(height);
		button.setOnAction(action);
		return button;
	}

}
