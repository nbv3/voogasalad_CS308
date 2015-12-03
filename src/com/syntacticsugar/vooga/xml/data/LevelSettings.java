package com.syntacticsugar.vooga.xml.data;

public class LevelSettings {

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
