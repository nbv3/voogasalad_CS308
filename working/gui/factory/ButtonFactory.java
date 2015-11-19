package gui.factory;

import javafx.scene.control.Button;

public class ButtonFactory {
	public ButtonFactory(){
		
	}
	
	public Button createObject(String id) {
		Button setButton = new Button(id);
		setButton.setPrefHeight(30);
		setButton.setPrefWidth(80);
		return setButton;
	}

}
