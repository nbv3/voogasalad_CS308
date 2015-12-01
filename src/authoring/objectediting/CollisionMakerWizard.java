package authoring.objectediting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;
import com.syntacticsugar.vooga.util.reflection.ReflectionException;

public class CollisionMakerWizard {
	
	private Stage myStage;
	private Scene myScene;
	private CollisionViewer myCollisionViewer;
	private GameObjectType typeChosen;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisions;
	private IGameEvent collisionEventToAdd;
	private GameObjectType selectedCollideObjType;
	private String selectedCollisionEvent;
	private final double SCENE_DIMENSION = 400;

	public CollisionMakerWizard(CollisionViewer collisionViewer, GameObjectType type, 
			Map<GameObjectType, Collection<IGameEvent>> collisions) {
		myCollisionViewer = collisionViewer;
		typeChosen = type;
		myCollisions = collisions;
		myStage = new Stage();
		myScene = new Scene(buildCollisions(typeChosen),SCENE_DIMENSION,SCENE_DIMENSION);
		myStage = new Stage();
		myStage.setScene(myScene);
		myStage.setTitle("AttributeMakerWizard");
		myStage.initModality(Modality.APPLICATION_MODAL);
		myStage.showAndWait();
	}

	private VBox buildCollisions(GameObjectType type) {
		VBox ret = new VBox();
		HBox listViewsBox = new HBox();
		listViewsBox.getChildren().addAll(createCollideObjTypeListView(),createCollideEventListView());
		ret.getChildren().addAll(listViewsBox, createAddCollisionBtn());
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
			selectedCollisionEvent =  events.getSelectionModel().getSelectedItem();
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
			AlertBoxFactory.createObject("Please select a GameObjectType first");
			return;
		}
		if (selectedCollisionEvent == null) {
			AlertBoxFactory.createObject("Please select a GameEventType first");
			return;			
		}
		
		if (myCollisions.containsKey(selectedCollideObjType)) {
			//System.out.println(selectedCollideObjEvent.getClass().getSimpleName());
			for (IGameEvent i: myCollisions.get(selectedCollideObjType)) {
				//System.out.println(i.getClass().getSimpleName());
				if (i.getClass().getSimpleName().equals(selectedCollisionEvent)) {
					AlertBoxFactory.createObject(String.format("Cannot add more than one %s to collide type %s", 
							selectedCollisionEvent,selectedCollideObjType));
					return;
				}
			}
			addCollideEventToExistingKey();
		}
		else {
			addCollideEventToNonExistingKey();
		}
		//System.out.println("The size of the keys in the map is " + myData.getCollisionMap().keySet().size());
	}

	private void addCollideEventToExistingKey() {
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(String.format("%s%s", "double_", selectedCollisionEvent)));
		String className = ResourceManager.getString(String.format("%s_%s", selectedCollisionEvent, "name"));
		if (msgBox.getValue() != 0) {
			try {
				collisionEventToAdd = (IGameEvent) Reflection.createInstance(className, msgBox.getValue());
			}
			catch (ReflectionException ex) {
				collisionEventToAdd = (IGameEvent) Reflection.createInstance(className);
			}
			myCollisions.get(selectedCollideObjType).add(collisionEventToAdd);
			myCollisionViewer.addCollisionEventToList(selectedCollideObjType, collisionEventToAdd);
		}
	}

	private void addCollideEventToNonExistingKey() {
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory(ResourceManager.getString(String.format("%s%s", "double_", selectedCollisionEvent)));
		String className = ResourceManager.getString(String.format("%s_%s", selectedCollisionEvent, "name"));
		if (msgBox.getValue() != 0) {
			Collection<IGameEvent> collideEvents  = new ArrayList<IGameEvent>();
			try {
				collideEvents.add((IGameEvent) Reflection.createInstance(className, msgBox.getValue()));
			}
			catch (ReflectionException ex) {
				collideEvents.add((IGameEvent) Reflection.createInstance(className));
	
			}
			myCollisions.put(selectedCollideObjType, collideEvents);
			myCollisionViewer.addCollisionEventToList(selectedCollideObjType, ((List<IGameEvent>) collideEvents).get(0));
		}
	}



}
