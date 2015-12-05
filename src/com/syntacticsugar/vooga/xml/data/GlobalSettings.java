package com.syntacticsugar.vooga.xml.data;

public class GlobalSettings {

	private int level;
	private int mySpawnRate = 30;

	public GlobalSettings() {
		level = 1;
	}

	public GlobalSettings(int l) {
		level = l;
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
