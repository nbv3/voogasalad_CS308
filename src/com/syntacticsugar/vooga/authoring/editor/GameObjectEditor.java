package com.syntacticsugar.vooga.authoring.editor;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectEditor;
import com.syntacticsugar.vooga.util.gui.factory.ButtonFactory;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GameObjectEditor extends BorderPane{

	public GameObjectEditor() {
		String title = "Create GameObject";
		Button btn = new ButtonFactory().createObject(title, 200, 30);
		btn.setOnMouseClicked(e -> {
			new ObjectEditor();
		});
		this.setCenter(btn);
	}
	
	public Node getPane() {
		return this;
	}

}
