package com.syntacticsugar.vooga.authoring.objecteditor;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class SelectionEditor {
	private Scene scene;
	private IChangeObjectEditorScene iChange;
	private GameObjectType typeChosen;
	private final double XDIM = Double.parseDouble(ResourceManager.getString("selection_editor_x"));
	private final double YDIM = Double.parseDouble(ResourceManager.getString("selection_editor_y"));
	private final double DEFAULT_ICON_SIZE = 50;
	private ObjectProperty<ImageView> selectImg = new SimpleObjectProperty<ImageView>();
	
	public SelectionEditor(IChangeObjectEditorScene change, GameObjectType type) {
		iChange = change;
		typeChosen = type;
	}

	public Scene createScene() {
		BorderPane selectionBorderPane = new BorderPane();
		selectionBorderPane.getStyleClass().add("pane");
		ObjectEditorNav navBar = new ObjectEditorNav(iChange);
		selectionBorderPane.setTop(selectObjectInfo(typeChosen));
		selectionBorderPane.setBottom(navBar.createNavBar());
		scene = new Scene(selectionBorderPane, XDIM, YDIM);
		scene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		return scene;
	}

	private VBox selectObjectInfo(GameObjectType type) {
		VBox container = new VBox();
		container.getChildren().addAll(buildImagesPane(type),buildAttributes(type),buildCollisions(type));
		return container;
	}

	private Node buildImagesPane(GameObjectType type) {
		TilePane imagePane = new TilePane();
		imagePane.getStyleClass().addAll("properties-module");
		String[] iconPath = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "img"))
				.split(",");
		for (int i = 0; i < iconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i])));
			img.setOnMouseClicked(e -> {
				selectImg.setValue(img);});
			
			selectImg.addListener((o,s1,s2) -> {
				if (s1 == null) {
					s2.setEffect(new Glow(0.7));
					return;
				}
				s1.setEffect(null);
				s2.setEffect(new Glow(0.7));
				});
			
			img.setFitWidth(DEFAULT_ICON_SIZE);
			img.setFitHeight(DEFAULT_ICON_SIZE);
			imagePane.getChildren().add(img);
		}
		return imagePane;
	}

	private HBox buildAttributes(GameObjectType type) {
		HBox ret = new HBox();
		ListView<String> attributeView = new ListView<String>();
		String[] attributeNames = ResourceManager
				.getString(String.format("%s_%s", type.name().toLowerCase(), "attributes")).split(",");
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
