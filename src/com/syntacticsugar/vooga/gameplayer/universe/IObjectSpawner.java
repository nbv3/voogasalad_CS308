package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.view.IViewAdder;

public interface IObjectSpawner {
	
	/**
	 * Get a Collection of GameObjects that have been added to the 
	 * SpawnYard in this frame (ie. marked for spawning)
	 * @return
	 */
	public void addToUniverse(IViewAdder adder);
	
	/**
	 * Add a GameObject to the SpawnYard (ie. mark it for spawning)
	 * @param toAdd
	 */
	public void addToSpawnYard(IGameObject toAdd);
	
	public SpawnYard getSpawnYard();

	
}
