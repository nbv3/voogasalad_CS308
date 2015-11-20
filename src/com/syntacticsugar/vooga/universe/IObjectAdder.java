package com.syntacticsugar.vooga.universe;

import com.syntacticsugar.vooga.objects.IGameObject;

public interface IObjectAdder {

	/**
	 * Adds a single object to the container.
	 * @param gameObject
	 */
	public void addGameObject(IGameObject toAdd);
	
}
