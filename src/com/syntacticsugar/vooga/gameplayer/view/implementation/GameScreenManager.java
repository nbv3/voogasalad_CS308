package com.syntacticsugar.vooga.gameplayer.view.implementation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.syntacticsugar.vooga.gameplayer.manager.GameManager;
import com.syntacticsugar.vooga.gameplayer.manager.IGameManager;
import com.syntacticsugar.vooga.gameplayer.view.IViewManager;
import com.syntacticsugar.vooga.util.filefinder.Directory;
import com.syntacticsugar.vooga.util.xml.LoaderSaver;
import com.syntacticsugar.vooga.util.xml.LoadingException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameScreenManager implements IViewManager {

	private final double FRAME_LENGTH = 1 / 60.0;
	private GameManager myGameManager;
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
	private IGameManager loadXML() {
		Directory gameFiles = null;
		try {
			gameFiles = new Directory("src\\com\\syntacticsugar\\vooga\\resources\\xml\\games");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<File> files = gameFiles.getFilesByExtension(".xml");
		Scanner sc = new Scanner(System.in);
		System.out.println("Available game files: ");
		for (int i=0; i<files.size(); i++) {
			System.out.printf("%3d : %s\n", i, files.get(i).getName());
		}
		System.out.println("Select the desired file by entering number and pressing Enter: ");
		int selection = Integer.parseInt(sc.nextLine());
		sc.close();
		File f = files.get(selection);
		
		LoaderSaver ls = new LoaderSaver();
		IGameManager gm = null;
		try {
			gm = ls.loadFromFile(f);
		} catch (LoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return gm;
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
		KeyFrame frame = new KeyFrame(Duration.seconds(FRAME_LENGTH), e -> myGameManager.updateGame());
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
