package com.syntacticsugar.vooga.universe;

import com.syntacticsugar.vooga.objects.IGameObject;

public interface IObjectRemover {

	/**
	 * Remove this game object from the container.
	 * @param toRemove
	 */
	public void removeGameObject(IGameObject toRemove);
	
}
