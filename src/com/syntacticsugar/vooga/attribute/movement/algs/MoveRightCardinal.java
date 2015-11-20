package com.syntacticsugar.vooga.attribute.movement.algs;

import com.syntacticsugar.vooga.attribute.movement.IMover;

public class MoveRightCardinal implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		double speed = mover.getSpeed();
		mover.setVelocity(speed, 0);
	}

}