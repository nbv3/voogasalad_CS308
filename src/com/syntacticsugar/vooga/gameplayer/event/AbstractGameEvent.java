package com.syntacticsugar.vooga.gameplayer.event;

import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;

public abstract class AbstractGameEvent implements IGameEvent {

	private GameEventType myType;
	
	public AbstractGameEvent(GameEventType type) {
		this.myType = type;
	}
	
	@Override
	public GameEventType getEventType() {
		return this.myType;
	}
	
	@Override
	public abstract void executeEvent(Map<String, IAttribute> targetAttributes);
	
}
