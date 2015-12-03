package com.syntacticsugar.vooga.gameplayer.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.ScoreAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.WeaponAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.game.Game;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.ViewController;
import com.syntacticsugar.vooga.xml.data.GameData;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.UniverseData;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class GameManager implements IGameManager{

	private Game myGame;
	private IGameUniverse currentLevel;
	// private List<IGameCondition> myConditions;
	// private GameInformation myInformation;
	private Timeline myGameTimeline;
	private GameEngine myGameEngine;

	private IEventManager myEventManager;
	
	private ViewController myViewController;
	
	// engine stage
	private Stage myStage;
	private double frameLength;
	
	private List<EventListener> myListeners; // Will go in game players

	public GameManager(EventHandler<WindowEvent> onClose, double gameSize, GameData data, double frameRate) {
		this.frameLength = frameRate;
		myStage = new Stage();
		myStage.setOnCloseRequest(onClose);

		myEventManager = new EventManager();

		myGame = new Game(data, myEventManager);
		currentLevel = myGame.getLevel(1);
		// myConditions = new ArrayList<IGameCondition>();
		// myConditions.add(new PlayerDeathCondition());

		myViewController = new ViewController(gameSize);

		// i changed ISimpleObject to SimpleObject, else addViewObject does not
		// work
		String playerPath = "player_pacman.png";
		String enemyPath = "enemy_monster_1.png";
		String missilePath = "pink.png";

		ObjectData playerData = new ObjectData();
		List<IAttribute> attributes = new ArrayList<IAttribute>();
		attributes.add(new HealthAttribute(100));
		attributes.add(new MovementControlAttribute(3));
		attributes.add(new WeaponAttribute(missilePath, 100, KeyCode.SPACE));
		playerData.setType(GameObjectType.PLAYER);
		playerData.setSpawnPoint(0, 0);
		playerData.setWidth(50);
		playerData.setHeight(50);
		playerData.setImagePath(playerPath);
		playerData.setAttributes(attributes);

		ObjectData enemyData = new ObjectData();
		Collection<IAttribute> enemyAttributes = new ArrayList<IAttribute>();
		enemyAttributes.add(new HealthAttribute(30));
		enemyAttributes.add(new ScoreAttribute(50));
//		enemyAttributes.add(new AIMovementAttribute(3));
		Map<GameObjectType, Collection<ICollisionEvent>> collisions = new HashMap<GameObjectType, Collection<ICollisionEvent>>();
		Collection<ICollisionEvent> enemyEvents = new ArrayList<ICollisionEvent>();
		enemyEvents.add(new HealthChangeEvent(-10));
		collisions.put(GameObjectType.PLAYER, enemyEvents);
		enemyData.setType(GameObjectType.ENEMY);
		enemyData.setSpawnPoint(150, 150);
		enemyData.setWidth(100);
		enemyData.setHeight(100);
		enemyData.setImagePath(enemyPath);
		enemyData.setAttributes(enemyAttributes);
		enemyData.setCollisionMap(collisions);

		IGameObject player = new GameObject(playerData);
		IGameObject enemy = new GameObject(enemyData);

		currentLevel.addPlayer(player);
		currentLevel.addGameObject(player);
		currentLevel.addGameObject(enemy);

		myViewController.initializeView(currentLevel);
		myGameEngine = new GameEngine(currentLevel, myViewController, this);

		stageInit();
	}

	private void stageInit() {
		Scene gameScene = new Scene(getGameView());
		initializeAnimation(frameLength);
		gameScene.addEventFilter(KeyEvent.KEY_PRESSED, e -> receiveKeyPressed(e.getCode()));
		gameScene.addEventFilter(KeyEvent.KEY_RELEASED, e -> receiveKeyReleased(e.getCode()));
//		gameScene.addEventFilter(KeyEvent.KEY_PRESSED, e -> System.out.println(e.getCode()));
//		gameScene.addEventFilter(KeyEvent.KEY_RELEASED, e -> System.out.println(e.getCode()));
		gameScene.setOnKeyPressed(e -> receiveKeyPressed(e.getCode()));
		gameScene.setOnKeyReleased(e -> receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
		myStage.show();
	}

	@Override
	public void restartGame() {

	}

	@Override
	public void updateGame() {
		myGameEngine.update();
		
	}
	
	public void pause() {
		
	}
	

	@Override
	public void switchLevel(ConditionType type) {
		if (type.equals(ConditionType.WINNING)) {
			currentLevel = myGame.nextLevel();
		} else if (type.equals(ConditionType.LOSING)) {
			// go backward?
			System.out.println("YOU LOSE");
			pause();
		}

	}

	public void receiveKeyPressed(KeyCode code) {
		if (code.equals(KeyCode.P)) {
			if (myGameTimeline.getCurrentRate() == 0.0) {
				myGameTimeline.play();
			} else {
				myGameTimeline.pause();
			}
		} 
		else if (code.equals(KeyCode.S)) {
			saveGame();
		}
		else {
			myGameEngine.receiveKeyPressed(code);
		}
	}

	public void receiveKeyReleased(KeyCode code) {
		myGameEngine.receiveKeyReleased(code);
	}

	public Pane getGameView() {
		return myGameEngine.getGameView();
	}

	@Override
	public void startGame() {
		myGameTimeline.play();
	}

	public void initializeAnimation(double fl) {
		KeyFrame frame = new KeyFrame(Duration.seconds(fl), e -> updateGame());
		myGameTimeline = new Timeline();
		myGameTimeline.setCycleCount(Timeline.INDEFINITE);
		myGameTimeline.getKeyFrames().add(frame);
		startGame();
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			LevelChangeEvent event = (LevelChangeEvent) e;
			myGame.nextLevel();
		}
		catch (ClassCastException ex) {
			
		}
	}
	
	private void saveGame() {
		UniverseData data = currentLevel.saveGame();
		myGame.saveGame(data);
	}

}
