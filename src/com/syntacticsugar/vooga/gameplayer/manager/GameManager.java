package com.syntacticsugar.vooga.gameplayer.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.KeyControlAttribute;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition;
import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.utilities.GameInformation;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class GameManager implements IGameManager {

	private IGameUniverse currentLevel;
	private List<IGameUniverse> myLevels;
	private List<IGameCondition> myConditions;
	// private GameInformation myInformation;
	private ViewController myViewController;

	public GameManager() {
		currentLevel = new GameUniverse();
		myConditions = new ArrayList<IGameCondition>();
		myConditions.add(new PlayerDeathCondition());

		myViewController = new ViewController(600.0);
		String path = "enemy_dragon.png";

		// i changed ISimpleObject to SimpleObject, else addViewObject does not
		// work
		GameObject player = new GameObject(GameObjectType.PLAYER, new Point2D(0, 0), 50, 50, path);
		player.addAttribute(new KeyControlAttribute(player));
		player.addAttribute(new HealthAttribute(10, player));

		GameObject enemy = new GameObject(GameObjectType.ENEMY, new Point2D(200, 200), 100, 100, path);

		enemy.addCollisionBinding(GameObjectType.PLAYER, new HealthChangeEvent(-10));
		currentLevel.addGameObject(player);
		currentLevel.addGameObject(enemy);
		myViewController.addViewObject(player);
		myViewController.addViewObject(enemy);

		updateGame();

	}

	@Override
	public void updateGame() {
		GameEngine.frameUpdate(currentLevel);
		checkConditions();

		// Object cleanup for now

		Collection<IGameObject> graveyard = currentLevel.getGraveYard();
		for (IGameObject obj : graveyard) {
			currentLevel.removeGameObject(obj);
			myViewController.removeViewObject((IViewableObject) obj);
		}
		currentLevel.clearGraveYard();

		updateStats();
	}

	private void updateStats() {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkConditions() {

		for (IGameCondition condition : myConditions) {
			if (condition.checkCondition(currentLevel)) {
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
			System.out.println("YOU LOSE");
		}

	}

	public void receiveKeyPressed(KeyCode code) {
		currentLevel.receiveKeyPress(code);
	}

	public void receiveKeyReleased(KeyCode code) {
		currentLevel.receiveKeyRelease(code);
	}

	public Pane getGameView() {
		return myViewController.getGameView();
	}

}
