package com.syntacticsugar.vooga.gameplayer.attribute.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.VDirection;

public class MoveUpCardinal implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		mover.setXVelocity(HDirection.STOP);
		mover.setYVelocity(VDirection.UP);
	}

}
