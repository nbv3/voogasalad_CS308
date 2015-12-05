package com.syntacticsugar.vooga.authoring.parameters;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;

public class IntegerParameter extends AbstractParameter<Integer>{

	private Integer myValue;
	
	public IntegerParameter(String label) {
		super(label);
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
	
	@Override
	public void setValue(Integer value)
	{
		myValue = value;
	}
	
	private void updateParameters(KeyCode code, String userInput)
	{
		if(!userInput.equals(null))
		{
			if(code.equals(KeyCode.ENTER))
			{
				if(!userInput.equals(""))
				{
					setValue(Integer.parseInt(userInput));
					setChanged();
					notifyObservers(Integer.parseInt(userInput));
				}
				
			}
		}

	}

	@Override
	public Integer getInputValue() {
		return myValue;
	}
	
	

}
