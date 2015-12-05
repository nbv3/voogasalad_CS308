package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;

public class KeyCodeParameter extends AbstractParameter<KeyCode>{

	private KeyCode myCode;
	public KeyCodeParameter(String label) {
		super(label);
	}

	@Override
	public void setInputNode() {
		
	}
	
	@Override
	public void setValue(KeyCode code)
	{
		myCode = code;
	}

	@Override
	public KeyCode getInputValue() {
		return myCode;
	}

}
