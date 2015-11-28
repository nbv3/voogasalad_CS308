package com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;

public class MoveLeftCardinal extends AbstractMovementType {

	public MoveLeftCardinal() {
		super();
	}
	
	@Override
	public void setMovement(IMover mover) {
		mover.setXVelocity(HDirection.LEFT);
		mover.setYVelocity(VDirection.STOP);
		mover.setDirection(Direction.LEFT);
		mover.setRotate(180);
	}

}
