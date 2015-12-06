package com.syntacticsugar.vooga.authoring.parameters;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.util.Pair;

public class KeyCodeParameter extends AbstractParameter<KeyCode>{

	private KeyCode myCode;
	public KeyCodeParameter(String label) {
		super(label);
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
