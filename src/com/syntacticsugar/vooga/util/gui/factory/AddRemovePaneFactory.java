// This entire file is part of my masterpiece.
// Jiadong Yin
package com.syntacticsugar.vooga.util.gui.factory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AddRemovePaneFactory {

	AddRemovePaneFactory() { 
		
	}
	
	public static AnchorPane createPane(EventHandler<ActionEvent> add, EventHandler<ActionEvent> remove, String label) {
		Button a = new Button();
		a.setText("+");
		a.setOnAction(add);
		a.setPrefWidth(25);
		Button r = new Button();
		r.setText("-");
		r.setOnAction(remove);
		r.setPrefWidth(25);
		GridPane buttonGrid = new GridPane();
		buttonGrid.add(a, 0, 0, 1, 1);
		buttonGrid.add(r, 1, 0, 1, 1);
		buttonGrid.setHgap(5);
		a.setAlignment(Pos.CENTER);
		r.setAlignment(Pos.CENTER);
		GridPane.setHgrow(a, Priority.ALWAYS);
		GridPane.setHgrow(r, Priority.ALWAYS);
		AnchorPane anchor = GUIFactory.buildAnchorPane(new Label(label), buttonGrid);
		return anchor;
	}
	
}
