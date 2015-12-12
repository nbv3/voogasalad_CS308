package com.syntacticsugar.vooga.authoring.level;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ComboBoxFactory {
	public static ComboBox<String> buildStylizedComboBox(ObservableList<String> text, String style, int width) {
		ComboBox<String> c = new ComboBox<String>(text);
		c.setPrefWidth(width);
		c.getStyleClass().add(style);
		return c;
	}
}
