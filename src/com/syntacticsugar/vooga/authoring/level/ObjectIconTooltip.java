package com.syntacticsugar.vooga.authoring.level;


import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class ObjectIconTooltip extends CustomTooltip {

	private final ObjectData myObjectData;
	private Label myLabel;
	
	public ObjectIconTooltip(ObjectData data) {
		super();
		myObjectData = data;
	}
	
	@Override
	protected Node buildContentNode() {
		myLabel = new Label();
		myLabel.setFont(new Font(7));
		return myLabel;
				
	}

	@Override
	protected void updateContent() {
		myLabel.setText(myObjectData.getObjectName());
	}
	
	
	
}
