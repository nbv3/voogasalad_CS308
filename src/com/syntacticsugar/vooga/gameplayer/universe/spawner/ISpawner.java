package com.syntacticsugar.vooga.gameplayer.universe.spawner;

public interface ISpawner {
	
	public void nextWave();

	public void update();
	
	public int getWaveNum();
	
	public Wave getCurrentWave();
}
