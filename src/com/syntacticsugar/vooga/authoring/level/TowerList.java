package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

public class TowerList {
	private ListView<Node> myTowerView;
	private ObservableList<Node> myObservable;
	private HashMap<Node, ObjectData> myMap;
	private Object selectedItem;

	public TowerList() {
		myTowerView = new ListView<Node>();
		myObservable = FXCollections.observableArrayList();
		myTowerView.setItems(myObservable);
		myTowerView.setOrientation(Orientation.VERTICAL);
		myMap = new HashMap<Node, ObjectData>();

		testCreatedObjectDataList();
	}

	// test method
	private void testCreatedObjectDataList() {
		for (int i = 1; i < 3; i++) {
			ObjectData objToAdd = new ObjectData();
			objToAdd.setImagePath(String.format(String.format("tower_%d.png", i)));
			objToAdd.setType(GameObjectType.TOWER);
			List<IAttribute> attributeList = new ArrayList<IAttribute>();
			attributeList.add(new HealthAttribute(i * 100));
			objToAdd.setAttributes(attributeList);
			Map<GameObjectType, Collection<ICollisionEvent>> eventMap = new HashMap<GameObjectType, Collection<ICollisionEvent>>();
			List<ICollisionEvent> eventList = new ArrayList<ICollisionEvent>();
			ICollisionEvent eventToAdd = new HealthChangeEvent(-i * 10);
			eventList.add(eventToAdd);
			eventMap.put(GameObjectType.ENEMY, eventList);
			objToAdd.setCollisionMap(eventMap);
			addTower(objToAdd);
		}
	}

	public void addTower(ObjectData data) {
		Node newTower = createQueueBoxFromObjData(data);
		newTower.setOnMouseClicked(e -> selectedItem = newTower);

		myMap.put(newTower, data);
		Tooltip.install(newTower, new QueueTooltip(myMap.get(newTower)));
		myObservable.add(newTower);
	}
	
	//method to use when back end needs to retrieve list of tower object data associated
	//with a level
	public Collection<ObjectData> getObjectDataList() {
		return myMap.values();
	}

	public Node createQueueBoxFromObjData(ObjectData obj) {
		QueueBox queueBox = new QueueBox(obj);
		return queueBox.getContent();
	}

	public void removeObjectFromList() {
		if (selectedItem != null) {
			myObservable.remove(selectedItem);
			myMap.remove(selectedItem);
		}
	}

	public void clearAll() {
		myObservable.clear();
		myMap.clear();
	}

	public ObjectData getSelectedItem() {
		if (selectedItem != null) {
			return myMap.get(selectedItem);
		}
		return null;

	}

	public ListView<Node> getView() {
		return myTowerView;
	}

}
