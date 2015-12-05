package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.util.Collection;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.parameters.DoubleParameter;
import com.syntacticsugar.vooga.authoring.parameters.IEditableParameter;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;

import javafx.geometry.Point2D;

public class ConstantMovementAttribute extends AbstractMovementAttribute {

	Direction myDir;
	
	public ConstantMovementAttribute(Direction dir, Double speed) {
		super(new DoubleParameter("Speed: "));
		myDir = dir;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		setDirection(myDir);
		setVelocity(myDir);
		move(universe);
	}
	
	@Override
	public void move(IGameUniverse universe) {
		IBoundingBox box = getParent().getBoundingBox();
		Point2D oldPoint = box.getPoint();
		box.setPoint(new Point2D(oldPoint.getX() + getXVelocity(), oldPoint.getY() + getYVelocity()));
	}


	
	
}
