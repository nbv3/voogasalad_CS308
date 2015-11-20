package com.syntacticsugar.vooga.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.attribute.HealthAttribute;
import com.syntacticsugar.vooga.attribute.KeyControlAttribute;
import com.syntacticsugar.vooga.conditions.ConditionType;
import com.syntacticsugar.vooga.conditions.IGameCondition;
import com.syntacticsugar.vooga.conditions.PlayerDeathCondition;
import com.syntacticsugar.vooga.engine.GameEngine;
import com.syntacticsugar.vooga.event.HealthChangeEvent;
import com.syntacticsugar.vooga.objects.GameObject;
import com.syntacticsugar.vooga.objects.GameObjectType;
import com.syntacticsugar.vooga.objects.IGameObject;
import com.syntacticsugar.vooga.objects.IViewableObject;
import com.syntacticsugar.vooga.universe.GameUniverse;
import com.syntacticsugar.vooga.universe.IGameUniverse;
import com.syntacticsugar.vooga.utilities.GameInformation;
import com.syntacticsugar.vooga.view.implementation.ViewController;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class GameManager implements IGameManager {

	private IGameUniverse myUniverse;
	// private ISimpleViewController myViewController;
	private List<IGameCondition> myConditions;
	private GameInformation myInformation;
	private ViewController myViewController;

	public GameManager() {
		myUniverse = new GameUniverse();
		myConditions = new ArrayList<IGameCondition>();
		myConditions.add(new PlayerDeathCondition());

		myViewController = new ViewController(600.0);
		String path = "enemy_dragon.png";

		// i changed ISimpleObject to SimpleObject, else addViewObject does not
		// work
		GameObject player = new GameObject(GameObjectType.PLAYER, new Point2D(0, 0), 50, 50, path, myUniverse.getNextID());
		player.addAttribute(new KeyControlAttribute(player));
		player.addAttribute(new HealthAttribute(10, player));

		GameObject enemy = new GameObject(GameObjectType.ENEMY, new Point2D(200, 200), 100, 100, path, myUniverse.getNextID());

		enemy.addCollisionBinding(GameObjectType.PLAYER, new HealthChangeEvent(-10));
		myUniverse.addGameObject(player);
		myUniverse.addGameObject(enemy);
		myViewController.addViewObject(player);
		myViewController.addViewObject(enemy);

		updateGame();

	}

	@Override
	public void updateGame() {
		GameEngine.frameUpdate(myUniverse);

		// Object cleanup for now

		Collection<IGameObject> graveyard = myUniverse.getGraveYard();
		for (IGameObject obj : graveyard) {
			myUniverse.removeGameObject(obj);
			myViewController.removeViewObject((IViewableObject) obj);
		}
		myUniverse.clearGraveYard();

		checkConditions();
		updateStats();
	}

	private void updateStats() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkConditions() {
		Collection<IGameObject> unmodifiableUniverse = myUniverse.getGameObjects();

		for (IGameCondition condition : myConditions) {
			if (condition.checkCondition(unmodifiableUniverse)) {
				switchLevel(condition.returnType());
			}
		}

	}

	@Override
	public void switchLevel(ConditionType type) {
		if (type.equals(ConditionType.WINNING)) {
			// go forward
		} else if (type.equals(ConditionType.LOSING)) {
			// go backward?
//			System.out.println("YOU LOSE");
		}

	}

	public void receiveKeyPressed(KeyCode code) {
		myUniverse.receiveKeyPress(code);
	}

	public void receiveKeyReleased(KeyCode code) {
		myUniverse.receiveKeyRelease(code);
	}

	public Pane getGameView() {
		return myViewController.getGameView();
	}

}
