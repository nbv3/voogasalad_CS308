package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.gameplayer.manager.GameManager;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameScreenManager implements IViewManager {

	private final double FRAME_LENGTH = 1/60.0;
	private GameManager myGameManager;
	/**
	 * TODO These variables are always the same, put them 
	 * somewhere else
	 */
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private Stage myStage;

	public GameScreenManager(){
		GameMenu startingScreen = new GameMenu(this, WIDTH, HEIGHT, "Let's play a game");
		Scene welcome = new Scene(startingScreen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage = new Stage();
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}

	@Override
	public void launchGame() {
		myGameManager = new GameManager();
		Scene gameScene = new Scene(myGameManager.getGameView(), 600.0, 600.0);
		initializeAnimation();
		gameScene.setOnKeyPressed(e -> myGameManager.receiveKeyPressed(e.getCode()));
		gameScene.setOnKeyReleased(e -> myGameManager.receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
	}
	
	private void initializeAnimation() {
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAME_LENGTH),
                e -> myGameManager.updateGame());
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	@Override
	public void launchEditor() {
		// TODO Auto-generated method stub
		
	}


}
