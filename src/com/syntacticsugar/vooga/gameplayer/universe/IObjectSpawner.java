package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IObjectSpawner {
	
	public void addToSpawnYard(IGameObject toAdd);
	
	public void clearSpawnYard();

	public Collection<IGameObject> getSpawnYard();
	
}
