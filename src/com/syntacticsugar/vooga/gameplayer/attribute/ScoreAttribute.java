package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public class ScoreAttribute extends AbstractAttribute {
	
	private Integer myScore;
	
	public ScoreAttribute(Integer score) {
		myScore = score;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		// TODO Auto-generated method stub

	}
	
	public Integer getScore() {
		return myScore;
	}

}
