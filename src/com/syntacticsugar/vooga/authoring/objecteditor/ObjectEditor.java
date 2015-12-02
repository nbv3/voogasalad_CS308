package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.scene.Scene;
import javafx.stage.Stage;
import xml.data.ObjectData;

public class ObjectEditor implements IChangeObjectEditorScene {
	
	private Stage myStage;
	public Scene typeScene;
	private Scene selectionScene;
	private ObjectData myData;
	private IChangeObjectEditorScene iChange;
	private GameObjectType typeChosen;
	
	public ObjectEditor() {
		iChange = this;
		TypeEditor typeEditor = new TypeEditor(iChange);
		typeScene = typeEditor.createScene();
		myData = new ObjectData();
		myStage = new Stage();
		myStage.setScene(typeScene);
		myStage.setTitle("Object Editor");
		myStage.show();
	}

	@Override
	public void initSelectionScene(GameObjectType type) {
		typeChosen = type;
		SelectionEditor selectionEditor = new SelectionEditor(iChange, typeChosen, myData);
		selectionScene = selectionEditor.createScene();
		myStage.setScene(selectionScene);
		return;
	}
	
	@Override
	public void resetToTypeScene(){
		myStage.setScene(new TypeEditor(iChange).createScene());
		return;
	}
	
}
