package com.syntacticsugar.vooga.gameplayer.attribute.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;

public class MoveUpCardinal implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		double speed = mover.getSpeed();
		mover.setVelocity(0, -1.0*speed);
	}

}
