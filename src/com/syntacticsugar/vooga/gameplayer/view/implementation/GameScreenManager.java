package com.syntacticsugar.vooga.gameplayer.view.implementation;

import com.syntacticsugar.vooga.gameplayer.manager.GameManager;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;

import authoring.AuthoringScreenManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScreenManager implements IViewManager {

	private final double FRAME_LENGTH = 1 / 60.0;
	private GameManager myGameManager;
	private AuthoringScreenManager myAuthoringEnv;
	/**
	 * TODO These variables are always the same, put them somewhere else
	 */
	private final double WIDTH = 600.0;
	private final double HEIGHT = 600.0;
	private Stage myStage;

	public GameScreenManager() {
		GameMenu startingScreen = new GameMenu(this, WIDTH, HEIGHT, "Let's play a game");
		Scene welcome = new Scene(startingScreen, WIDTH, HEIGHT);
		// The following lines can be refactored
		myStage = new Stage();
		myStage.setScene(welcome);
		myStage.setTitle("Vooga Salad");
		myStage.show();
	}
	
	// currently console file selection
//	private IGameManager loadXML() {
//		Directory gameFiles = null;
//		try {
//			gameFiles = new Directory("src\\com\\syntacticsugar\\vooga\\resources\\xml\\games");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		List<File> files = gameFiles.getFilesByExtension(".xml");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Available game files: ");
//		for (int i=0; i<files.size(); i++) {
//			System.out.printf("%3d : %s\n", i, files.get(i).getName());
//		}
//		System.out.println("Select the desired file by entering number and pressing Enter: ");
//		int selection = Integer.parseInt(sc.nextLine());
//		sc.close();
//		File f = files.get(selection);
//		
//		LoaderSaver ls = new LoaderSaver();
//		IGameManager gm = null;
//		try {
//			gm = ls.loadFromFile(f);
//		} catch (LoadingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return gm;
//	}

	private GameManager loadXML() {
		return new GameManager(600.0);
	}

	@Override
	public void launchGame() {
		double gameSize = 600.0;
		myGameManager = new GameManager(gameSize);
		Scene gameScene = new Scene(myGameManager.getGameView(), gameSize, gameSize);
		myGameManager.initializeAnimation(FRAME_LENGTH);
		gameScene.setOnKeyPressed(e -> myGameManager.receiveKeyPressed(e.getCode()));
		gameScene.setOnKeyReleased(e -> myGameManager.receiveKeyReleased(e.getCode()));
		myStage.setScene(gameScene);
	}


	@Override
	public void launchEditor() {
		// Takes it back to the authoring environment
		myAuthoringEnv = new AuthoringScreenManager();
	}

}
