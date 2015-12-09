package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.manager.IEventManager;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputProcessor;
import com.syntacticsugar.vooga.xml.data.UniverseData;

public interface IGameUniverse extends IObjectCollection,
									   IKeyInputProcessor,
									   IEventPoster,
									   IUniverseView{

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
	
	public void registerListeners(IEventManager manager);
	
	
}
