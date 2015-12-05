package com.syntacticsugar.vooga.authoring.parameters;

public class StringParameter extends AbstractParameter<String>{

	private String myValue;
	public StringParameter(String label)
	{
		super(label);
	}

	@Override
	public void setInputNode() {
		// TODO Auto-generated method stub
		
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
