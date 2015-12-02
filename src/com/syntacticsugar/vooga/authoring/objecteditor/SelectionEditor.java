package com.syntacticsugar.vooga.authoring.objecteditor;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class SelectionEditor {
	private Scene scene;
	private ComboBox<String> attributeComboBox;
	private IChangeObjectEditorScene iChange;
	private GameObjectType typeChosen;
	//private ObjectData myData;
	private List<IAttribute> myAttributes;
	private String selectedItem;
	private final double XDIM = Double.parseDouble(ResourceManager.getString("selection_editor_x"));
	private final double YDIM = Double.parseDouble(ResourceManager.getString("selection_editor_y"));
	private static final double DEFAULT_ICON_SIZE = 50;
	private ObjectProperty<ImageView> selectImg = new SimpleObjectProperty<ImageView>();
	
	public SelectionEditor(IChangeObjectEditorScene change, GameObjectType type, ObjectData myData) {
		iChange = change;
		typeChosen = type;
		myAttributes = new ArrayList<IAttribute>();
		//this.myData = myData;
	}

	public Scene createScene() {
		BorderPane selectionBorderPane = new BorderPane();
		selectionBorderPane.getStyleClass().add("pane");
		selectionBorderPane.setTop(selectObjectInfo(typeChosen));
		ObjectEditorNav navBar = new ObjectEditorNav(iChange);
		selectionBorderPane.setBottom(navBar.createNavBar());
		scene = new Scene(selectionBorderPane, XDIM, YDIM);
		scene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		return scene;
	}

	private VBox selectObjectInfo(GameObjectType type) {
		VBox container = new VBox();
		container.getChildren().addAll(buildImagesPane(type),buildAttributes(type),buildCollisions(type),buildCreatedView(type));
		return container;
	}

	private Node buildCreatedView(GameObjectType type) {
		attributeComboBox = new ComboBox<String>();
		attributeComboBox.setPromptText("Click to view created attributes");
		attributeComboBox.setOnMouseClicked(e -> {
			if (e.getClickCount() == 1) {
				displayAttributeParam();
			}
			if (e.getClickCount() == 2) {
				removeAttributeFromList();
			}
		});
		return attributeComboBox;
	}

	private void displayAttributeParam() {
		// need to consider what to display here
	}

	private void removeAttributeFromList() {
		if (!myAttributes.isEmpty()) {
			int selectedIdx = attributeComboBox.getSelectionModel().getSelectedIndex();
			myAttributes.remove(selectedIdx);
			attributeComboBox.getItems().remove(selectedIdx);
		}
		else {
			new AlertBoxFactory().createObject("Attribute list empty, nothing to remove");
		}
		System.out.println(myAttributes.size());
	}

	private Node buildImagesPane(GameObjectType type) {
		TilePane imagePane = new TilePane();
		imagePane.getStyleClass().addAll("properties-module");
		String[] iconPath = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "img"))
				.split(",");
		
		selectImg.addListener((o,s1,s2) -> {
			setGlowEffectsOnSelectedImg(s1, s2);
			});
		
		for (int i = 0; i < iconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i])));
			img.setOnMouseClicked(e -> 	selectImg.setValue(img));
			final String iconPathName = iconPath[i];
			img.setOnDragDetected((MouseEvent e) -> createDragClipBoards(img, iconPathName, e));
			selectImg.addListener((o,s1,s2) -> setGlowEffectsOnSelectedImg(s1, s2));
			img.setFitWidth(DEFAULT_ICON_SIZE);
			img.setFitHeight(DEFAULT_ICON_SIZE);
			imagePane.getChildren().add(img);
		}
		return imagePane;
	}

	private void setGlowEffectsOnSelectedImg(ImageView s1, ImageView s2) {
		if (s1 == null) {
			s2.setEffect(new Glow(0.7));
			return;
		}
		s1.setEffect(null);
		s2.setEffect(new Glow(0.7));
	}
	private void createDragClipBoards(ImageView img, final String iconPathName, MouseEvent event) {
		Dragboard db = img.startDragAndDrop(TransferMode.ANY);
		ClipboardContent content = new ClipboardContent();
		content.putString(iconPathName);
		db.setContent(content);
		event.consume();
	}
	private HBox buildAttributes(GameObjectType type) {
		HBox ret = new HBox();
		ListView<String> attributeView = new ListView<String>();
		String[] attributeNames = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "attributes")).split(",");
		attributeView.getItems().addAll(attributeNames);
		attributeView.setOnMouseClicked(e -> {
			getSelectedItem(attributeView);
		});
		
		Button addAttribute = new Button("Add Attribute");
		addAttribute.setOnMouseClicked(e -> {
        	createAttribute();
        });
		
		ret.getChildren().addAll(attributeView, addAttribute);
		ret.setSpacing(5);
		ret.setPrefSize(400, 100);
		return ret;
	}

	private void getSelectedItem(ListView<String> attributeView) {
		selectedItem =  attributeView.getSelectionModel().getSelectedItem();
	}

	private void createAttribute() {
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(selectedItem));
//		System.out.println(msgBox.getValue());
		if (msgBox.getValue() != 0) {
			String className = ResourceManager.getString(String.format("%s_%s", selectedItem, "name"));
			for (IAttribute i: myAttributes) {
				if (selectedItem.equals(i.getClass().getSimpleName())) {
					new AlertBoxFactory().createObject(String.format("%s has already been added", selectedItem));
					return;
				}
			}
			try {
				myAttributes.add((IAttribute) Reflection.createInstance(className, msgBox.getValue()));
			}
			catch (ReflectionException ex) {
				myAttributes.add((IAttribute) Reflection.createInstance(className));
			}
        	attributeComboBox.getItems().add(selectedItem);
		}
		for (IAttribute i: myAttributes) {
			System.out.println(i.getClass().getSimpleName());
		}
	}

	private HBox buildCollisions(GameObjectType type) {
		HBox ret = new HBox();
		ListView<GameObjectType> types = new ListView<GameObjectType>();
		types.getItems().addAll(GameObjectType.values());
		types.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		ListView<String> events = new ListView<String>();
		events.getItems().addAll(ResourceManager.getString("game_events").split(","));
		events.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		Button addCollision = new Button("Add Collision");

		ret.getChildren().addAll(types, events, addCollision);
		ret.setSpacing(5);
		ret.setPrefSize(400, 150);
		return ret;
	}
	
}
