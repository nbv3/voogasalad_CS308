package com.syntacticsugar.vooga.util.gui.factory;

import javafx.scene.control.TextField;

public class TextFieldFactory {

	public static TextField buildStylizedField(String text, String style) {
		TextField t = new TextField();
		t.setPromptText(text);
		t.getStyleClass().add(style);
		return t;
	}

}
