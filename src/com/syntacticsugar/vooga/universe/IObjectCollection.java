package com.syntacticsugar.vooga.universe;

import java.util.Collection;

import com.syntacticsugar.vooga.objects.IGameObject;

public interface IObjectCollection {

	/**
	 * Returns all game objects within this container.
	 * @return
	 */
	public Collection<IGameObject> getGameObjects();

		
}