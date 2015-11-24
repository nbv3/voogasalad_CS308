package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ObjectEditor implements IChangeObjectEditorScene {
	private Stage myStage;
	private Scene typeScene;
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
		myStage.show();
	}

	@Override
	public void initSelectionScene(GameObjectType type) {
		typeChosen = type;
		SelectionEditor selectionEditor = new SelectionEditor(iChange, type);
		selectionScene = selectionEditor.createScene();
		myStage.setScene(selectionScene);
		return;
		
	}
	
	@Override
	public void resetToTypeScene(){
		myStage.setScene(typeScene);
		return;
	}
}
