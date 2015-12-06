package com.syntacticsugar.vooga.gameplayer.conditions.implementation;

import com.syntacticsugar.vooga.gameplayer.conditions.AbstractCondition;
import com.syntacticsugar.vooga.gameplayer.conditions.ConditionType;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.DestinationReachedEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.LevelChangeEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.ScoreUpdateEvent;

public class ScoreCondition extends AbstractCondition {
	
	private int myScoreThreshold;
	
	public ScoreCondition(int threshold) {
		super(ConditionType.WINNING);
		myScoreThreshold = threshold;
	}

	@Override
	public void onEvent(IGameEvent e) {
		try {
			ScoreUpdateEvent event = (ScoreUpdateEvent) e;
			if (event.getScore() >= myScoreThreshold) {
				postEvent(new LevelChangeEvent(this.returnType()));
			}

		} catch (ClassCastException ce) {

		}
	}

}
