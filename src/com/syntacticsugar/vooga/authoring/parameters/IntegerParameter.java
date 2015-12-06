package com.syntacticsugar.vooga.authoring.parameters;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

public class IntegerParameter extends AbstractParameter<Integer>{

	private Integer myValue;
	
	public IntegerParameter(String label) {
		super(label);
		
	}

	@Override
	public Integer getInputValue() {
		return myValue;
	}

	
	

}
