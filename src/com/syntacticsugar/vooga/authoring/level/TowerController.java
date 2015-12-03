package com.syntacticsugar.vooga.authoring.level;

import java.util.Observable;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TowerController extends Observable{
	private VBox myView;
	private Button myRemoveButton;
	private Button myClearButton;
	private Button myEditButton;
	private ObjectData selectedItem;


	public TowerController(TowerList towers) {
		myView = new VBox();
		myClearButton = GUIFactory.buildButton("Clear Towers", e -> towers.clearAll(), 100.0, 50.0);
		myRemoveButton = GUIFactory.buildButton("Remove Selected", e -> towers.removeObjectFromList(), 150.0, 50.0);
		myEditButton = GUIFactory.buildButton("Edit Selected", e -> editTower(towers), 100.0, 50.0);
		myView.getChildren().addAll(myClearButton, myEditButton, myRemoveButton);
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(10);
	}
	
	private void editTower(TowerList towers)
	{
		selectedItem = towers.getSelectedItem();
		setChanged();
		notifyObservers(selectedItem);
	}
	
	public ObjectData getItemToEdit()
	{
		return selectedItem;
	}

	public Node getView() {
		return myView;
	}
	
}
