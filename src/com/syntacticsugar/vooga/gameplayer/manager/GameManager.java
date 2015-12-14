// This entire file is part of my masterpiece.
// Nicholas von Turkovich (nbv3)

package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.engine.GameEngine;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.game.Game;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.view.GameViewController;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class GameManager implements IGameManager {

	private Game myGame;
	private IGameUniverse currentLevel;
	private Timeline myGameTimeline;
	private GameEngine myGameEngine;
	private IEventManager myEventManager;
	private GameViewController myViewController;
	private double frameLength;
	private IViewManager myView;

	public GameManager(IViewManager view, EventHandler<WindowEvent> onclose, double gameSize, GameData data,
			double frameRate) {
		myView = view;
		this.frameLength = frameRate;
		myEventManager = new EventManager();
		myGame = new Game(data);
		myViewController = new GameViewController(gameSize);
		currentLevel = myGame.getLevel(1);
		myGameEngine = new GameEngine();

		myEventManager.registerListener(this);
		myViewController.displayLevel(currentLevel, myEventManager);
		currentLevel.registerListeners(myEventManager);
		myGameEngine.registerViewAdder(myViewController);
		myGameEngine.registerViewRemover(myViewController);

		myView.initializeView(myViewController.getGameView(), e -> receiveKeyPressed(e.getCode()),
				e -> receiveKeyReleased(e.getCode()));
		initializeAnimation();
	}

	private void createGameOver(GameEventType type) {
		myGameTimeline.stop();
		myView.createGameOver(type);

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
		initializeAnimation();
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

	@Override
	public void initializeAnimation() {
		KeyFrame frame = new KeyFrame(Duration.seconds(frameLength), e -> updateGame());
		myGameTimeline = new Timeline();
		myGameTimeline.setCycleCount(Timeline.INDEFINITE);
		myGameTimeline.getKeyFrames().add(frame);
		startGame();
	}

	@Override
	public void onEvent(IGameEvent e) {
		switchLevel(e.getEventType());
	}

}
