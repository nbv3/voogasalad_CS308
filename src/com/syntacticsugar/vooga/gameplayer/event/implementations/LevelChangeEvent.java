package com.syntacticsugar.vooga.gameplayer.event.implementations;

import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.event.GameEvent;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;

public class LevelChangeEvent extends GameEvent {
	
	private ConditionType myType;

	public LevelChangeEvent(ConditionType type) {
		super(GameEventType.LevelChange);
		myType = type;
	}
	
	public ConditionType getType(){
		return myType;
	}

}
