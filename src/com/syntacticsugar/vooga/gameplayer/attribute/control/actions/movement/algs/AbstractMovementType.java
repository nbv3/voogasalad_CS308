package com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.IControlAction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

public abstract class AbstractMovementType implements IControlAction {

	@Override
	public void executeAction(IGameUniverse universe) {
		
	}
	
	/**
	 * Change the current motion (x and y velocity) of a
	 * basic ISimpleMover object (ie. anything that can move). 
	 */
	public abstract void setMovement(IMover mover);
	
}
