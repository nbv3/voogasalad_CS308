package com.syntacticsugar.vooga.gameplayer.event.implementations;

import com.syntacticsugar.vooga.gameplayer.event.GameEvent;
import com.syntacticsugar.vooga.gameplayer.event.GameEventType;

public class ScoreChangeEvent extends GameEvent {
	
	private int myScore;

	public ScoreChangeEvent(int score) {
		super(GameEventType.ScoreChange);
		myScore = score;
	}
	
	public int getScore() {
		return myScore;
	}

}
