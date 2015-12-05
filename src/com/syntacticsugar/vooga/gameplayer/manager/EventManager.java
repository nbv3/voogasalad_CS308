package com.syntacticsugar.vooga.gameplayer.manager;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.event.IGameEventListener;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;

public class EventManager implements IEventManager {
	
	private List<IGameEventListener> myListeners;
	
	public EventManager() {
		myListeners = new ArrayList<>();
	}

	@Override
	public void postEvent(IGameEvent event) {
		for (IGameEventListener l: myListeners) {
			l.onEvent(event);
		}
	}

	@Override
	public void registerListener(IGameEventListener obj) {
		myListeners.add(obj);
	}
	
	@Override
	public void removeListener(IGameEventListener obj) {
		myListeners.remove(obj);
	}

}
