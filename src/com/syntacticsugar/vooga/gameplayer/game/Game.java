package com.syntacticsugar.vooga.gameplayer.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.GameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.GameData;
import com.syntacticsugar.vooga.xml.data.UniverseData;

public class Game implements IGame {
	
	private List<IGameUniverse> myUniverses;
	
	private List<UniverseData> myUniverseData; // For saving
	
	private int myLevel; // STARTS AT 1 BY CONVENTION
	
	public Game(GameData data, IEventManager manager) {
		Collection<UniverseData> udata =  data.getUniverses();
		myUniverses = new ArrayList<>();
		myUniverseData = new ArrayList<>();
		for (UniverseData d: udata) {
			myUniverses.add(new GameUniverse(d, data.getSettings(), manager));
			myUniverseData.add(d);
		}
		myLevel = data.getSettings().getLevel();
	}

	@Override
	public IGameUniverse nextLevel() {
		return myUniverses.get(++myLevel);
	}
	
	@Override
	public IGameUniverse getLevel(int i) {
		return myUniverses.get(i - 1);
	}
	
	@Override
	public void saveGame(UniverseData d) {
		myUniverseData.remove(myLevel - 1);
		myUniverseData.add(myLevel - 1, d);
		Collection<UniverseData> gameSave = (Collection<UniverseData>) myUniverseData;
		XMLHandler<GameData> xmlMake = new XMLHandler<>();
//		xmlMake.write(object, f);
		//TODO: Write it to a file (look at the authoring env object save
//		xmlMake.writeXMLToFile(xmldata, f);
	}

}
