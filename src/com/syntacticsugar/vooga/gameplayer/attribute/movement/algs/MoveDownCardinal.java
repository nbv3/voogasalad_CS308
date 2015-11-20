package com.syntacticsugar.vooga.gameplayer.attribute.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;

public class MoveDownCardinal implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		double speed = mover.getSpeed();
		mover.setVelocity(0, speed);
	}

}
