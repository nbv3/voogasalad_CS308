package simple.attribute;

import java.util.Collection;
import java.util.Map;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import simple.attribute.movement.ISimpleMover;
import simple.event.ISimpleEvent;
import simple.obj.ISimpleBoundingBox;
import simple.obj.ISimpleObject;
import simple.universe.ISimpleUniverse;

public class SimpleControlAttribute extends SimpleAbstractAttribute implements ISimpleMover {

	private double xVelocity;
	private double yVelocity;
	private double mySpeed;
	private Collection<KeyCode> myCurrentInput;
//	private Map<KeyCode, ISimpleMovement> myKeyBindings;
	
	public SimpleControlAttribute(ISimpleObject parent) {
		super(parent);
		setVelocity(0, 0);
		setSpeed(3);
	}
	
	@Override
	public void receiveEvent(ISimpleEvent event) {
		// TODO could be speed changes, make immobile for n seconds, etc.
	}

	@Override
	public void updateSelf(ISimpleUniverse universe) {
		move();
	}
	
	@Override
	public void move() {

	}

	@Override
	public void setSpeed(double speed) {
		this.mySpeed = speed;
	}
	
	@Override
	public void setVelocity(double xVel, double yVel) {
		setXVelocity(xVel);
		setYVelocity(yVel);
	}

	private void setXVelocity(double xvel) {
		this.xVelocity = xvel;
	}
	
	private void setYVelocity(double yvel) {
		this.yVelocity = yvel;
	}

}
