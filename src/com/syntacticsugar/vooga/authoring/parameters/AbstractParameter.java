package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Observable;

public abstract class AbstractParameter<T> extends Observable implements IEditableParameter<T> {

	private Label myLabel;
	private T myValue;

	public AbstractParameter(String label)
	{
		setLabel(label);
	}
	
	@Override
	public void setLabel(String label) {
		myLabel = new Label(label);
	}
	
	@Override
	public Label getLabel()
	{
		return myLabel;
	}
	
	public void setValue(T val)
	{
		myValue = val;
	}
	
	public T getValue()
	{
		return myValue;
	}

	
}
