package com.syntacticsugar.vooga.gameplayer.attribute.movement;

import com.syntacticsugar.vooga.authoring.parameters.EditableClass;
import com.syntacticsugar.vooga.authoring.parameters.EditableField;
import com.syntacticsugar.vooga.authoring.parameters.InputParser;
import com.syntacticsugar.vooga.authoring.parameters.InputTypeException;
import com.syntacticsugar.vooga.gameplayer.attribute.control.IUserControlAttribute;
import com.syntacticsugar.vooga.gameplayer.universe.IGameUniverse;
import com.syntacticsugar.vooga.gameplayer.universe.userinput.IKeyInputStorage;

import javafx.scene.input.KeyCode;

@EditableClass (
		className = "Player Movement Control"
		)
public class MovementControlAttribute extends AbstractMovementAttribute implements IUserControlAttribute {

	private KeyCode upCode;
	private KeyCode downCode;
	private KeyCode leftCode;
	private KeyCode rightCode;

	private Direction myCurrentMovement;

	public MovementControlAttribute() {
		super();
	}

	@Override
	protected void setDefaults() {
		super.setDefaults();
		this.upCode = KeyCode.UP;
		this.downCode = KeyCode.DOWN;
		this.leftCode = KeyCode.LEFT;
		this.rightCode = KeyCode.RIGHT;
		this.myCurrentMovement = Direction.STOP;
	}

	@Override
	public void updateKeyInput(IKeyInputStorage universeKeyInput) {
		for (KeyCode code : universeKeyInput.getCurrentKeyInput()) {
			this.myCurrentMovement = getDirectionFromInput(code);
		}
	}

	@Override
	public void processKeyInput() {
		if (!myCurrentMovement.equals(Direction.STOP)) {
			setDirection(myCurrentMovement);
		}
		myCurrentMovement = Direction.STOP;
	}

	@Override
	public void updateSelf(IGameUniverse universe) {
		updateKeyInput(universe);
		setVelocity(myCurrentMovement);
		processKeyInput();
		move(universe);
		resetVelocity();
	}

	private Direction getDirectionFromInput(KeyCode code) {
		if (code.equals(upCode))
			return Direction.UP;
		else if (code.equals(downCode))
			return Direction.DOWN;
		else if (code.equals(leftCode))
			return Direction.LEFT;
		else if (code.equals(rightCode))
			return Direction.RIGHT;
		return myCurrentMovement;
	}


	/**		  	      EDIT TAGS	     		    **/
	/** *************************************** **/

	@EditableField(
			inputLabel = "KeyCode: Move Up",
			defaultVal = "UP", getClassType = KeyCode.class
			)
	private void editUpCode(String arg) {
		try {
			this.upCode = InputParser.parseAsKeyCode(arg.trim());
		} catch (InputTypeException e) { }
	}

	@EditableField(
			inputLabel = "KeyCode: Move Down",
			defaultVal = "DOWN", getClassType = KeyCode.class
			)
	private void editDownCode(String arg) {
		try {
			this.downCode = InputParser.parseAsKeyCode(arg.trim());
		} catch (InputTypeException e) { }
	}

	@EditableField(
			inputLabel = "KeyCode: Move Left",
			defaultVal = "LEFT", getClassType = KeyCode.class
			)
	private void editLeftCode(String arg) {
		try {
			this.leftCode = InputParser.parseAsKeyCode(arg.trim());
		} catch (InputTypeException e) { }
	}

	@EditableField(
			inputLabel = "KeyCode: Move Right",
			defaultVal = "RIGHT", getClassType = KeyCode.class
			)
	private void editRightCode(String arg) {
		try {
			this.rightCode = InputParser.parseAsKeyCode(arg.trim());
		} catch (InputTypeException e) { }
	}

}
