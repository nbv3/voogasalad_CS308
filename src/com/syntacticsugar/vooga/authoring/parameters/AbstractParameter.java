package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;
import javafx.scene.control.Label;
import java.util.Observable;

public abstract class AbstractParameter<T> extends Observable implements IEditableParameter<T> {

	private Label myLabel;
	private Node myNode;
	private T myValue;
	
	public AbstractParameter(T value, String label)
	{
		setValue(value);
		setLabel(label);
	}
	
	@Override
	public void setLabel(String label) {
		myLabel = new Label(label);
	}
	
	public void setNode(Node n)
	{
		myNode = n;
	}
	
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
	
	public Node getInputNode()
	{
		return myNode;
	}
	
}
