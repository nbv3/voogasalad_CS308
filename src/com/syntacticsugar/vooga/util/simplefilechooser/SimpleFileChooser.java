package com.syntacticsugar.vooga.util.simplefilechooser;

import java.io.File;

import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.GameData;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SimpleFileChooser {
	public static File saveGame(GameData game, Stage myStage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game File");
		File f = fileChooser.showSaveDialog(myStage);
		game.setName(f.getName());
		XMLHandler<GameData> xml = new XMLHandler<>();
		xml.write(game, f);
		System.out.println(f.getName());
		return f;
	}
	
	public static GameData loadGame(Stage myStage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load Game File");
		File f = fileChooser.showSaveDialog(myStage);
		XMLHandler<GameData> xml = new XMLHandler<>();
		GameData gm = xml.read(f);
		return gm;
	}
}
