package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.gameplayer.manager.GameManager;

import authoring.AuthoringScreenManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private final double GAME_SIZE = 600.0;
	private Stage myStage;
	
	private final double FRAME_LENGTH = 1 / 60.0;
	private Scene gameScene;
	private GameManager myGameManager;
	private AuthoringScreenManager myAuthoringEnv;
	
	public SceneManager(Stage stage) {
		myStage = stage;
		myStage.setTitle("Vooga Salad");
		launchFirstMenu();
	}
	
	private void viewScene(AbstractGameMenu screen) {
		Scene scene = new Scene(screen, WIDTH, HEIGHT);
		myStage.setScene(scene);
		myStage.show();
	}
	
	public void launchFirstMenu() {
		AbstractGameMenu screen = new FirstGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		viewScene(screen);
	}
	
	public void launchAuthoringMenu() {	
		AbstractGameMenu screen = new AuthoringGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		viewScene(screen);
	}
	
	public void launchEngineMenu() {
		AbstractGameMenu screen = new EngineGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		viewScene(screen);
	}
	
	public void launchEnginePauseMenu() {
		// instance of gameScene is stored upon engine launch
		AbstractGameMenu screen = new EnginePauseMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		viewScene(screen);
	}
	
	public void launchAuthoringMenuFromAuthoring() {
		myAuthoringEnv.minimize();
		launchAuthoringMenu();
	}
	
	public void launchFirstMenuFromAuthoring() {
		myAuthoringEnv.minimize();
		launchFirstMenu();
	}
	
	public void launchNewEditor() {
		myStage.hide();
		myAuthoringEnv = new AuthoringScreenManager();
		myAuthoringEnv.setSceneManager(this);
	}
	
	public void launchLoadEditor() {
		myStage.hide();
		// TODO load from XML here or within GameManager?
		myAuthoringEnv = new AuthoringScreenManager();
		myAuthoringEnv.setSceneManager(this);
	}
	
	public void launchNewEngine() {
		myGameManager = new GameManager(GAME_SIZE);
		myGameManager.setManager(this);
		gameScene = new Scene(myGameManager.getGameView(), GAME_SIZE, GAME_SIZE);
		myGameManager.initializeAnimation(FRAME_LENGTH);
		gameScene.setOnKeyPressed(e -> myGameManager.receiveKeyPressed(e.getCode()));
		gameScene.setOnKeyReleased(e -> myGameManager.receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
	}
	
	public void launchLoadEngine() {
		// TODO modify to do direct load instead of launch
		
		// TODO load from XML here or within GameManager?
		myGameManager = new GameManager(GAME_SIZE);
		myGameManager.setManager(this);
		gameScene = new Scene(myGameManager.getGameView(), GAME_SIZE, GAME_SIZE);
		myGameManager.initializeAnimation(FRAME_LENGTH);
		gameScene.setOnKeyPressed(e -> myGameManager.receiveKeyPressed(e.getCode()));
		gameScene.setOnKeyReleased(e -> myGameManager.receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
	}
	
	public void launchUnpauseEngine() {
		// should be slightly changed from loadEngine
		// TODO call myGameManager.unpause() or something like that
		myStage.setScene(gameScene);
	}
}
