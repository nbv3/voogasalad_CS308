package com.syntacticsugar.vooga.gameplayer.game;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.GameData;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.UniverseData;
import com.syntacticsugar.vooga.xml.data.GlobalSettings;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Game implements IGame {
	
	private List<IGameUniverse> myUniverses;
	
	private List<UniverseData> myUniverseData; // For saving
	private GlobalSettings mySettings;
	
	private int myLevel; // STARTS AT 1
	
	public Game(GameData data, IEventManager eventManager) {
		Collection<UniverseData> udata =  data.getUniverses();
		myUniverses = new ArrayList<>();
		myUniverseData = new ArrayList<>();
		for (UniverseData d: udata) {
			myUniverses.add(new GameUniverse(d, data.getSettings(), eventManager));
			myUniverseData.add(d);
		}
		mySettings = data.getSettings();
		myLevel = mySettings.getLevel();
	}

	@Override
	public IGameUniverse nextLevel() {
		return myUniverses.get(myLevel++);
	}
	
	@Override
	public IGameUniverse getLevel(int i) {
		return myUniverses.get(i - 1);
	}
	
	@Override
	public void saveGame(UniverseData d) {
		myUniverseData.remove(myLevel - 1);
		myUniverseData.add(myLevel - 1, d);
		Collection<UniverseData> gameData = (Collection<UniverseData>) myUniverseData;
		mySettings.setLevel(myLevel);
		GameData gameSave = new GameData(gameData, mySettings);
		XMLHandler<GameData> xmlMake = new XMLHandler<>();

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game");
		File selectedFile = fileChooser.showSaveDialog(new Stage());
		if (selectedFile != null) {
			xmlMake.write(gameSave, selectedFile);
		}
		//TODO: Write it to a file (look at the authoring env object save
//		xmlMake.writeXMLToFile(xmldata, f);
	}

}
