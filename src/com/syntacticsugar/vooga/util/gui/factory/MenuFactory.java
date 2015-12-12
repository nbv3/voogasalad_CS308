package com.syntacticsugar.vooga.util.gui.factory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class MenuFactory {

	public static MenuItem buildMenuItem(String name, EventHandler<ActionEvent> action) {
		MenuItem item = new MenuItem();
		item.setText(name);
		item.setOnAction(action);
		return item;
	}

}
