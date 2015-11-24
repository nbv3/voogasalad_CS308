package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class TypeEditor {
	private BorderPane editorPane;
	private Scene scene;
	private IChangeObjectEditorScene changeInterface;
	private final double XDIM = Double.parseDouble(ResourceManager.getString("type_editor_x"));
	private final double YDIM = Double.parseDouble(ResourceManager.getString("type_editor_y"));

	public TypeEditor(IChangeObjectEditorScene ichange){
		changeInterface = ichange;
	}
	
	public Scene createScene(){
		editorPane = new BorderPane();
		editorPane.getStyleClass().add("pane");
		editorPane.setCenter(buildTypeSelector());
		scene = new Scene(editorPane, XDIM, YDIM);
		scene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		return scene;
	}
	
	private ComboBox<GameObjectType> buildTypeSelector() {
		ComboBox<GameObjectType> typeChooser = new ComboBox<GameObjectType>();
		typeChooser.setPromptText(ResourceManager.getString("ChooseObjectType"));
		typeChooser.getItems().addAll(GameObjectType.values());
		typeChooser.setOnAction(e -> changeInterface.initSelectionScene(typeChooser.getSelectionModel().getSelectedItem()));
		return typeChooser;
	}
}
