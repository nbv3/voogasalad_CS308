package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.IGameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public interface IEventManager extends IEventPoster{
	
	public void registerListener(IGameEventListener obj);

	public void removeListener(IGameEventListener obj);
	
}
