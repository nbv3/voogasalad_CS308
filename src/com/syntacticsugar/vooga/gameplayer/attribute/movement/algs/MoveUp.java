package com.syntacticsugar.vooga.gameplayer.attribute.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.VDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;

public class MoveUp implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		mover.setYVelocity(VDirection.UP);
	}

}
