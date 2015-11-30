package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.AbstractMovementType;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

import javafx.geometry.Point2D;

public class ConstantMovementAttribute extends AbstractMovementAttribute {

	private AbstractMovementType myMovement;
	
	public ConstantMovementAttribute(AbstractMovementType movementType, double speed) {
		super(speed);
		this.myMovement = movementType;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		myMovement.setMovement(this);
		move();		
	}

	@Override
	public void move() {
		IBoundingBox box = getParent().getBoundingBox();
		Point2D oldPoint = box.getPoint();
		box.setPoint(new Point2D(oldPoint.getX() + getXVelocity(), oldPoint.getY() + getYVelocity()));
	}
	
}
