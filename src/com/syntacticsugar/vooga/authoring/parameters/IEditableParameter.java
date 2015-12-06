package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;
import javafx.scene.control.Label;

public interface IEditableParameter<T> {
	
	public void setLabel(String label);
	
	public T getInputValue();
	
	public Label getLabel();
}
