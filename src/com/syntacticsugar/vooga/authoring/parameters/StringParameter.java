package com.syntacticsugar.vooga.authoring.parameters;

import java.util.ArrayList;

import javafx.util.Pair;

public class StringParameter extends AbstractParameter<String>{

	private String myValue;
	public StringParameter(String label)
	{
		super(label);
	}

	
	@Override
	public void setValue(String value)
	{
		myValue = value;
	}

	@Override
	public String getInputValue() {
		return myValue;
	}
}
