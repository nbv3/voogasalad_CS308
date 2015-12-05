package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import com.syntacticsugar.vooga.gameplayer.event.GameEventListener;
import com.syntacticsugar.vooga.gameplayer.universe.score.IEventListener;
import com.syntacticsugar.vooga.xml.data.SpawnerData;

public interface ISpawner extends GameEventListener, IEventListener {
	
	public void nextWave();

	public void update();
	
	public int getWaveNum();
	
	public Wave getCurrentWave();
	
	public SpawnerData saveGame();
	
	public Integer getSpawnRate();
}
