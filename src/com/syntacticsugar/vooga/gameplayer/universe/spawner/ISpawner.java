package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import com.syntacticsugar.vooga.gameplayer.event.IGameEventListener;
import com.syntacticsugar.vooga.xml.data.SpawnerData;

public interface ISpawner extends IGameEventListener {
	
	public void nextWave();

	public void update();
	
	public int getWaveNum();
	
	public Wave getCurrentWave();
	
	public SpawnerData saveGame();
}
