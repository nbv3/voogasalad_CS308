package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import com.syntacticsugar.vooga.gameplayer.attribute.AbstractAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.HDirection;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.VDirection;

import jdk.nashorn.internal.ir.SetSplitState;

public abstract class AbstractMovementAttribute extends AbstractAttribute implements IMover {
	
	private double xVelocity;
	private double yVelocity;
	private double mySpeed;
	
	public AbstractMovementAttribute(double speed) {
		super();
		resetVelocity();
		setSpeed(speed);
	}
	
	public double getXVelocity() {
		return new Double(xVelocity);
	}

	public double getYVelocity() {
		return new Double(yVelocity);
	}
	
	@Override
	public void resetVelocity() {
		this.xVelocity = 0;
		this.yVelocity = 0;
	}
	
	@Override
	public double getSpeed() {
		return this.mySpeed;
	}

	@Override
	public void setSpeed(double speed) {
		this.mySpeed = speed;
	}

	@Override
	public void setXVelocity(HDirection xDir) {
		this.xVelocity = 
				xDir.equals(HDirection.STOP) ? 
						0 : (xDir.equals(HDirection.RIGHT) ? mySpeed : -1.0*mySpeed);
	}
		
	@Override
	public void setYVelocity(VDirection yDir) {
		this.yVelocity = 
				yDir.equals(VDirection.STOP) ? 
						0 : (yDir.equals(VDirection.DOWN) ? mySpeed : -1.0*mySpeed);
	}
	
	@Override
	public void setRotate(double rotation) {
		this.getParent().getBoundingBox().setRotate(rotation);
	}
	
	@Override
	public void setDirection(Direction dir) {
		this.getParent().getBoundingBox().setDirection(dir);
	}
	
	@Override
	public abstract void move();
	
}
