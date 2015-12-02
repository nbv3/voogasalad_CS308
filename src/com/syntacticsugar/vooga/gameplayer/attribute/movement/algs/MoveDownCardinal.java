package com.syntacticsugar.vooga.gameplayer.attribute.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.VDirection;

public class MoveDownCardinal implements IMovementSetter {

	@Override
	public void setMovement(IMover mover) {
		mover.setYVelocity(VDirection.DOWN);
		mover.setXVelocity(HDirection.STOP);
	}

}
