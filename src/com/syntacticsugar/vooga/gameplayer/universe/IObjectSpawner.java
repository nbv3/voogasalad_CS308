package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.spawner.ISpawner;

public interface IObjectSpawner {
	
	/**
	 * Get a Collection of GameObjects that have been added to the 
	 * SpawnYard in this frame (ie. marked for spawning)
	 * @return
	 */
	public Collection<IGameObject> getSpawnYard();
	
	/**
	 * Add a GameObject to the SpawnYard (ie. mark it for spawning)
	 * @param toAdd
	 */
	public void addToSpawnYard(IGameObject toAdd);
	
	/**
	 * Clear out the SpawnYard (usually called after all spawns have
	 * been processed).
	 */
	public void clearSpawnYard();
	
	public ISpawner getSpawner();
	
}
