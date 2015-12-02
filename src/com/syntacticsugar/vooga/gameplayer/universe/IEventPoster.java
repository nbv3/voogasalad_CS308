package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ObjectSpawnEvent;

public interface IEventPoster {
	
	public void postEvent(IGameEvent event);
	
}
