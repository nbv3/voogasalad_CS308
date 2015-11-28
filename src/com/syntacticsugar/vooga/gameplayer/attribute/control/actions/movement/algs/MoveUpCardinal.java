package com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;

public class MoveUpCardinal extends AbstractMovementType {

	@Override
	public void setMovement(IMover mover) {
		mover.setXVelocity(HDirection.STOP);
		mover.setYVelocity(VDirection.UP);
		mover.setDirection(Direction.UP);
		mover.setRotate(270);
	}

}
