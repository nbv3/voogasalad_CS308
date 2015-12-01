package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.Direction;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class MovementControlAttribute extends AbstractMovementAttribute implements IUserControlAttribute {

	private Map<KeyCode, Direction> myKeyBindings;
	private Direction myCurrentMovement;
	
	public MovementControlAttribute(double speed) {
		super(speed);
		
		myKeyBindings = new HashMap<>();
		myCurrentMovement = Direction.STOP;

		setDefaultKeyBindings();
	}

	public void setDefaultKeyBindings() {
		addKeyBinding(KeyCode.RIGHT, Direction.RIGHT);
		addKeyBinding(KeyCode.LEFT, Direction.LEFT);
		addKeyBinding(KeyCode.DOWN, Direction.DOWN);
		addKeyBinding(KeyCode.UP, Direction.UP);
	}
	

	public void addKeyBinding(KeyCode code, Direction dir) {
		myKeyBindings.put(code, dir);
	}

	public void removeKeyBinding(KeyCode code) {
		myKeyBindings.remove(code);
	}
	
	@Override
	public void updateKeyInput(IKeyInputStorage universeKeyInput) {
		for (KeyCode code : universeKeyInput.getCurrentKeyInput()) {
			if (myKeyBindings.containsKey(code)) {
				myCurrentMovement = myKeyBindings.get(code);
			}
		}
	}
	
	@Override
	public void processKeyInput() {
		setDirection(myCurrentMovement);
		myCurrentMovement = Direction.STOP;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		updateKeyInput(universe);
		processKeyInput();
//		Point2D point = universe.getMap().getMapIndexFromCoordinate(getParent().getBoundingBox().getPoint());
//		checkMapBounds(point, universe.getMap().isWalkable());
//		System.out.println(point);
		move(universe);
		resetVelocity();
	}
	
//	private void checkMapBounds(Point2D mapIndex, boolean[][] isWalkable) {
//		int r = (int) mapIndex.getX();
//		int c = (int) mapIndex.getY();
//		System.out.println(mapIndex);
//		if (!isWalkable[r][c]) {
//			resetVelocity();
//		}
//	}
	
}
