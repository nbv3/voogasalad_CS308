package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ObjectEditorNav{
	
	private IChangeObjectEditorScene changeInterface;
	
	public ObjectEditorNav(IChangeObjectEditorScene ichange){
		changeInterface = ichange;
	}
	
	public Node createNavBar(){
		HBox navBar = new HBox();
		navBar.setPadding(new Insets(50,50,50,50));
		navBar.setSpacing(400);
		
		Button backButton = new Button(ResourceManager.getString("BackToTypeScene"));
		backButton.setOnAction(e -> changeInterface.resetToTypeScene());
		
		Button createButton = new Button("Create");
		
		navBar.getChildren().addAll(backButton,createButton);
		return navBar;
	}
	
}
