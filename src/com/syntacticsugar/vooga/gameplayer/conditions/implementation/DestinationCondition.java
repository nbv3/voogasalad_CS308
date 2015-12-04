package com.syntacticsugar.vooga.gameplayer.conditions.implementation;

import com.syntacticsugar.vooga.gameplayer.conditions.AbstractCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.DestinationReachedEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.universe.IEventPoster;

public class DestinationCondition extends AbstractCondition {

	public DestinationCondition(IEventPoster manager) {
		super(ConditionType.LOSING, manager);
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			DestinationReachedEvent event = (DestinationReachedEvent) e;
			postEvent(new LevelChangeEvent(this.returnType()));

		} catch (ClassCastException ce) {

		}
	}

}
