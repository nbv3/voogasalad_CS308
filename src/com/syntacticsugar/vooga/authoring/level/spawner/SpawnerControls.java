package com.syntacticsugar.vooga.authoring.level.spawner;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class SpawnerControls extends Observable implements IVisualElement {

	private VBox myVBox;
	private Button myAddButton;
	private Button myRemoveButton;
	private Button myClearButton;
	private Button myEditButton;
	private TitledPane myViewPane;

	public SpawnerControls(SpawnerManager tabs) {
		myVBox = new VBox();
		myAddButton = GUIFactory.buildButton("Create wave", e -> tabs.append(), 150.0, 50.0);
		myClearButton = GUIFactory.buildButton("Clear wave", e -> tabs.remove(), 150.0, 50.0);
		myRemoveButton = GUIFactory.buildButton("Remove Selected", e -> tabs.getCurrentView().removeSelectedData(), 150.0, 50.0);
		myEditButton = GUIFactory.buildButton("Edit Selected", e -> editItem(tabs.getCurrentView().getSelectedData()), 150.0, 50.0);
		myVBox.getChildren().addAll(myAddButton, myClearButton, myEditButton, myRemoveButton);
		myVBox.setAlignment(Pos.CENTER);
		myVBox.setSpacing(10);
		myVBox.setPadding(new Insets(10));
		
		myViewPane = GUIFactory.buildTitledPane("Spawn Controls", myVBox);
	}
	
	private void editItem(ObjectData toEdit) {
		setChanged();
		notifyObservers(toEdit);
	}
	
	@Override
	public Node getView() {
		return myViewPane;
	}
	
}
