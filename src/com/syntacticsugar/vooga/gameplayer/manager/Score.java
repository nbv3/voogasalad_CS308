package com.syntacticsugar.vooga.gameplayer.manager;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;

public class Score implements IScore {
	
	public Score (IEventManager manager) {
		manager.registerListener(this);
	}

	@Override
	public void onEvent(IGameEvent e) {
		// TODO Auto-generated method stub

	}

}
