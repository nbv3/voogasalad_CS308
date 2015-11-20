package com.syntacticsugar.vooga.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.objects.IGameObject;

public interface IObjectSpawner {
	
	public void addToSpawnYard(IGameObject toAdd);
	
	public void clearSpawnYard();

	public Collection<IGameObject> getSpawnYard();
	
}
