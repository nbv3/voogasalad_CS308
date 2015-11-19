package simple.view.implementation;

import java.awt.Color;

import javafx.scene.Scene;
import javafx.stage.Stage;
import simple.manager.SimpleGameManager;
import simple.view.IViewManager;
import javafx.scene.layout.Pane;

public class SimpleGameScreenManager implements IViewManager{
	
	/**
	 * TODO These variables are always the same, put them 
	 * somewhere else
	 */
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private Stage myStage;

	public SimpleGameScreenManager(){
		SimpleGameMenu startingScreen = new SimpleGameMenu(this, WIDTH, HEIGHT, "Let's play a game");
		Scene welcome = new Scene(startingScreen, WIDTH, HEIGHT);
		//The following lines can be refactored 
		myStage = new Stage();
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}

	@Override
	public void launchGame() {
		SimpleGameManager man = new SimpleGameManager();
		Scene gameScene = new Scene(man.getGameView(), 600.0, 600.0);
		myStage.getScene().setOnKeyPressed(e -> man.receiveKeyPressed(e.getCode()));
		myStage.getScene().setOnKeyReleased(e -> man.receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
	}
	
	//useless for now
	public void launchEditor(){
		//create editor env, get buckets
	}

}
