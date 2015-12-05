package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class DoubleParameter extends AbstractParameter<Double> {
	
	private Double myValue;
	
	public DoubleParameter(Double value, String label)
	{
		//System.out.println("NEW DOUBLE PARAM CREATED");
		super(value, label);
		myValue = value;
		setInputNode();
	}
	
	@Override
	public void setInputNode() {
		HBox containerBox = new HBox();
		TextField myTextField = new TextField();
		myTextField.setOnKeyPressed(e->updateParameters(e.getCode(), myTextField.getText()));
		Label nodeLabel = getLabel();
		containerBox.getChildren().addAll(nodeLabel, myTextField);
		setNode(containerBox);
	}
	
	private void updateParameters(KeyCode code, String userInput)
	{
		if(!userInput.equals(null))
		{
			if(code.equals(KeyCode.ENTER))
			{
				if(!userInput.equals(""))
				{
					//setValue(Double.parseDouble(userInput));
					setChanged();
					notifyObservers(Double.parseDouble(userInput));
				}
				
			}
		}

	}

	@Override
	public Double getInputValue() {
		return myValue;
	}
	
	


	


	
	

}
