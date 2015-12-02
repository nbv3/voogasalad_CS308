package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ObjectEditorNav{
	
	private SelectionEditor selectionEditor;
	private IChangeObjectEditorScene changeInterface;
	
	public ObjectEditorNav(SelectionEditor se, IChangeObjectEditorScene ichange) {
		selectionEditor = se;
		changeInterface = ichange;
	}
	
	public Node createNavBar(){
		HBox navBar = new HBox();
		navBar.setPadding(new Insets(50,50,50,50));
		navBar.setSpacing(400);
		navBar.getChildren().addAll(createBackBtn(),createCreateBtn());
		return navBar;
	}
	
	private Button createBackBtn() {
		Button backButton = new Button(ResourceManager.getString("BackToTypeScene"));
		backButton.setOnAction(e -> changeInterface.resetToTypeScene());
		return backButton;
	}

	private Button createCreateBtn() {
		Button createButton = new Button("Create Object");
		createButton.setOnAction(e -> selectionEditor.createGameObject());
		return createButton;
	}
	
}
