package com.syntacticsugar.vooga.gameplayer.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.PlayerDeathCondition;
import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.ViewController;
import com.syntacticsugar.vooga.menu.SceneManager;

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
	private GameInformation myInformation;
	private ViewController myViewController;
	private Timeline myGameTimeline;
	
	// is SceneManager injection necessary?
	private SceneManager myManager;

	public GameManager(double gameSize) {
		
		currentLevel = new GameUniverse();
		myConditions = new ArrayList<IGameCondition>();
		myConditions.add(new PlayerDeathCondition());

		myViewController = new ViewController(gameSize);

		// i changed ISimpleObject to SimpleObject, else addViewObject does not
		// work
		String playerPath = "player_pacman.png";
		String enemyPath = "enemy_moster_1.png";
		String missilePath = "gray.png";
		
		ObjectData playerData = new ObjectData();
		List<IAttribute> attributes = new ArrayList<IAttribute>();
		attributes.add(new HealthAttribute(100));
		attributes.add(new MovementControlAttribute(3));
		attributes.add(new WeaponAttribute(missilePath, 10, KeyCode.SPACE));
		playerData.setType(GameObjectType.PLAYER);
		playerData.setImagePath(playerPath);
		playerData.setAttributes(attributes);
		
		ObjectData enemyData = new ObjectData();
		Collection<IAttribute> enemyAttributes = new ArrayList<IAttribute>();
		enemyAttributes.add(new HealthAttribute(30));
		Map<GameObjectType, Collection<IGameEvent>> collisions = new HashMap<GameObjectType, Collection<IGameEvent>>();
		Collection<IGameEvent> enemyEvents = new ArrayList<IGameEvent>();
		enemyEvents.add(new HealthChangeEvent(-10));
		collisions.put(GameObjectType.PLAYER, enemyEvents);
		enemyData.setType(GameObjectType.ENEMY);
		enemyData.setImagePath(enemyPath);
		enemyData.setAttributes(enemyAttributes);
		enemyData.setCollisionMap(collisions);

		IGameObject player = new GameObject(playerData, new Point2D(10, 10), 50, 50);
		IGameObject enemy = new GameObject(enemyData, new Point2D(100, 100), 100, 100);
		
		currentLevel.addPlayer(player);
		currentLevel.addGameObject(enemy);
		myViewController.addViewObject(player);
		myViewController.addViewObject(enemy);
		
		myViewController.initializeView(currentLevel);

	}
	
	public void setManager(SceneManager manager) {
		myManager = manager;
	}
	
	public void pause() {
		// call myManager.initEnginePauseMenu() which closes the scene and opens the menu scene
		myManager.launchEnginePauseMenu();
		// TODO pause update logic
	}

	@Override
	public void restartGame() {
		
	}

	@Override
	public void updateGame() {
		GameEngine.frameUpdate(currentLevel);
		checkConditions();

		// Object cleanup for now

		processGraveyard();
		processSpawnyard();

		updateStats();
	}

	private void processGraveyard() {
		Collection<IGameObject> graveyard = currentLevel.getGraveYard();
		for (IGameObject obj : graveyard) {
			currentLevel.removeGameObject(obj);
			myViewController.removeViewObject(obj);
		}
		currentLevel.clearGraveYard();
	}
	
	private void processSpawnyard() {
		Collection<IGameObject> spawnyard = currentLevel.getSpawnYard();
		for (IGameObject obj : spawnyard) {
			currentLevel.addGameObject(obj);
			myViewController.addViewObject(obj);
		}
		currentLevel.clearSpawnYard();
	}

	private void updateStats() {

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
		if (code.equals(KeyCode.P)) {
			if (myGameTimeline.getCurrentRate() == 0.0) {
				myGameTimeline.play();
			}
			else {
				myGameTimeline.pause();
			}
		}
		else {
			currentLevel.receiveKeyPress(code);
		}
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
		myGameTimeline.play();
	}

	@Override
	public void endLevel(){
		myGameTimeline.pause();
	}
	
	public void initializeAnimation(double fl) {
		KeyFrame frame = new KeyFrame(Duration.seconds(fl), e -> updateGame());
		myGameTimeline = new Timeline();
		myGameTimeline.setCycleCount(Timeline.INDEFINITE);
		myGameTimeline.getKeyFrames().add(frame);
		startGame();
	}
	
}
