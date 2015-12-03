package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class ScoreAttribute extends AbstractAttribute {
	
	private int myScore;
	
	public ScoreAttribute(int score) {
		myScore = score;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// TODO Auto-generated method stub

	}
	
	public int getScore() {
		return myScore;
	}

}
