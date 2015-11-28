package com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;

public class MoveRightCardinal extends AbstractMovementType {

	@Override
	public void setMovement(IMover mover) {
		mover.setXVelocity(HDirection.RIGHT);
		mover.setYVelocity(VDirection.STOP);
		mover.setDirection(Direction.RIGHT);
		mover.setRotate(0);
	}

}
