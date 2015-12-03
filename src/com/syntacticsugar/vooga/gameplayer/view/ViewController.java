package com.syntacticsugar.vooga.gameplayer.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;
import com.syntacticsugar.vooga.gameplayer.view.implementation.TileView;

import javafx.geometry.Point2D;
import xml.data.ObjectData;

public class ViewController implements IViewRemover, IViewAdder, Observer {

	private Map<IViewableObject, ObjectView> myViewMap;
	private GameView myGameView;
	private IGameUniverse myUniverse; 

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

	public void removeViewObject(IViewableObject obj) {
		ObjectView object = myViewMap.get(obj);
		myGameView.getView().getChildren().remove(object.getViewPane());
		myViewMap.remove(obj);
	}

	public void initializeView(IGameUniverse universe) {
		myUniverse = universe;
		for (IGameTile tile: universe.getMap().getTiles()) {
			addTileObject(tile);
		}
		for (IGameObject object : universe.getGameObjects()) {
			addViewObject(object);
		}
	}

	private void addTileObject(IGameTile obj) {
		TileView newView = new TileView(obj.getPath(), obj.getBoundingBox(), myGameView, obj.isWalkable());
		newView.addObserver(this);
		myGameView.initializeTowerTileObserver(newView);
		myViewMap.put(obj, newView);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//Test version, will need to know what tower is selected
		/*
		Point2D point =  (Point2D) arg1;
		String imgPath = "tower_1.png";
		ObjectData enemyData = new ObjectData();
		Collection<IAttribute> enemyAttributes = new ArrayList<IAttribute>();
		enemyAttributes.add(new HealthAttribute(30));
		// enemyAttributes.add(new AIMovementAttribute(3));
		Map<GameObjectType, Collection<IGameEvent>> collisions = new HashMap<GameObjectType, Collection<IGameEvent>>();
		Collection<IGameEvent> enemyEvents = new ArrayList<IGameEvent>();
		enemyEvents.add(new HealthChangeEvent(-10));
		collisions.put(GameObjectType.PLAYER, enemyEvents);
		enemyData.setType(GameObjectType.ENEMY);
		enemyData.setSpawnPoint(point.getX(), point.getY());
		enemyData.setImagePath(imgPath);
		enemyData.setAttributes(enemyAttributes);
		enemyData.setCollisionMap(collisions);
		IGameObject enemy = new GameObject(enemyData, 50, 50);
		myUniverse.addGameObject(enemy);
		
		IViewableObject obj = (IViewableObject) enemy;
		ObjectView animal = new ObjectView(obj.getPath(), obj.getBoundingBox(), myGameView);
		myViewMap.put(obj, animal);
		*/
		
	}

}
