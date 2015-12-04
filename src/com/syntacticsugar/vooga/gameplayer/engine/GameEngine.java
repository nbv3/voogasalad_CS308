package com.syntacticsugar.vooga.gameplayer.engine;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.ITowerHolder;
import com.syntacticsugar.vooga.gameplayer.universe.score.IScore;
import com.syntacticsugar.vooga.gameplayer.universe.spawner.ISpawner;
import com.syntacticsugar.vooga.gameplayer.view.ViewController;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;
import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.manager.ILevelSwitcher;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.towers.Tower;

public class GameEngine {

	private IGameUniverse myUniverse;
	private ViewController myView;
	private IScore myScore;

	public GameEngine(IGameUniverse universe, ViewController view) {
		myUniverse = universe;
		myView = view;

	}

	public void resetUniverse(IGameUniverse universe) {
		myUniverse = universe;
	}

	public void update() {
		checkCollisions();
		updateState();
		processSpawner();
		processGraveyard();
		processSpawnyard();
		processScore();
	}

	private void checkCollisions() {
		Collection<IGameObject> objectsToCheck = new ArrayList<IGameObject>();
		objectsToCheck.addAll(myUniverse.getGameObjects());
		for (IGameObject a : objectsToCheck) {
			for (IGameObject b : objectsToCheck) {
				if (b.equals(a)) {
					continue;
				}
				if (intersects(a, b)) {
					a.onCollision(b);
				}
			}
		}
	}

	private Boolean intersects(IGameObject obj, IGameObject other) {
		IBoundingBox abox = obj.getBoundingBox();
		IBoundingBox bbox = other.getBoundingBox();

		double ax = abox.getPoint().getX();
		double bx = bbox.getPoint().getX();
		double ay = abox.getPoint().getY();
		double by = bbox.getPoint().getY();

		double aw = abox.getWidth();
		double bw = bbox.getWidth();
		double ah = abox.getHeight();
		double bh = bbox.getHeight();

		Boolean aInsideBX = (ax + aw >= bx && ax <= bx + bw);
		Boolean aInsideBY = (ay + ah >= by && ay <= by + bh);
		Boolean bInsideAX = (bx + bw >= ax && bx <= ax + aw);
		Boolean bInsideAY = (by + bh >= ay && by <= ay + ah);
		return ((aInsideBX && aInsideBY) || (bInsideAX && bInsideAY));
	}

	private void updateState() {
		for (IGameObject object : myUniverse.getGameObjects()) {
			object.updateSelf(myUniverse);
		}
	}
	
	private void processSpawner() {
		ISpawner spawner = myUniverse.getSpawner();
		spawner.update();
	}
	
	private void processScore() {
		IScore score = myUniverse.getScore();
		score.update();
	}

	private void processGraveyard() {
		myUniverse.removeFromUniverse(myView);
	}

	private void processSpawnyard() {
		myUniverse.addToUniverse(myView);
	}

	public void receiveKeyPressed(KeyCode code) {
		myUniverse.receiveKeyPress(code);
	}

	public void receiveKeyReleased(KeyCode code) {
		myUniverse.receiveKeyRelease(code);
	}

	public Pane getGameView() {
		return myView.getGameView();
	}
	
	private void placeTower(ObjectData obj, Point2D point) {
		IGameMap map = myUniverse.getMap();
		double size = map.getTileSize();
		Point2D spawnPoint;
		try {
			spawnPoint = map.getCoordinateFromMapIndex(map.getMapIndexFromCoordinate(point));
		} catch (Exception e) {
			return;
		}
		obj.setWidth(size);
		obj.setHeight(size);
		obj.setSpawnPoint(spawnPoint.getX(), spawnPoint.getY());
		IGameObject tower = new Tower(obj);
		
		ITowerHolder tile = map.getTile(point);
		tile.setIsPlaceable(false);
		
		ObjectSpawnEvent event = new ObjectSpawnEvent(tower);
		myUniverse.postEvent(event);
	}

}
