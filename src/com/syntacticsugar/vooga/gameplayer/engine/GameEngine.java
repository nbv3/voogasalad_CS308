package com.syntacticsugar.vooga.gameplayer.engine;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.ViewController;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.manager.ILevelSwitcher;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public class GameEngine {

	private IGameUniverse myUniverse;
	private ViewController myView;
	private ILevelSwitcher myManager;

	public GameEngine(IGameUniverse universe, ViewController view, ILevelSwitcher manager) {
		myUniverse = universe;
		myView = view;
		myManager = manager;
	}

	public void resetUniverse(IGameUniverse universe) {
		myUniverse = universe;
	}

	public void update() {
		checkCollisions();
		updateState();
		checkConditions();
		processGraveyard();
		processSpawnyard();

	}

	private void checkCollisions() {
		Collection<IGameObject> objectsToCheck = new ArrayList<IGameObject>();
		objectsToCheck.addAll(myUniverse.getGameObjects());
		objectsToCheck.addAll(myUniverse.getPlayers());
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
		for (IGameObject player : myUniverse.getPlayers()) {
			player.updateSelf(myUniverse);
		}
	}

	private void checkConditions() {

		for (IGameCondition condition : myUniverse.getConditions()) {
			if (condition.checkCondition(myUniverse)) {
				myManager.switchLevel(condition.returnType());
			}
		}

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

}
