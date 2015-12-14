package com.syntacticsugar.vooga.gameplayer.conditions;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public interface IGameCondition extends GameEventListener{

	
	/**
	 * Registers the object with the given event manager.
	 * @param manager the event manager to register the condition with
	 */
	public void registerManager(IEventPoster manager);

}
