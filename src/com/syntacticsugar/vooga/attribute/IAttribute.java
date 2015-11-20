package com.syntacticsugar.vooga.attribute;

import com.syntacticsugar.vooga.event.IGameEvent;
import com.syntacticsugar.vooga.objects.IGameObject;
import com.syntacticsugar.vooga.universe.IGameUniverse;

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
