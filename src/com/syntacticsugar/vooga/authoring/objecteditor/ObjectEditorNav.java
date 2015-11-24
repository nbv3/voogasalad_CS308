package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ObjectEditorNav{
	private IChangeObjectEditorScene changeInterface;
	public ObjectEditorNav(IChangeObjectEditorScene ichange){
		changeInterface = ichange;
	}
	
	public Node createNavBar(){
		Button backButton = new Button(ResourceManager.getString("BackToTypeScene"));
		backButton.setOnAction(e -> changeInterface.resetToTypeScene());
		HBox navBar = new HBox();
		navBar.getChildren().add(backButton);
		return navBar;
	}
}
