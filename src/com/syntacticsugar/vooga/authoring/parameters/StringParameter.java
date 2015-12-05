package com.syntacticsugar.vooga.authoring.parameters;

public class StringParameter extends AbstractParameter<String>{

	private String myValue;
	public StringParameter(String value, String label)
	{
		super(value, label);
		myValue = value;
	}

	@Override
	public void setInputNode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInputValue() {
		return myValue;
	}
}
