package com.syntacticsugar.vooga.authoring.level;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import authoring.fluidmotion.FadeTransitionWizard;
import authoring.fluidmotion.FluidGlassBall;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class EnemyQueuePane {

	private ListView<Node> myQueuePane;
	private Queue<ObjectData> myQueue;
	private ObservableList<Node> myWave;
	private Node selectedItem;
	private HashMap<Node, ObjectData> myObjects;

	public EnemyQueuePane() {
		myObjects = new HashMap<Node, ObjectData>();
		myQueuePane = new ListView<Node>();
		myQueue = new LinkedList<ObjectData>();
		myWave = FXCollections.observableArrayList();
		myQueuePane.setItems(myWave);
		myQueuePane.setOrientation(Orientation.HORIZONTAL);

		// test code
		testCreatedObjectDataList();
	}

	// test code
	private void testCreatedObjectDataList() {
		for (int i = 1; i < 3; i++) {
			ObjectData objToAdd = new ObjectData();
			objToAdd.setImagePath(String.format("enemy_monster_%d.png", i));
			objToAdd.setType(GameObjectType.ENEMY);
			List<IAttribute> attributeList = new ArrayList<IAttribute>();
			attributeList.add(new HealthAttribute(i * 100));
			objToAdd.setAttributes(attributeList);
			Map<GameObjectType, Collection<ICollisionEvent>> eventMap = new HashMap<GameObjectType, Collection<ICollisionEvent>>();
			List<ICollisionEvent> eventList = new ArrayList<ICollisionEvent>();
			ICollisionEvent eventToAdd = new HealthChangeEvent(-i * 10);
			eventList.add(eventToAdd);
			eventMap.put(GameObjectType.ENEMY, eventList);
			objToAdd.setCollisionMap(eventMap);
			addObjectToQueue(objToAdd);
		}
	}
	// end test

	// called when drag-drop happens
	public void addObjectToQueue(ObjectData obj) {
		myQueue.add(obj);
		Node temp = createQueueBoxFromObjData(obj);
		temp.setOnMouseClicked(e -> selectedItem = temp);
		myObjects.put(temp, obj);
		Tooltip.install(temp, new QueueTooltip(myObjects.get(temp)));
		myWave.add(temp);
	}

	public void removeObjectFromQueue() {
		if (selectedItem != null) {
		     Animation fade = FadeTransitionWizard
		    		 				.fadeOut(selectedItem,FluidGlassBall.getFadeDuration(),
									FluidGlassBall.getFadeOpacityStart(),
									FluidGlassBall.getFadeOpacityEnd(),
									FluidGlassBall.getFadeCycleCount());
		     fade.setOnFinished(toExecuteOnFinished -> removeObjectFromQueue_BAREBONE());
		     fade.play();
		}
	}

	private void removeObjectFromQueue_BAREBONE() {
		myQueue.remove(myObjects.get(selectedItem));
		myWave.remove(selectedItem);
	}

	public ObjectData getSelectedItem() {
		if (selectedItem != null) {
			return myObjects.get(selectedItem);
		}
		return null;

	}

	public Node createQueueBoxFromObjData(ObjectData obj) {
		// later will pass in ObjectData instance to QueueBox constructor
		QueueBox queueBox = new QueueBox(obj);
		return queueBox.getContent();
	}

	public ListView<Node> getContent() {
		return myQueuePane;
	}

}
