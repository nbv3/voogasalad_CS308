package com.syntacticsugar.vooga.authoring.level.towers;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.level.IDataSelector;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.TowerData;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class TowerControls extends Observable implements IVisualElement {
	
	private TitledPane myViewPane;
	private VBox myVBox;
	private Button myRemoveButton;
	private Button myClearButton;
	private Button myEditButton;
	IDataSelector<TowerData> myTowerView;

	public TowerControls(IDataSelector<TowerData> towers) {
		myVBox = new VBox();
		myTowerView = towers;
		myClearButton = GUIFactory.buildButton("Clear Towers", e -> myTowerView.clearData(), 100.0, 50.0);
		myRemoveButton = GUIFactory.buildButton("Remove Selected", e -> myTowerView.removeSelectedData(), 150.0, 50.0);
		myEditButton = GUIFactory.buildButton("Edit Selected", e -> editSelectedData(), 100.0, 50.0);
		myVBox.getChildren().addAll(myClearButton, myEditButton, myRemoveButton);
		myVBox.setAlignment(Pos.CENTER);
		myVBox.setSpacing(10);
		myVBox.setPadding(new Insets(10));
		
		myViewPane = GUIFactory.buildTitledPane("Tower Controls", myVBox);
	}
	
	private void editSelectedData() {
		setChanged();
		notifyObservers(myTowerView.getSelectedData());
	}
	
	@Override
	public Node getView() {
		return myViewPane;
	}
	
}
