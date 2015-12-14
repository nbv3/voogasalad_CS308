package com.syntacticsugar.vooga.gameplayer.event.implementations;

import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.event.GameEvent;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;

public class LevelChangeEvent extends GameEvent {

	public LevelChangeEvent(GameEventType type) {
		super(type);
	}


}
