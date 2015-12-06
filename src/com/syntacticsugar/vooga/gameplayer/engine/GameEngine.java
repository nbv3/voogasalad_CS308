package com.syntacticsugar.vooga.gameplayer.engine;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.ITowerHolder;
import com.syntacticsugar.vooga.gameplayer.universe.score.IScore;
import com.syntacticsugar.vooga.gameplayer.universe.spawner.ISpawner;
import com.syntacticsugar.vooga.gameplayer.view.GameViewController;
import com.syntacticsugar.vooga.gameplayer.view.IViewAdder;
import com.syntacticsugar.vooga.gameplayer.view.IViewRemover;
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

	private IViewAdder myViewAdder;
	private IViewRemover myViewRemover;

	public GameEngine() {
	
		
	}
	
	public void registerViewAdder(IViewAdder adder){
		myViewAdder = adder;
	}
	
	public void registerViewRemover(IViewRemover remover){
		myViewRemover = remover;
	}

	public void update(IGameUniverse uni) {
		checkCollisions(uni);
		updateState(uni);
		processSpawner(uni);
		processGraveyard(uni);
		processSpawnyard(uni);
	}

	private void checkCollisions(IGameUniverse uni) {
		Collection<IGameObject> objectsToCheck = new ArrayList<IGameObject>();
		objectsToCheck.addAll(uni.getGameObjects());
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

	private void updateState(IGameUniverse uni) {
		for (IGameObject object : uni.getGameObjects()) {
			object.updateSelf(uni);
		}
		
		for (IGameTile tile: uni.getMap().getTiles()) {
			tile.updateSelf(uni);
		}
	}
	
	private void processSpawner(IGameUniverse uni) {
		ISpawner spawner = uni.getSpawner();
		spawner.update();
	}


	private void processGraveyard(IGameUniverse uni) {
		uni.removeFromUniverse(myViewRemover);
	}

	private void processSpawnyard(IGameUniverse uni) {
		uni.addToUniverse(myViewAdder);
	}


}
