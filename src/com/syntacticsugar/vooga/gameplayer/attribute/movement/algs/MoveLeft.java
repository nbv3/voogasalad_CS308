package com.syntacticsugar.vooga.gameplayer.attribute.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;

public class MoveLeft implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		mover.setXVelocity(HDirection.LEFT);
	}

}
