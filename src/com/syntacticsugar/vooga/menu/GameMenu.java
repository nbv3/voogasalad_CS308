package com.syntacticsugar.vooga.menu;

import com.syntacticsugar.vooga.gameplayer.manager.GameManager;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GameMenu extends AbstractMenu{
	
	private double FRAME_LENGTH;
	private double GAME_SIZE;
	private GameData myGame;


	public GameMenu(GameData data) {
		super(data.getName());
		myGame = data;
		initializeVariables();
	}

	private void initializeVariables(){
		FRAME_LENGTH = 1.0 / getDoubleProperty("FrameLength");
		GAME_SIZE = getDoubleProperty("DefaultGameSize");
	}

	@Override
	protected void initializeOptions(BorderPane pane) {
		Button launchGame = createButton("Play Game", e -> launchNewEngine());
		Button loadGame = createButton("Load Game", e -> loadGame());
		Button help = createButton("Help", e -> getHelp());
		generateOptions(pane, launchGame, loadGame, help);
	}

	private void getHelp() {

	}

	private void loadGame() {

	}

	private void launchNewEngine() {
		hideStage();
		new GameManager(null, GAME_SIZE, myGame, FRAME_LENGTH);
	}
	
}
