package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public interface IEventManager extends IEventPoster{
	
	public void registerListener(GameEventListener obj);

	public void removeListener(GameEventListener obj);
	
}
