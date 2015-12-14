
package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
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
		myEventManager = new EventManager();
		onClose = onclose;
		myGame = new Game(data);
		myViewController = new GameViewController(gameSize);
		currentLevel = myGame.getLevel(1);
		myGameEngine = new GameEngine();

		myStage.setOnCloseRequest(onclose);
		myEventManager.registerListener(this);
		myViewController.displayLevel(currentLevel, myEventManager);
		currentLevel.registerListeners(myEventManager);
		myGameEngine.registerViewAdder(myViewController);
		myGameEngine.registerViewRemover(myViewController);

		stageInit();
	}

	private void createGameOver(GameEventType type) {
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

	private void resetGame() {
		myGame.reset();
		currentLevel = myGame.getLevel(1);
		reconfigureEngine();
	}

	private void reconfigureEngine() {
		myViewController.displayLevel(currentLevel, myEventManager);
		myEventManager = new EventManager();
		myEventManager.registerListener(this);
		currentLevel.registerListeners(myEventManager);
		myGameEngine.registerViewAdder(myViewController);
		myGameEngine.registerViewRemover(myViewController);
		initializeAnimation(frameLength);
	}

	private void changeLevel() {
		if (myGame.containsNextLevel()) {
			reconfigureEngine();
		} else {
			myGameTimeline.pause();
			createGameOver(GameEventType.Winning);
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
			changeLevel();
		} else if (type.equals(GameEventType.Losing)) {
			resetGame();
		} else {
			startGame();
		}

	}

	private void receiveKeyPressed(KeyCode code) {
		currentLevel.receiveKeyPress(code);
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
		switchLevel(e.getEventType());
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
	}

}
