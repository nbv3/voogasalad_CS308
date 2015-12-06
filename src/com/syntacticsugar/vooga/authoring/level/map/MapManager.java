package com.syntacticsugar.vooga.authoring.level.map;

import java.util.Observable;

import com.syntacticsugar.vooga.authoring.level.IManager;
import com.syntacticsugar.vooga.authoring.objectediting.IDataClipboard;
import com.syntacticsugar.vooga.xml.data.MapData;

import javafx.scene.Node;

public class MapManager implements IManager {

	private MapView myMapDisplay;
	private MapControls myMapControls;
	
	public MapManager(IDataClipboard clip) throws Exception {
		System.out.println("Map Manager IOBJECT " + clip);
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

	public MapData getMapData() {
		return myMapDisplay.getMapData();
	}
	
	public void setMapData(MapData loaded) {
		myMapDisplay.loadMapData(loaded);
	}

}
