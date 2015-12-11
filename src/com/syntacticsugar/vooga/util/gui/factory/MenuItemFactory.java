// This entire file is part of my masterpiece.
// Henry Yuen
package com.syntacticsugar.vooga.util.gui.factory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class MenuItemFactory {
	
	private MenuItem menuItem;
	public MenuItemFactory(){
		
	}
	private MenuItem buildMenuItem(String label){
		menuItem = new MenuItem();
		menuItem.setText(label);
		return menuItem;
	}
	public MenuItem buildMenuItem(String label, EventHandler<ActionEvent> onAction){
		menuItem = buildMenuItem(label);
		menuItem.setOnAction(onAction);
		return menuItem;
	}
}
