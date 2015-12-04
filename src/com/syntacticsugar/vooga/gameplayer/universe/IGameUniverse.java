package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;
import java.util.Observer;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.score.IScore;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputProcessor;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.UniverseData;

public interface IGameUniverse extends IObjectCollection,
									   IKeyInputProcessor,
									   IEventPoster{

	/**
	 * A SimpleUniverse (anything that implements this interface) must contain a 
	 * Collection of GameObjects, add/remove methods, an implementation of ISimpleGameMap,
	 * and be able to send key press/release/mouse events directly to it's objects
	 */
	
	
	/**
	 * Returns a limited data view of the map in the Universe.
	 * @return
	 */
	public IGameMap getMap();
	
	public UniverseData saveGame();
	
	public Collection<ObjectData> getAvailableTowers();
	
	public IScore getScore();
	
	public void observeScore(Observer observer);
	
}
