package com.syntacticsugar.vooga.gameplayer.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.KeyControlAttribute;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition;
import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.utilities.GameInformation;
import com.syntacticsugar.vooga.gameplayer.view.implementation.ViewController;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

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

		// i changed ISimpleObject to SimpleObject, else addViewObject does not
		// work
		String path = "enemy_moster_1.png";
		
		ObjectData playerData = new ObjectData();
		List<IAttribute> attributes = new ArrayList<IAttribute>();
		attributes.add(new HealthAttribute(100));
		attributes.add(new KeyControlAttribute());
		playerData.setType(GameObjectType.PLAYER);
		playerData.setImagePath(path);
		playerData.setAttributes(attributes);
		
		ObjectData enemyData = new ObjectData();
		Map<GameObjectType, Collection<IGameEvent>> collisions = new HashMap<GameObjectType, Collection<IGameEvent>>();
		Collection<IGameEvent> enemyEvents = new ArrayList<IGameEvent>();
		enemyEvents.add(new HealthChangeEvent(-10));
		collisions.put(GameObjectType.PLAYER, enemyEvents);
		enemyData.setType(GameObjectType.ENEMY);
		enemyData.setImagePath(path);
		enemyData.setCollisionMap(collisions);

		GameObject player = new GameObject(playerData, new Point2D(10, 10), 50, 50);
		GameObject enemy = new GameObject(enemyData, new Point2D(100, 100), 100, 100);
		
		currentLevel.addGameObject(player);
		currentLevel.addGameObject(enemy);
		myViewController.addViewObject(player);
		myViewController.addViewObject(enemy);

	}

	@Override
	public void restartGame() {

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

	@Override
	public void startLevel(IGameUniverse level) {
		// Take a level
		// Add everything to view
		// allow players to place towers
		// when play is pressed -> start timeline
	}
	
	@Override
	public void startGame(){
		
	}

	@Override
	public void endLevel(){
		
	}
	
	public void initializeAnimation(double fl) {
		KeyFrame frame = new KeyFrame(Duration.seconds(fl), e -> updateGame());
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
}
