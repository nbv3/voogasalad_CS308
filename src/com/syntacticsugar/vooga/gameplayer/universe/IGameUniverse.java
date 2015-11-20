package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputProcessor;

public interface IGameUniverse extends IObjectCollection,
										 IObjectAdder,
										 IObjectRemover,
										 IGameMap, 
										 IKeyInputProcessor,
										 IObjectSpawner,
										 IObjectDespawner {

	/**
	 * A SimpleUniverse (anything that implements this interface) must contain a 
	 * Collection of GameObjects, add/remove methods, an implementation of ISimpleGameMap,
	 * and be able to send key press/release/mouse events directly to it's objects
	 */

	/**
	 * Return the next integer id for the game object that is being added to the universe.
	 * @return
	 */
	public int getNextID();
	
	
}
