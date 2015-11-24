package com.syntacticsugar.vooga.authoring.objecteditor;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.MultipleSelectionModelBuilder;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableSelectionModel;
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
		myScene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");		
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
		
		HBox attributes = buildAttributes(type);
		
		HBox collisions = buildCollisions(type);
		
		container.getChildren().addAll(images, attributes, collisions);
		
		editorPane.setCenter(container);
	}

	private GridPane buildImages(GameObjectType type) {
		GridPane imagePane = new GridPane();
		imagePane.getStyleClass().add("properties-module");
		imagePane.setPrefSize(250, 250);
		String[] towerIconPath = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "img")).split(",");	
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

	private HBox buildAttributes(GameObjectType type) {
		HBox ret = new HBox();
		ListView<String> attributeView = new ListView<String>();
		String[] attributeNames = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "attributes")).split(",");
		attributeView.getItems().addAll(attributeNames);
		attributeView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ret.getChildren().add(attributeView);
		ret.setSpacing(5);
		ret.setPrefSize(400, 100);
		return ret;
	}
	
	private HBox buildCollisions(GameObjectType type) {
		HBox ret = new HBox();
		ListView<GameObjectType> types = new ListView<GameObjectType>();
		types.getItems().addAll(GameObjectType.values());
		types.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		ListView<String> events = new ListView<String>();
		events.getItems().addAll(ResourceManager.getString("game_events").split(","));
		events.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		Button add = new Button("Add Collisions");
		
		ret.getChildren().addAll(types, events, add);
		ret.setSpacing(5);
		ret.setPrefSize(400, 150);
		return ret;
	}

}
