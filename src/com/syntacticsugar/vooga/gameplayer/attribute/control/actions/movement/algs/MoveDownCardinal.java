package com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;

public class MoveDownCardinal extends AbstractMovementType {

	@Override
	public void setMovement(IMover mover) {
		mover.setYVelocity(VDirection.DOWN);
		mover.setXVelocity(HDirection.STOP);
		mover.setDirection(Direction.DOWN);
		mover.setRotate(90);
	}

}
