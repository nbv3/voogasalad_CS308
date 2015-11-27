package com.syntacticsugar.vooga.authoring.objecteditor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class SelectionEditor {
	private Scene scene;
	private ComboBox<String> attributeComboBox;
	private ComboBox<String> collideEventsComboBox;
	private IChangeObjectEditorScene iChange;
	private GameObjectType typeChosen;
	//private ObjectData myData;
	private List<IAttribute> myAttributes;
	private Collection<IGameEvent> collideEvents;
	private Map<GameObjectType, Collection<IGameEvent>> collisions;
	private String selectedAttribute;
	private GameObjectType selectedCollideObjType;
	private String selectedCollideObjEvent;
	private final double XDIM = Double.parseDouble(ResourceManager.getString("selection_editor_x"));
	private final double YDIM = Double.parseDouble(ResourceManager.getString("selection_editor_y"));
	private final double DEFAULT_ICON_SIZE = 50;
	private ObjectProperty<ImageView> selectImg = new SimpleObjectProperty<ImageView>();
	
	public SelectionEditor(IChangeObjectEditorScene change, GameObjectType type, ObjectData myData) {
		iChange = change;
		typeChosen = type;
		myAttributes = new ArrayList<IAttribute>();
		collideEvents  = new ArrayList<IGameEvent>();
		collisions  = new HashMap<GameObjectType, Collection<IGameEvent>>();
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
		HBox createdViewBox = new HBox();
		attributeComboBox = createCreatedAttributesComboBox();
		collideEventsComboBox = createCreatedCollideEventComboBox();
		createdViewBox.getChildren().addAll(attributeComboBox,collideEventsComboBox);
		return createdViewBox;
	}

	private ComboBox<String> createCreatedAttributesComboBox() {
		ComboBox<String> attributesComboBox;
		attributesComboBox = new ComboBox<String>();
		attributesComboBox.setPromptText("Click to view created attributes");
		attributesComboBox.setOnMouseClicked(e -> {
			if (e.getClickCount() == 1) {
				displayAttributeParam();
			}
			if (e.getClickCount() == 2) {
				removeAttributeFromList();
			}
		});
		return attributesComboBox;
	}
	
	private void displayAttributeParam() {
		// TODO Auto-generated method stub
		
	}
	
	private void removeAttributeFromList() {
		if (!myAttributes.isEmpty()) {
			int selectedIdx = attributeComboBox.getSelectionModel().getSelectedIndex();
			if (selectedIdx == -1) {
				new AlertBoxFactory().createObject("Please first select an attribute from the list, then double click to remove");
				return;
			}
			removeAttribute(selectedIdx);
		}
		else {
			new AlertBoxFactory().createObject("Attribute list empty, nothing to remove");
		}
		System.out.println(myAttributes.size());
	}

	private void removeAttribute(int selectedIdx) {
		myAttributes.remove(selectedIdx);
		attributeComboBox.getItems().remove(selectedIdx);
	}

	private ComboBox<String> createCreatedCollideEventComboBox() {
		ComboBox<String> collideEventsComboBox;
		collideEventsComboBox = new ComboBox<String>();
		collideEventsComboBox.setPromptText("Click to view created collide events");
		collideEventsComboBox.setOnMouseClicked(e -> {
			if (e.getClickCount() == 1) {
				displayCollideEventParam();
			}
			if (e.getClickCount() == 2) {
				removeCollideEventFromList();
			}
		});
		return collideEventsComboBox;
	}

	private void displayCollideEventParam() {
		// TODO Auto-generated method stub
		
	}
	
	private void removeCollideEventFromList() {
		if (!collisions.keySet().isEmpty()) {
			int selectedIdx = collideEventsComboBox.getSelectionModel().getSelectedIndex();
			if (selectedIdx == -1) {
				new AlertBoxFactory().createObject("Please first select an collide event from the list, then double click to remove");
				return;
			}
			removeCollideEvent(selectedIdx);
		}
		else {
			new AlertBoxFactory().createObject("Collision map empty, nothing to remove");
		}
		System.out.println(collisions.values().size());
		
	}

	private void removeCollideEvent(int selectedIdx) {
		// TODO Auto-generated method stub
		collisions.values().remove(selectedIdx);
		collideEventsComboBox.getItems().remove(selectedIdx);
		
	}

	private Node buildImagesPane(GameObjectType type) {
		TilePane imagePane = new TilePane();
		imagePane.getStyleClass().addAll("properties-module");
		String[] iconPath = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "img"))
				.split(",");
		
		selectImg.addListener((o,s1,s2) -> {
			if (s1 == null) {
				s2.setEffect(new Glow(0.7));
				return;
			}
			s1.setEffect(null);
			s2.setEffect(new Glow(0.7));
			});
		
		for (int i = 0; i < iconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i])));
			img.setOnMouseClicked(e -> {
				selectImg.setValue(img);});
			
			img.setFitWidth(DEFAULT_ICON_SIZE);
			img.setFitHeight(DEFAULT_ICON_SIZE);
			imagePane.getChildren().add(img);
		}
		return imagePane;
	}

	private HBox buildAttributes(GameObjectType type) {
		HBox ret = new HBox();
		ListView<String> attributeView = createAttributeListView(type);
		Button addAttribute = createAddAttributeBtn();
		ret.getChildren().addAll(attributeView, addAttribute);
		ret.setSpacing(5);
		ret.setPrefSize(400, 100);
		return ret;
	}

	private ListView<String> createAttributeListView(GameObjectType type) {
		ListView<String> attributeView = new ListView<String>();
		String[] attributeNames = ResourceManager.getString(String.format("%s_%s", type.name().toLowerCase(), "attributes")).split(",");
		attributeView.getItems().addAll(attributeNames);
		attributeView.setOnMouseClicked(e -> {
			selectedAttribute =  attributeView.getSelectionModel().getSelectedItem();
		});
		return attributeView;
	}

	private Button createAddAttributeBtn() {
		Button addAttribute = new Button("Add Attribute");
		addAttribute.setOnMouseClicked(e -> {
        	createAttribute();
        });
		return addAttribute;
	}

	private void createAttribute() {
		if (selectedAttribute == null) {
			new AlertBoxFactory().createObject("Please select an attribute first");
			return;
		}
		for (IAttribute i: myAttributes) {
			if (selectedAttribute.equals(i.getClass().getSimpleName())) {
				new AlertBoxFactory().createObject(String.format("Cannot add more than one %s", selectedAttribute));
				return;
			}
		}	
		addAttributeToList();
//		for (IAttribute i: myAttributes) {
//			System.out.println(i.getClass().getSimpleName());
//		}
	}

	private void addAttributeToList() {
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(selectedAttribute));
//		System.out.println(msgBox.getValue());
		if (msgBox.getValue() != 0) {
			String className = ResourceManager.getString(String.format("%s_%s", selectedAttribute, "name"));
			try {
				myAttributes.add((IAttribute) Reflection.createInstance(className, msgBox.getValue()));
			}
			catch (ReflectionException ex) {
				myAttributes.add((IAttribute) Reflection.createInstance(className));
			}
        	attributeComboBox.getItems().add(selectedAttribute);
		}
	}

	private HBox buildCollisions(GameObjectType type) {
		HBox ret = new HBox();
		ListView<GameObjectType> types = createCollideObjTypeListView();
		ListView<String> events = createCollideEventListView();
		Button addCollision = createAddCollisionBtn();
		ret.getChildren().addAll(types, events, addCollision);
		ret.setSpacing(5);
		ret.setPrefSize(400, 150);
		return ret;
	}

	private ListView<GameObjectType> createCollideObjTypeListView() {
		ListView<GameObjectType> types = new ListView<GameObjectType>();
		types.getItems().addAll(GameObjectType.values());
		types.setOnMouseClicked(e -> {
			selectedCollideObjType =  types.getSelectionModel().getSelectedItem();
		});
		return types;
	}

	private ListView<String> createCollideEventListView() {
		ListView<String> events = new ListView<String>();
		events.getItems().addAll(ResourceManager.getString("game_events").split(","));
		events.setOnMouseClicked(e -> {
			selectedCollideObjEvent =  events.getSelectionModel().getSelectedItem();
		});
		return events;
	}

	private Button createAddCollisionBtn() {
		Button addCollision = new Button("Add Collision");
		addCollision.setOnMouseClicked(e -> {
        	createCollision();
        });
		return addCollision;
	}

	private void createCollision() {
		if (selectedCollideObjType == null) {
			new AlertBoxFactory().createObject("Please select a GameObjectType first");
			return;
		}
		if (selectedCollideObjEvent == null) {
			new AlertBoxFactory().createObject("Please select a GameEventType first");
			return;			
		}
		
		if (collisions.containsKey(selectedCollideObjType)) {
			//System.out.println(selectedCollideObjEvent.getClass().getSimpleName());
			for (IGameEvent i: collisions.get(selectedCollideObjType)) {
				System.out.println(i.getClass().getSimpleName());
				if (i.getClass().getSimpleName().equals(selectedCollideObjEvent)) {
					new AlertBoxFactory().createObject(String.format("Cannot add more than one %s to collide type %s", 
							selectedCollideObjEvent,selectedCollideObjType));
					return;
				}
			}
			addCollideEventToExistingKey();
		}
		else {
			addCollideEventToNonExistingKey();
		}
		collideEventsComboBox.getItems().add(String.format("%s->%s", selectedCollideObjType,selectedCollideObjEvent));
		//System.out.println("The size of the keys in the map is " + collisions.keySet().size());
	}

	private void addCollideEventToExistingKey() {
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(selectedCollideObjEvent));
		String className = ResourceManager.getString(String.format("%s_%s", selectedCollideObjEvent, "name"));
		try {
			collisions.get(selectedCollideObjType).add((IGameEvent) Reflection.createInstance(className, msgBox.getValue()));
		}
		catch (ReflectionException ex) {
			collisions.get(selectedCollideObjType).add((IGameEvent) Reflection.createInstance(className));
		}
	}

	private void addCollideEventToNonExistingKey() {
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(selectedCollideObjEvent));
		String className = ResourceManager.getString(String.format("%s_%s", selectedCollideObjEvent, "name"));
		try {
			collideEvents.add((IGameEvent) Reflection.createInstance(className, msgBox.getValue()));
		}
		catch (ReflectionException ex) {
			collideEvents.add((IGameEvent) Reflection.createInstance(className));

		}
		collideEvents.add((IGameEvent) Reflection.createInstance(className, msgBox.getValue()));
		collisions.put(selectedCollideObjType, collideEvents);
	}
	
}
