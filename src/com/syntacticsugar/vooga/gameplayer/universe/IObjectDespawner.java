package com.syntacticsugar.vooga.gameplayer.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IObjectDespawner {

	/**
	 * Get a Collection of GameObjects that have been added to the 
	 * Graveyard in this frame (ie. marked for despawn)
	 * @return
	 */
	public Collection<IGameObject> getGraveYard();
	
	/**
	 * Add a GameObject to the Graveyard (ie. mark it for despawn)
	 * @param toRemove
	 */
	public void addToGraveYard(IGameObject toRemove);
	
	/**
	 * Clear out the Graveyard (usually called after all despawns have
	 * been processed).
	 */
	public void clearGraveYard();

}
