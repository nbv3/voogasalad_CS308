package com.syntacticsugar.vooga.gameplayer.conditions;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public abstract class AbstractCondition implements IGameCondition, IEventPoster {


	private IEventPoster myManager;

	public AbstractCondition() {
		setDefaults();
	}

	/**
	 * Set default condition values.
	 */
	protected abstract void setDefaults();
	
	@Override
	public void registerManager(IEventPoster manager){
		myManager = manager;
	}
	
	@Override
	public void postEvent(IGameEvent event){
		myManager.postEvent(event);
	}
	
}
