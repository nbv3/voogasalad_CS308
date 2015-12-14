
package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.game.Game;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.GameViewController;
import com.syntacticsugar.vooga.menu.GameOver;
import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class GameManager implements IGameManager, IVoogaApp {

	private Game myGame;
	private IGameUniverse currentLevel;
	private Timeline myGameTimeline;
	private GameEngine myGameEngine;
	private IEventManager myEventManager;
	private GameViewController myViewController;
	private Stage myStage;
	private double frameLength;
	private EventHandler<WindowEvent> onClose;

	public GameManager(EventHandler<WindowEvent> onclose, double gameSize, GameData data, double frameRate) {
		this.frameLength = frameRate;
		myStage = new Stage();
		myStage.setOnCloseRequest(onclose);
		myEventManager = new EventManager();
		myEventManager.registerListener(this);
		onClose = onclose;
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

	private void createGameOver(ConditionType type) {
		myGameTimeline.stop();
		myStage.close();
		new GameOver(onClose, type);

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

	private void nextLevel(boolean bool) {
		try {
			if (bool) {
				currentLevel = myGame.getLevel(1);
			} else {
				currentLevel = myGame.nextLevel();
			}
			myViewController.displayLevel(currentLevel, myEventManager);
			myEventManager = new EventManager();
			myEventManager.registerListener(this);
			currentLevel.registerListeners(myEventManager);
			myGameEngine.registerViewAdder(myViewController);
			myGameEngine.registerViewRemover(myViewController);
			initializeAnimation(frameLength);
		} catch (IndexOutOfBoundsException e) {
			myGameTimeline.pause();
			createGameOver(ConditionType.WINNING);

		}

	}

	@Override
	public void updateGame() {
		myGameEngine.update(currentLevel);
	}

	private void pause() {
		myGameTimeline.pause();
	}

	private void switchLevel(GameEventType type) {
		pause();
		if (type.equals(GameEventType.Winning)) {
			System.out.println("WINNER");
			nextLevel(false);
		} else if (type.equals(GameEventType.Losing)) {
			System.out.println("YOU LOSE");
			myGame.reset();
			nextLevel(true);
		}

	}

	private void receiveKeyPressed(KeyCode code) {
		if (code.equals(KeyCode.P)) {
			if (myGameTimeline.getCurrentRate() == 0.0) {
				myGameTimeline.play();
			} else {
				myGameTimeline.pause();
			}
		} else {
			currentLevel.receiveKeyPress(code);
		}
	}

	private void receiveKeyReleased(KeyCode code) {
		currentLevel.receiveKeyRelease(code);
	}

	private void startGame() {
		myGameTimeline.play();
	}

	private void initializeAnimation(double fl) {
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
			switchLevel(event.getEventType());
		} catch (ClassCastException ex) {

		}
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
	}

}
