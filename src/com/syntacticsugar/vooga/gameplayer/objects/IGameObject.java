package com.syntacticsugar.vooga.gameplayer.objects;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public interface IGameObject extends IAttributeCollection, ICollidable, IViewableObject {

	/**
	 * Update this object within the context of the whole universe.
	 * @param universe
	 */
	public void updateSelf(IGameUniverse universe);
	
	/**
	 * Returns the Type of this object as specified by the SimpleObjectType enum.
	 * @return
	 */
	public GameObjectType getType();

}