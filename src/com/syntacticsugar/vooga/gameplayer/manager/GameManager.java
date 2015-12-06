package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.game.Game;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.GameViewController;
import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.xml.data.GameData;
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

public class GameManager implements IGameManager,IVoogaApp {

	private Game myGame;
	private IGameUniverse currentLevel;
	private Timeline myGameTimeline;
	private GameEngine myGameEngine;

	private IEventManager myEventManager;

	private GameViewController myViewController;
	private Stage myStage;
	private double frameLength;

	public GameManager(EventHandler<WindowEvent> onClose, double gameSize, GameData data, double frameRate) {
		this.frameLength = frameRate;
		myStage = new Stage();
		myStage.setOnCloseRequest(onClose);

		myEventManager = new EventManager();
		myEventManager.registerListener(this);

		myGame = new Game(data);
		currentLevel = myGame.getLevel(1);
		

		myViewController = new GameViewController(gameSize);
		myViewController.displayLevel(currentLevel, myEventManager);
		

		
		currentLevel.registerListeners(myEventManager);
		myGameEngine = new GameEngine();

		myGameEngine.registerViewAdder(myViewController);
		myGameEngine.registerViewRemover(myViewController);
		
		stageInit();
	}

	private void stageInit() {
		Scene gameScene = new Scene(myViewController.getGameView());
		initializeAnimation(frameLength);
		gameScene.addEventFilter(KeyEvent.KEY_PRESSED, e -> receiveKeyPressed(e.getCode()));
		gameScene.addEventFilter(KeyEvent.KEY_RELEASED, e -> receiveKeyReleased(e.getCode()));
		gameScene.setOnKeyPressed(e -> receiveKeyPressed(e.getCode()));
		gameScene.setOnKeyReleased(e -> receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
		myStage.show();
	}
	

	private void nextLevel() {
		try{
		currentLevel = myGame.nextLevel();
		}
		catch(IndexOutOfBoundsException e){
			myStage.close();
		}
		myViewController.displayLevel(currentLevel, myEventManager);
		myEventManager = new EventManager();
		myEventManager.registerListener(this);
		currentLevel.registerListeners(myEventManager);
		myGameEngine.registerViewAdder(myViewController);
		myGameEngine.registerViewRemover(myViewController);
		initializeAnimation(frameLength);
	}

	@Override
	public void updateGame() {
		myGameEngine.update(currentLevel);
	}

	public void pause() {
		myGameTimeline.pause();
	}

	@Override
	public void switchLevel(ConditionType type) {
		pause();
		if (type.equals(ConditionType.WINNING)) {
			System.out.println("WINNER");
			nextLevel();
		} else if (type.equals(ConditionType.LOSING)) {
			System.out.println("YOU LOSE");
			startGame();
		}

	}


	public void receiveKeyPressed(KeyCode code) {
		if (code.equals(KeyCode.P)) {
			if (myGameTimeline.getCurrentRate() == 0.0) {
				myGameTimeline.play();
			} else {
				myGameTimeline.pause();
			}
		} else if (code.equals(KeyCode.S)) {
			saveGame();
		} else {
			currentLevel.receiveKeyPress(code);
		}
	}

	public void receiveKeyReleased(KeyCode code) {
		currentLevel.receiveKeyRelease(code);
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
			System.out.println("LEVEL SWITCH");
			switchLevel(event.getLevelConditionType());
		} catch (ClassCastException ex) {

		}
	}

	private void saveGame() {
		UniverseData data = currentLevel.saveGame();
		myGame.saveGame(data);
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
	}

}
