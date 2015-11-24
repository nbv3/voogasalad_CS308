package com.syntacticsugar.vooga.authoring.objecteditor;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ObjectEditor {

	private Stage myStage;
	private Scene myScene;
	private List<Scene> myScenes;
	private ComboBox<GameObjectType> myTypeChooser;
	private BorderPane editorPane;
	
	private ObjectData myData;

	public ObjectEditor() {
		myData = new ObjectData();
		
		myTypeChooser = buildTypeSelector();

		editorPane = new BorderPane();
		editorPane.setCenter(myTypeChooser);
		
		myScene = new Scene(editorPane, 400, 400);
		myStage = new Stage();
		myStage.setScene(myScene);
		myStage.show();

	}

	private HBox buildNavButtons() {
		HBox nav = new HBox();
		nav.setPrefSize(400, 30);
		Button back = new Button("Back");
		return null;
	}
	
	private ComboBox<GameObjectType> buildTypeSelector() {
		ComboBox<GameObjectType> typeChooser = new ComboBox<GameObjectType>();
		typeChooser.setPromptText(ResourceManager.getString("ChooseObjectType"));
		typeChooser.getItems().addAll(GameObjectType.values());
		typeChooser.setOnAction(e -> selectObjectInfo(typeChooser.getSelectionModel().getSelectedItem()));
		return typeChooser;
	}

	private void selectObjectInfo(GameObjectType type) {
		VBox container = new VBox();
		
		HBox images = new HBox();
		images.getChildren().add(buildImages(type));
		
		HBox attributes = new HBox();
		
		container.getChildren().add(images);
		
		editorPane.setCenter(container);
	}

	private GridPane buildImages(GameObjectType type) {
		GridPane imagePane = new GridPane();
		imagePane.getStyleClass().add("properties-module");
		imagePane.setPrefSize(400, 400);
		String[] towerIconPath = ResourceManager.getString(type.toString().toLowerCase()).split(",");	
		for (int i = 0; i < towerIconPath.length; i++) {
			System.out.println(towerIconPath[i]);
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(towerIconPath[i])));

			img.setOnMouseClicked(e -> img.requestFocus());

			img.focusedProperty().addListener((o,oldValue,newValue) -> {
				if (newValue) {
					img.setEffect(new Glow(0.7));
				}
				else {
					img.setEffect(null);
				}});

			img.setFitWidth(imagePane.getPrefWidth() / 5);
			img.setFitHeight(imagePane.getPrefHeight() / 5);
			imagePane.add(img, i % 5, i / 5, 1, 1);
		}
		return imagePane;
	}


}
