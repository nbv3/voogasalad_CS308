package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.money.IMoney;
import com.syntacticsugar.vooga.gameplayer.universe.score.IScore;
import com.syntacticsugar.vooga.xml.data.TowerData;

/**
 * This class contains the interface between the game universe and the view
 *
 */

public interface IUniverseView extends IObjectCollection {
	
	public Collection<TowerData> getAvailableTowers();
	
	public IScore getScore();
	
	public IMoney getMoney();
	
	public void observeScore(Observer observer);
	
	public void observeMoney(Observer observer);
	
	public IGameMap getMap();

}
