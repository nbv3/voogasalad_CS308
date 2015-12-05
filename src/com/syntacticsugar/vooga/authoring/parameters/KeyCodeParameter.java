package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class KeyCodeParameter extends AbstractParameter<KeyCode>{

	private KeyCode myCode;
	public KeyCodeParameter(KeyCode value, String label) {
		super(value, label);
		myCode = value;
	}

	@Override
	public void setInputNode() {
		
	}

	@Override
	public KeyCode getInputValue() {
		return myCode;
	}

}
