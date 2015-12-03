package com.syntacticsugar.vooga.authoring.level;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class TowerManager {
	private VBox myView;
	private TowerList myTowerList;
	private TowerController myController;

	public TowerManager() {
		myView = new VBox();
		myTowerList = new TowerList();
		myController = new TowerController(myTowerList);
		myView.getChildren().addAll(myController.getView(), myTowerList.getView());
	}

	public Node getView() {
		return myView;
	}

	public TowerController getControl() {
		return myController;
	}
}
