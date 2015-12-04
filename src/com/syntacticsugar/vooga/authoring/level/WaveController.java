package com.syntacticsugar.vooga.authoring.level;

import java.util.Observable;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class WaveController extends Observable{

	private VBox myView;
	private Button myAddButton;
	private Button myRemoveButton;
	private Button myClearButton;
	private Button myEditButton;
	private ObjectData selectedItem;


	public WaveController(EnemyQueueTabManager tabs) {
		myView = new VBox();
		myAddButton = GUIFactory.buildButton("Create wave", e -> tabs.addNewWave(), 150.0, 50.0);
		myClearButton = GUIFactory.buildButton("Clear wave", e -> tabs.clearWave(), 150.0, 50.0);
		myRemoveButton = GUIFactory.buildButton("Remove Selected", e -> tabs.removeItem(), 150.0, 50.0);
		myEditButton = GUIFactory.buildButton("Edit Selected", e -> editItem(tabs), 150.0, 50.0);
		myView.getChildren().addAll(myAddButton, myClearButton, myEditButton, myRemoveButton);
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(20);
	}
	
	private void editItem(EnemyQueueTabManager tabs)
	{
		selectedItem = tabs.getSelectedItem();
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
