package com.syntacticsugar.vooga.authoring.parameters;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.util.Pair;

public class DoubleParameter extends AbstractParameter<Double> {
	
	private Double myValue;
	
	public DoubleParameter(String label)
	{
		//System.out.println("NEW DOUBLE PARAM CREATED");
		super(label);
	}

	
	@Override
	public void setValue(Double value)
	{
		myValue = value;
	}


	@Override
	public Double getInputValue() {
		return myValue;
	}
	
	


	


	
	

}
