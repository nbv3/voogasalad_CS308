package com.syntacticsugar.vooga.gameplayer.view;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.IUniverseView;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;
import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;

public class ViewController implements IViewRemover, IViewAdder{

	private Map<IViewableObject, ObjectView> myViewMap;
	private GameView myGameView;
	
	public ViewController(double size) {
		myViewMap = new HashMap<IViewableObject, ObjectView>();
		myGameView = new GameView(size);
	}

	@Override
	public void addViewObject(IViewableObject obj) {
		ObjectView newView = new ObjectView(obj.getPath(), obj.getBoundingBox(), myGameView.getScalingFactor());
		myGameView.addObjectView(newView);
		myViewMap.put(obj, newView);
	}

	public GameView getGameView() {
		return myGameView;
	}

	@Override
	public void removeViewObject(IViewableObject obj) {
		ObjectView object = myViewMap.get(obj);
		myGameView.removeObjectView(object);
		myViewMap.remove(obj);
	}

	public void initializeView(IUniverseView universe) {
		myGameView.initializeAvailableTowers(universe.getAvailableTowers(), universe);
		universe.observeScore(myGameView.getScoreBox());
		for (IGameTile tile: universe.getMap().getTiles()) {
			addTileObject(tile);
		}
		for (IGameObject object : universe.getGameObjects()) {
			addViewObject(object);
		}
	}

	private void addTileObject(IGameTile obj) {
		TileView newView = new TileView(obj.getPath(), obj.getBoundingBox(), myGameView);
//		myGameView.initializeTowerTileObserver(newView);
		myViewMap.put(obj, newView);
	}

}
