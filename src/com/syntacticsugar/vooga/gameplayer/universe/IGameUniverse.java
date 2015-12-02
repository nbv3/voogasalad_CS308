package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;
import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputProcessor;

public interface IGameUniverse extends IObjectCollection,
									   IKeyInputProcessor,
									   IEventPoster{

	/**
	 * A SimpleUniverse (anything that implements this interface) must contain a 
	 * Collection of GameObjects, add/remove methods, an implementation of ISimpleGameMap,
	 * and be able to send key press/release/mouse events directly to it's objects
	 */
	public void addPlayer(IGameObject player);
	
	/**
	 * Return a Collection of all the Players within the current Universe.
	 * @return
	 */
	public Collection<IGameObject> getPlayers();
	
	/**
	 * Returns a limited data view of the map in the Universe.
	 * @return
	 */
	public IGameMap getMap();
	
	public Collection<IGameCondition> getConditions();
	
	public void saveGame();
	
}
