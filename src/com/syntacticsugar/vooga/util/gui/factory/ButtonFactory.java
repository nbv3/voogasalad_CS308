package com.syntacticsugar.vooga.util.gui.factory;

import javafx.scene.control.Button;

public class ButtonFactory {
	public ButtonFactory(){
		
	}
	
	public Button createObject(String id, double width, double height) {
		Button setButton = new Button(id);
		setButton.setPrefWidth(width);
		setButton.setPrefHeight(height);
		return setButton;
	}

}
