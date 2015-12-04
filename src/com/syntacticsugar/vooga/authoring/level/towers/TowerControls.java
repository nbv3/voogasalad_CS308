package com.syntacticsugar.vooga.authoring.level.towers;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.level.IDataSelector;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TowerControls extends Observable implements IVisualElement {
	
	private VBox myView;
	private Button myRemoveButton;
	private Button myClearButton;
	private Button myEditButton;
	IDataSelector<ObjectData> myTowerView;

	public TowerControls(IDataSelector<ObjectData> towers) {
		myView = new VBox();
		myClearButton = GUIFactory.buildButton("Clear Towers", e -> myTowerView.clearData(), 100.0, 50.0);
		myRemoveButton = GUIFactory.buildButton("Remove Selected", e -> myTowerView.removeSelectedData(), 150.0, 50.0);
		myEditButton = GUIFactory.buildButton("Edit Selected", e -> editSelectedData(), 100.0, 50.0);
		myView.getChildren().addAll(myClearButton, myEditButton, myRemoveButton);
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(10);
	}
	
	private void editSelectedData() {
		setChanged();
		notifyObservers(myTowerView.getSelectedData());
	}
	
	@Override
	public Node getView() {
		return myView;
	}
	
}
