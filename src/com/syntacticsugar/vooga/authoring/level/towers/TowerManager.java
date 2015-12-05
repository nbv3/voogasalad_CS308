package com.syntacticsugar.vooga.authoring.level.towers;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.level.IManager;

import javafx.scene.Node;

public class TowerManager implements IManager {
	
	private TowerView myTowerView;
	private TowerControls myTowerController;

	public TowerManager() {
		myTowerView = new TowerView();
		myTowerController = new TowerControls(myTowerView);
	}
	
	@Override
	public Observable getObservableController() {
		return myTowerController;
	}

	@Override
	public Node getControlNode() {
		return myTowerController.getView();
	}

	@Override
	public Node getViewNode() {
		return myTowerView.getView();
	}

}
