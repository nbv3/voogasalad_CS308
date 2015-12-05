package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;

public interface IEditableParameter<T> {

	public void setInputNode();
	
	public void setLabel(String label);
	
	public Node getInputNode();
	
	public T getInputValue();
}
