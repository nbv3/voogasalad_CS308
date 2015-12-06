package com.syntacticsugar.vooga.xml.data;

import java.util.Collection;

public class WaveData {

	private Collection<ObjectData> objs;
	
	private int spawnRate;
	
	public WaveData(Collection<ObjectData> data) {
		objs = data;
	}
	
	public WaveData(Collection<ObjectData> data, int rate) {
		objs = data;
		spawnRate = rate;
	}
	
	public Collection<ObjectData> getObjs () {
		return objs;
	}
	
	public int getSpawnRate() {
		return spawnRate;
	}

	public void setSpawnRate(int rate) {
		spawnRate = rate;
	}
	
}
