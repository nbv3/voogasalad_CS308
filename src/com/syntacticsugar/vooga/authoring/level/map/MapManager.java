package com.syntacticsugar.vooga.authoring.level.map;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.level.IManager;
import com.syntacticsugar.vooga.authoring.objectediting.IObjectDataClipboard;

import javafx.scene.Node;

public class MapManager implements IManager {

	private MapView myMapDisplay;
	private MapControls myMapControls;
	
	public MapManager(IObjectDataClipboard clip) throws Exception {
		myMapDisplay = new MapView(clip);
		myMapControls = new MapControls(myMapDisplay);
	}
	
	
	@Override
	public Observable getObservableController() {
		return myMapControls;
	}

	@Override
	public Node getControlNode() {
		return myMapControls.getView();
	}

	@Override
	public Node getViewNode() {
		return myMapDisplay.getView();
	}

}
