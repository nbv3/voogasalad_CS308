//This entire file is part of my masterpiece
//Arthur Schweitzer

package com.syntacticsugar.vooga.authoring.objectediting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.parameters.ParameterInputFactory;
import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.reflection.Reflection;

import javafx.scene.control.ListView;

public class CollisionMakerWizard extends AbstractMakerWizard{

	/*This subclass of AbstractMakerWizard is called when the user selects the option to add a new collision-pair. 
	 Similar to AttributeMakerWizard, this class utilizes the ParameterInputFactory to generate necessary GUI elements.
	At first, a new stage is generated and populated with an HBox split into two columns, so that the user can view all 
	possible types of objects that this specific object can collide with in a listView (on the left) and then see all the 
	possible event type outcomes of this collision as a listView (on the right). Once both an object type and eventType 
	have been selected and 'Add' is clicked, a call to the ParameterInputFactory is made, which generates a new stage 
	populated with all necessary outcomes of an event type (i.e. HealthChangeEvent generates textField to set healthChangeAmount). 
	Once, all relevant textFields have been set and confirmed, collision pair is added to the CollisionViewer's display pane.*/
	

	public CollisionMakerWizard(GameObjectType type, Map<GameObjectType, Collection<ICollisionEvent>> collisionsMap) {
		super(type, collisionsMap);
	}

	@Override ListView<GameObjectType> createObjectListView(GameObjectType type) {
		ListView<GameObjectType> types = new ListView<GameObjectType>();
		types.getItems().addAll(GameObjectType.values());
		types.setOnMouseClicked(e -> {
			selectedObject = types.getSelectionModel().getSelectedItem();
		});
		return types;
	}

	@Override ListView<String> createEventListView() {
		ListView<String> events = new ListView<String>();
		events.getItems().addAll(ResourceManager.getString("game_events").split(","));
		events.setOnMouseClicked(e -> {
			selectedObjectString = events.getSelectionModel().getSelectedItem();
		});
		return events;
	}


	@Override void createObject() {
		if (selectedObject == null) {
			AlertBoxFactory.createObject(ResourceManager.getString("select_gameobjecttype"));
			return;
		}
		if (selectedObjectString == null) {
			AlertBoxFactory.createObject(ResourceManager.getString("select_gameeventtype"));
			return;
		}

		if (getMap().containsKey(selectedObject)) {
			for (Object i : (ArrayList)getMap().get(selectedObject)) {
				if (i.getClass().getSimpleName().equals(selectedObjectString)) {
					AlertBoxFactory.createObject(String.format("Cannot add more than one %s to collide type %s",
							selectedObjectString, selectedObject));
					return;
				}
			}
			addCollideEventToExistingKey();
		} else {
			addCollideEventToNonExistingKey();
		}

	}

	private void addCollideEventToExistingKey() {
		String className = ResourceManager.getString(String.format("%s_%s", selectedObjectString, "name"));
		setObjectToAdd((ICollisionEvent) Reflection.createInstance(className));
		ParameterInputFactory.createInputFields(getObjectToAdd());
		((Collection<ICollisionEvent>) getMap().get(selectedObject)).add((ICollisionEvent)getObjectToAdd());
	}

	private void addCollideEventToNonExistingKey() {
		String className = ResourceManager.getString(String.format("%s_%s", selectedObjectString, "name"));
		Collection<ICollisionEvent> collideEvents = new ArrayList<ICollisionEvent>();
		ICollisionEvent eventToAdd = (ICollisionEvent) Reflection.createInstance(className);
		ParameterInputFactory.createInputFields(eventToAdd);
		collideEvents.add(eventToAdd);
		getMap().put(selectedObject, collideEvents);
	}


}
