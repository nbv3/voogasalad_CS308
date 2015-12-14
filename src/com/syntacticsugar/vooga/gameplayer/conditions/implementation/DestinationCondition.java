package com.syntacticsugar.vooga.gameplayer.conditions.implementation;

import com.syntacticsugar.vooga.gameplayer.conditions.AbstractCondition;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;

public class DestinationCondition extends AbstractCondition {

	public DestinationCondition() {
		super();
	}

	@Override
	protected void setDefaults() {

	}

	@Override
	public void onEvent(IGameEvent e) {
		if (e.getEventType().equals(GameEventType.DestinationReached)) {
			postEvent(new LevelChangeEvent(GameEventType.Losing));
		}
	}

}
