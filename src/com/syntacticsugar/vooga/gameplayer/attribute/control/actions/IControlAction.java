package com.syntacticsugar.vooga.gameplayer.attribute.control.actions;

import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public interface IControlAction {

	/**
	 * Method to execute this attribute control action. Usually 
	 * called as a result of registered key input in the update step.
	 */
	public void executeAction(IGameUniverse universe);
	
}
