package com.syntacticsugar.vooga.authoring.icon;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.scene.layout.VBox;

public class LabeledIcon extends Icon {
	
	public LabeledIcon(String imagePath, String label) {
		super(imagePath);
		VBox labeledIcon = new VBox();
		labeledIcon.getChildren().add(this);
		labeledIcon.getChildren().add(GUIFactory.buildTitleNode(label));
		this.getChildren().clear();
		this.getChildren().add(labeledIcon);
	}
	
	

	
	
}
