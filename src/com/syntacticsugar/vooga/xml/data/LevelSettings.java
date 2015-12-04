package com.syntacticsugar.vooga.xml.data;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;

public class LevelSettings {

	private IGameCondition winCond;
	private IGameCondition lossCond;
	
	private int scoreThreshold;
	
	public LevelSettings (int score) {
		setScoreThreshold(score);
	}

	public int getScoreThreshold() {
		return scoreThreshold;
	}

	public void setScoreThreshold(int scoreThreshold) {
		this.scoreThreshold = scoreThreshold;
	}
}
