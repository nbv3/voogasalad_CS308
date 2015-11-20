package com.syntacticsugar.vooga.attribute.movement.algs;

import com.syntacticsugar.vooga.attribute.movement.IMover;

public interface IMovementSetter {

	/**
	 * Change the current motion (x and y velocity) of a
	 * basic ISimpleMover object (ie. anything that can move). 
	 */
	public void setMovement(IMover mover);
	
}
