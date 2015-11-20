package com.syntacticsugar.vooga.gameplayer.attribute;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
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
	 * @return
	 */
	public IGameObject getParent();
	
	/**
	 * Receive a generic SimpleEvent. If this event pertains to the 
	 * attribute, then it will execute.
	 * @param event
	 */
	public void receiveEvent(IGameEvent event);
	
}
