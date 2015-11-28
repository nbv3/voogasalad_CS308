package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.gameplayer.view.IViewManager;

import authoring.AuthoringScreenManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartingScreenManager implements IViewManager {
	
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private Stage myStage;
	
	public StartingScreenManager(Stage stage){
		StartingMenu startingScreen = new StartingMenu(this, WIDTH, HEIGHT, "Vooga Salad");
		Scene welcome = new Scene(startingScreen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage = stage;
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}

	@Override
	public void launchGame() {
		myStage.close();
		new GameScreenManager();
	}
	
	public void launchEditor(){
		myStage.close();
		new AuthoringScreenManager();
	}

}
