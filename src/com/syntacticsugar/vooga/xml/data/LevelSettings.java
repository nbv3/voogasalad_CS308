package com.syntacticsugar.vooga.xml.data;

import com.syntacticsugar.vooga.gameplayer.conditions.IGameCondition;

public class LevelSettings {

	private IGameCondition winCond;
	private IGameCondition lossCond;

	private int mySpawnRate;
	
	private int scoreThreshold;
	
	public LevelSettings (int score) {
		setScoreThreshold(score);
		mySpawnRate = 0;
	}
	
	public LevelSettings (int score, int spawnRate) {
		setScoreThreshold(score);
		mySpawnRate = spawnRate;
	}

	public int getScoreThreshold() {
		return scoreThreshold;
	}

	public void setScoreThreshold(int scoreThreshold) {
		this.scoreThreshold = scoreThreshold;
	}
	
	public int getSpawnRate() {
		return mySpawnRate;
	}

	public void setSpawnRate(int rate) {
		mySpawnRate = rate;
	}
	
}
