package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.IControlAction;
import com.syntacticsugar.vooga.gameplayer.attribute.control.actions.movement.algs.*;
import com.syntacticsugar.vooga.gameplayer.objects.IBoundingBox;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class MovementControlAttribute extends AbstractMovementAttribute implements IUserControlAttribute {

	private Map<KeyCode, AbstractMovementType> myKeyBindings;
	private Collection<AbstractMovementType> myCurrentMovement;
	
	public MovementControlAttribute(double speed) {
		super(speed);
		
		myKeyBindings = new HashMap<KeyCode, AbstractMovementType>();
		myCurrentMovement = new ArrayList<AbstractMovementType>();

		setDefaultKeyBindings();
	}

	public void setDefaultKeyBindings() {
		addKeyBinding(KeyCode.RIGHT, new MoveRightCardinal());
		addKeyBinding(KeyCode.LEFT, new MoveLeftCardinal());
		addKeyBinding(KeyCode.DOWN, new MoveDownCardinal());
		addKeyBinding(KeyCode.UP, new MoveUpCardinal());
	}
	

	public void addKeyBinding(KeyCode code, IControlAction action) {
		myKeyBindings.put(code, (AbstractMovementType) action);
	}

	public void removeKeyBinding(KeyCode code) {
		myKeyBindings.remove(code);
	}
	
	@Override
	public void updateKeyInput(IKeyInputStorage universeKeyInput) {
		myCurrentMovement.clear();
		for (KeyCode code : universeKeyInput.getCurrentKeyInput()) {
			if (myKeyBindings.containsKey(code)) {
				myCurrentMovement.add(myKeyBindings.get(code));
			}
		}
	}
	
	@Override
	public void processKeyInput() {
		for (AbstractMovementType movement: myCurrentMovement) {
			movement.setMovement(this);
		}
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
	
	private void checkMapBounds(Point2D mapIndex, boolean[][] isWalkable) {
		int r = (int) mapIndex.getX();
		int c = (int) mapIndex.getY();
		System.out.println(mapIndex);
		if (!isWalkable[r][c]) {
			resetVelocity();
		}
	}
	
}
