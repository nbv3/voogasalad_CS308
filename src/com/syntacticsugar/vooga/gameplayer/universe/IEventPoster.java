package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;

public interface IEventPoster {
	
	public void postEvent(IGameEvent event);
	
}
