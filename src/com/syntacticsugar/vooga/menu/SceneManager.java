package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.gameplayer.view.implementation.StartingMenu;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private Stage myStage;
	
	public SceneManager(Stage stage) {
		myStage = stage;
	}
	
	private void initFirstGameMenu(Stage stage) {
		FirstGameMenu startingScreen = new FirstGameMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		Scene welcome = new Scene(startingScreen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}
	
	private void initAuthoringGameMenu() {
		
	}
	
	private void initEngineGameMenu() {
		
	}
}
