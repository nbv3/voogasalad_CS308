package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public class ViewController {

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
	
	public void removeViewObject(IViewableObject obj){
		ObjectView object = myViewMap.get(obj);
		myGameView.getChildren().remove(object.getViewPane());
		myViewMap.remove(obj);
	}

	public void initializeView(IGameUniverse universe) {
		for (DecoratorTile tile: universe.getTiles()) {
			addViewObject(tile);
		}
		for (IGameObject player: universe.getPlayers()) {
			addViewObject(player);
		}
		for (IGameObject object : universe.getGameObjects()) {
			addViewObject(object);
		}

	}

}
