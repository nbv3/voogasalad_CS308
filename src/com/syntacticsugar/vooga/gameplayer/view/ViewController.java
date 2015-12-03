package com.syntacticsugar.vooga.gameplayer.view;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;
import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;

public class ViewController implements IViewRemover, IViewAdder{

	private Map<IViewableObject, ObjectView> myViewMap;
	private GameView myGameView;
	
	public ViewController(double size) {
		myViewMap = new HashMap<IViewableObject, ObjectView>();
		myGameView = new GameView(size);
	}

	public void addViewObject(IViewableObject obj) {
		ObjectView newView = new ObjectView(obj.getPath(), obj.getBoundingBox(), myGameView);
		myViewMap.put(obj, newView);
	}

	public Map<IViewableObject, ObjectView> getViewMap() {
		return myViewMap;
	}

	public GameView getGameView() {
		return myGameView;
	}

	private int count = 0;
	public void removeViewObject(IViewableObject obj) {
		count ++;
		ObjectView object = myViewMap.get(obj);
		myGameView.getView().getChildren().remove(object.getViewPane());
		myViewMap.remove(obj);
	}

	public void initializeView(IGameUniverse universe) {
		myGameView.initializeAvailableTowers(universe.getAvailableTowers(), universe);
		for (IGameTile tile: universe.getMap().getTiles()) {
			addTileObject(tile);
		}
		for (IGameObject object : universe.getGameObjects()) {
			addViewObject(object);
		}
	}

	private void addTileObject(IGameTile obj) {
		TileView newView = new TileView(obj.getPath(), obj.getBoundingBox(), myGameView, obj.isWalkable());
		//newView.addObserver(this);
		myGameView.initializeTowerTileObserver(newView);
		myViewMap.put(obj, newView);
	}

}
