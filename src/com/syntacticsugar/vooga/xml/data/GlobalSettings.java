package com.syntacticsugar.vooga.xml.data;

public class GlobalSettings {

	private int level;
	private int mySpawnRate;
	
	public GlobalSettings() {
		level = 1;
		mySpawnRate = 0;
	}
	
	public GlobalSettings(int l, int spawnRate) {
		level = l;
		setSpawnRate(spawnRate);
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int l) {
		level = l;
	}

	public int getSpawnRate() {
		return mySpawnRate;
	}

	public void setSpawnRate(int rate) {
		mySpawnRate = rate;
	}
}
