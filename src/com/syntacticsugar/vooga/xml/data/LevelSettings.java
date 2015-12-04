package com.syntacticsugar.vooga.xml.data;

import java.awt.Point;

public class LevelSettings {

	private int scoreThreshold;
	private Point playerSpawn;
	
	public LevelSettings (int score) {
		setScoreThreshold(score);
	}

	public int getScoreThreshold() {
		return scoreThreshold;
	}

	public void setScoreThreshold(int scoreThreshold) {
		this.scoreThreshold = scoreThreshold;
	}
	
	public Point getSpawnPoint(){
		return playerSpawn;
	}
	
	public void setSpawnPoint(Point spot){
		playerSpawn = spot;
	}
}
