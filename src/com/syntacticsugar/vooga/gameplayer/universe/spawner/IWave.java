package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IWave {
	
	public IGameObject getObj();
	
	public int getWaveSize();
	
	public int getWaveNum();

}
