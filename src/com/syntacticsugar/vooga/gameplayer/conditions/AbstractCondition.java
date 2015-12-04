package com.syntacticsugar.vooga.gameplayer.conditions;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public abstract class AbstractCondition implements IGameCondition, IEventPoster {

	private ConditionType myType;
	private IEventPoster myManager;

	public AbstractCondition(ConditionType type, IEventPoster manager) {
		myType = type;
		myManager = manager;
	}

	public ConditionType returnType() {
		return myType;
	}
	
	@Override
	public void postEvent(IGameEvent event){
		myManager.postEvent(event);
	}
	
	


}
