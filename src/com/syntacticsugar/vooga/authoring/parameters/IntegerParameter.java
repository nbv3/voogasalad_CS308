package com.syntacticsugar.vooga.authoring.parameters;

public class IntegerParameter extends AbstractParameter<Integer>{

	private Integer myValue;
	public IntegerParameter(Integer value, String label) {
		super(value, label);
		myValue = value;
		
	}

	@Override
	public void setInputNode() {
		
		
	}

	@Override
	public Integer getInputValue() {
		return myValue;
	}
	
	

}
