package com.syntacticsugar.vooga.gameplayer.universe;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;

public interface IObjectRemover {

	/**
	 * Remove this game object from the container.
	 * @param toRemove
	 */
	public void removeGameObject(IGameObject toRemove);
	
}
