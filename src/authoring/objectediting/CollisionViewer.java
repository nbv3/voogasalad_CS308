package authoring.objectediting;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

<<<<<<< HEAD
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
=======
import authoring.data.ObjectData;

import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
>>>>>>> feature/towers
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CollisionViewer extends EditingViewer {
	
	private GameObjectType typeChosen;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisions;
	//private ObjectData myData;

	public CollisionViewer(GameObjectType type, Map<GameObjectType, Collection<IGameEvent>> collisions) {
		super(ResourceManager.getString("collision_menu_title"));
		typeChosen = type;
		myCollisions = collisions;
		myAddButton.setOnAction(e -> {
			new CollisionMakerWizard(this,typeChosen,collisions);
		});
		myRemoveButton.setOnAction(e -> removeCollisionEventFromList());
	}
	
	@SuppressWarnings("unchecked")
	public void addCollisionEventToList(GameObjectType objectType, ICollisionEvent gameEvent) {
		if (myListView.getItems().isEmpty()) {
			addElementToList(makeListElement(objectType, gameEvent));
		}
		else {
			for (HBox h: myListView.getItems()) {
//				System.out.println(((Text) (h.getChildren().get(0))).getText());
				if (((Text) (h.getChildren().get(0))).getText().equals(ResourceManager.getString(objectType.toString()))) {
					//System.out.println("equal enter");
					((ComboBox<String>) (h.getChildren().get(1))).getItems().add(gameEvent.getClass().getSimpleName());
					break;
				}
			}
			addElementToList(makeListElement(objectType, gameEvent));
		}
		
		System.out.println("*****add collision******");
<<<<<<< HEAD
		System.out.println(typeChosen);
		for (GameObjectType g: myCollisions.keySet()) {
			for (IGameEvent i: myCollisions.get(g)) {
=======
		System.out.println(myData.getType());
		for (GameObjectType g: myData.getCollisionMap().keySet()) {
			for (ICollisionEvent i: myData.getCollisionMap().get(g)) {
>>>>>>> feature/towers
				System.out.println(String.format("%s->%s", g, i.getClass().getSimpleName()));
			}
		}
	}

	private HBox makeListElement(GameObjectType objectType, ICollisionEvent gameEvent){
		HBox element = new HBox();
		
		element.setAlignment(Pos.BASELINE_CENTER);
		Text text = new Text(ResourceManager.getString(objectType.toString()));
		ComboBox<String> dropdown = makeEventDropdown(gameEvent);
		element.setSpacing(100);
		element.getChildren().add(text);
		element.getChildren().add(dropdown);
	
		return element;
	}
	
	private ComboBox<String> makeEventDropdown(ICollisionEvent gameEvent){
		ComboBox<String> eventDropdown = new ComboBox<String>();
		String eventName = gameEvent.getClass().getSimpleName();
		eventDropdown.getItems().add(eventName);
		return eventDropdown;
	}
	
	@SuppressWarnings("unchecked")
	private void removeCollisionEventFromList() {
		if (!myCollisions.isEmpty()) {
			int selectedIdx = myListView.getSelectionModel().getSelectedIndex();
			if (selectedIdx == -1) {
				AlertBoxFactory.createObject("Please first select an collide object type from the list");
				return;
			}
			HBox selectedItem = myListView.getSelectionModel().getSelectedItem();
			String collisionObjTypeToRemove = ((Text) selectedItem.getChildren().get(0)).getText().toUpperCase();
			String collisionEventToRemove = ((ComboBox<String>) selectedItem.getChildren().get(1)).getSelectionModel().getSelectedItem();
			if (((ComboBox<String>) selectedItem.getChildren().get(1)).getSelectionModel().getSelectedIndex() == -1) {
				AlertBoxFactory.createObject("Please first select an collide event from the ComboBox");
				return;
			}
			removeCollideEvent(selectedIdx,collisionObjTypeToRemove, collisionEventToRemove);
		}
		else {
			AlertBoxFactory.createObject("Collisions map empty, nothing to remove");
		}
		
		System.out.println("*****remove collision******");
<<<<<<< HEAD
		System.out.println(typeChosen);
		for (GameObjectType g: myCollisions.keySet()) {
			for (IGameEvent i: myCollisions.get(g)) {
=======
		System.out.println(myData.getType());
		for (GameObjectType g: myData.getCollisionMap().keySet()) {
			for (ICollisionEvent i: myData.getCollisionMap().get(g)) {
>>>>>>> feature/towers
				System.out.println(String.format("%s->%s", g, i.getClass().getSimpleName()));
			}
		}
	}

	private void removeCollideEvent(int selectedIdx, String collisionObjTypeToRemove, String collisionEventToRemove) {		
<<<<<<< HEAD
		Iterator<IGameEvent> iter = myCollisions.get(GameObjectType.valueOf(collisionObjTypeToRemove)).iterator();
=======
		Iterator<ICollisionEvent> iter = myData.getCollisionMap().get(GameObjectType.valueOf(collisionObjTypeToRemove)).iterator();
>>>>>>> feature/towers
		while (iter.hasNext()) {
		    ICollisionEvent str = iter.next();
		    if (str.getClass().getSimpleName().equals(collisionEventToRemove)) {
		    	iter.remove();
		    }
		}
		
//	    System.out.println("The value size after removal is " + myData.getCollisionMap().get(GameObjectType.valueOf(collisionObjTypeToRemove)).size());	
<<<<<<< HEAD
		Iterator<Map.Entry<GameObjectType,Collection<IGameEvent>>> iter2 = myCollisions.entrySet().iterator();
=======
		Iterator<Map.Entry<GameObjectType,Collection<ICollisionEvent>>> iter2 = myData.getCollisionMap().entrySet().iterator();
>>>>>>> feature/towers
		while (iter2.hasNext()) {
			Map.Entry<GameObjectType,Collection<ICollisionEvent>> entry = iter2.next();
		    if(entry.getValue().isEmpty()){
		        iter2.remove();
		    }
		}
	    
	    removeItemFromListView(selectedIdx, collisionEventToRemove);
//		System.out.println("The entry-value set of the map after removal is " + myData.getCollisionMap().keySet().size());
	}

	private void removeItemFromListView(int selectedIdx, String collisionEventToRemove) {
		HBox selectedhBox = myListView.getItems().get(selectedIdx);
	    @SuppressWarnings("unchecked")
		ComboBox<String> selectedcBox = (ComboBox<String>) selectedhBox.getChildren().get(1);
	    Iterator<String> iter = selectedcBox.getItems().iterator();
		while (iter.hasNext()) {
		    String str = iter.next();
		    if (str.equals(collisionEventToRemove)) {
		    	iter.remove();
		    }
		}	
		if (selectedcBox.getItems().isEmpty()) {
			myListView.getItems().remove(selectedIdx);
		}
	}

}
