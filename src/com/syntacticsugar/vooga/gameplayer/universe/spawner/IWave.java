package com.syntacticsugar.vooga.gameplayer.universe.spawner;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IWave {
	
	public IGameObject getObj();
	
	public int getWaveSize();
	
	public int getWaveNum();
	
	public Collection<IGameObject> getAllObjs();

}
