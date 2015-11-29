package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.gameplayer.view.implementation.GameScreenManager;
import com.syntacticsugar.vooga.gameplayer.view.implementation.StartingMenu;

import authoring.AuthoringScreenManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private Stage myStage;
	
	public SceneManager(Stage stage) {
		myStage = stage;
		initFirstGameMenu();
	}
	
	public void initFirstGameMenu() {
		FirstGameMenu screen = new FirstGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		Scene welcome = new Scene(screen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}
	
	public void initAuthoringGameMenu() {	
		AuthoringGameMenu screen = new AuthoringGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		Scene welcome = new Scene(screen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
		//myStage.close();
		//new AuthoringScreenManager();
	}
	
	public void initEngineGameMenu() {
		EngineGameMenu screen = new EngineGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		Scene welcome = new Scene(screen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}
	
	public void launchNewEditor() {
		
	}
	
	public void launchLoadEditor() {
		
	}
	
	public void launchNewEngine() {
		
	}
	
	public void launchLoadEngine() {
		
	}
}
