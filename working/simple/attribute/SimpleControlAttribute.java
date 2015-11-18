package simple.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import simple.attribute.movement.ISimpleMover;
import simple.attribute.movement.algs.IMovementSetter;
import simple.event.ISimpleEvent;
import simple.obj.ISimpleBoundingBox;
import simple.obj.ISimpleObject;
import simple.obj.SimpleBoundingBox;
import simple.universe.ISimpleUniverse;
import simple.universe.userinput.IKeyInputStorage;

public class SimpleControlAttribute extends SimpleAbstractAttribute implements ISimpleMover {

	private double xVelocity;
	private double yVelocity;
	private double mySpeed;
	
	private Map<KeyCode, IMovementSetter> myKeyBindings;
	private Collection<IMovementSetter> myCurrentMovement;
	
	public SimpleControlAttribute(ISimpleObject parent) {
		super(parent);
		myKeyBindings = new HashMap<KeyCode, IMovementSetter>();
		myCurrentMovement = new ArrayList<IMovementSetter>();
		setVelocity(0, 0);
		setSpeed(3);
	}
	
	private void updateKeyInput(IKeyInputStorage universeKeyInput) {
		myCurrentMovement.clear();
		for (KeyCode code : universeKeyInput.getCurrentKeyInput()) {
			if (myKeyBindings.containsKey(code)) {
				myCurrentMovement.add(myKeyBindings.get(code));
			}
		}
	}
	
	private void processKeyInput() {
		for (IMovementSetter movement: myCurrentMovement) {
			movement.setMovement(this);
		}
	}
	
	@Override
	public void receiveEvent(ISimpleEvent event) {
		// TODO could be speed changes, make immobile for n seconds, etc.
	}

	@Override
	public void updateSelf(ISimpleUniverse universe) {
		updateKeyInput(universe);
		processKeyInput();
		move();
	}
	
	@Override
	public void move() {
//		TODO : Make this real
//		SET THE NEW LOCATION OF THE PARENT'S BOUNDING BOX BASED ON CURRENT VELOCITY
//		ISimpleBoundingBox box = getParent().getBoundingBox();
//		Point2D oldPoint = box.getPoint();
//		box.setPoint(new Point2D(oldPoint.getX() + xVelocity, oldPoint.getY() + yVelocity));
		System.out.println(String.format("X Velocity: %d   Y Velocity: %d", xVelocity, yVelocity));
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
