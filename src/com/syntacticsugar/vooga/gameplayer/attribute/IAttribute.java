package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.objects.IGameObject;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public interface IAttribute {

	/**
	 * Updates the state of this Attribute within it's Universe.
	 * @param universe
	 */
	public void updateSelf(IGameUniverse universe);
	
	/**
	 * Returns the game object that contains this Attribute (ie. it's parent object)
	 * @return IGameObject
	 */
	public IGameObject getParent();
	
	/**
	 * Set the parent game object for the this Attribute
	 * @param  IGameObject
	 */
	public void setParent(IGameObject parent);
	
}
