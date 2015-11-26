package com.syntacticsugar.vooga.gameplayer.attribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.movement.IMover;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.algs.*;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class KeyControlAttribute extends AbstractMotionAttribute implements IMover {

	private Map<KeyCode, IMovementSetter> myKeyBindings;
	private Collection<IMovementSetter> myCurrentMovement;
	
	public KeyControlAttribute() {
		super();
		
		myKeyBindings = new HashMap<KeyCode, IMovementSetter>();
		myCurrentMovement = new ArrayList<IMovementSetter>();

		setDefaultKeyBindings();
	}

	private void setDefaultKeyBindings() {
		myKeyBindings.put(KeyCode.RIGHT, new MoveRightCardinal());
		myKeyBindings.put(KeyCode.LEFT, new MoveLeftCardinal());
		myKeyBindings.put(KeyCode.DOWN, new MoveDownCardinal());
		myKeyBindings.put(KeyCode.UP, new MoveUpCardinal());
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
	public void updateSelf(IGameUniverse universe) {
		updateKeyInput(universe);
		processKeyInput();
		move();
		resetVelocity();
	}
	
	@Override
	public void move() {
		//TODO : Make this real
	//	SET THE NEW LOCATION OF THE PARENT'S BOUNDING BOX BASED ON CURRENT VELOCITY
		IBoundingBox box = getParent().getBoundingBox();
		Point2D oldPoint = box.getPoint();
		box.setPoint(new Point2D(oldPoint.getX() + getXVelocity(), oldPoint.getY() + getYVelocity()));
		System.out.println(String.format("X Velocity: %f    Y Velocity: %f", getXVelocity(), getYVelocity()));
	}
	
}
