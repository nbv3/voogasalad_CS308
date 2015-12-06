package com.syntacticsugar.vooga.authoring.level.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

import com.syntacticsugar.vooga.authoring.fluidmotion.FadeTransitionWizard;
import com.syntacticsugar.vooga.authoring.fluidmotion.FluidGlassBall;
import com.syntacticsugar.vooga.authoring.level.IDataSelector;
import com.syntacticsugar.vooga.authoring.level.QueueBox;
import com.syntacticsugar.vooga.authoring.library.IRefresher;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.authoring.tooltips.ObjectTooltip;
import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.ICollisionEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.animation.Animation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;

public class SpawnerView implements IDataSelector<ObjectData>, IVisualElement, IRefresher, Observer {

	private ListView<Node> myQueuePane;
	private Queue<ObjectData> myQueue;
	private ObservableList<Node> myWave;
	private Node selectedItem;
	private HashMap<Node, ObjectData> myObjects;

	public SpawnerView() {
		myObjects = new HashMap<Node, ObjectData>();
		myQueuePane = new ListView<Node>();
		myQueue = new LinkedList<ObjectData>();
		myWave = FXCollections.observableArrayList();
		myQueuePane.setItems(myWave);
		myQueuePane.setOrientation(Orientation.HORIZONTAL);

		// test code
		// TODO: REMOVE
		testCreatedObjectDataList();

	}

	// test code
	private void testCreatedObjectDataList() {
		for (int i = 1; i < 3; i++) {
			ObjectData objToAdd = new ObjectData();
			objToAdd.setImagePath(String.format("enemy_monster_%d.png", i));
			objToAdd.setType(GameObjectType.ENEMY);
			List<IAttribute> attributeList = new ArrayList<IAttribute>();
			attributeList.add(new HealthAttribute());
			objToAdd.setAttributes(attributeList);
			Map<GameObjectType, Collection<ICollisionEvent>> eventMap = new HashMap<GameObjectType, Collection<ICollisionEvent>>();
			List<ICollisionEvent> eventList = new ArrayList<ICollisionEvent>();
			ICollisionEvent eventToAdd = new HealthChangeEvent(i * 10.0);
			eventList.add(eventToAdd);
			eventMap.put(GameObjectType.ENEMY, eventList);
			objToAdd.setCollisionMap(eventMap);
			addData(objToAdd);
		}
	}
	// end test

	// called when drag-drop happens
	@Override
	public void addData(ObjectData obj) {
		// obj.getImagePathProperty().addListener((e, ov, nv) -> {
		// refresh();
		// });
		myQueue.add(obj);
		Node temp = createQueueBoxFromObjData(obj);
		temp.setOnMouseClicked(e -> selectedItem = temp);
		myObjects.put(temp, obj);
		Tooltip.install(temp, new ObjectTooltip(myObjects.get(temp)));
		myWave.add(temp);
	}

	@Override
	public void removeSelectedData() {
		if (selectedItem != null) {
			Animation fade = FadeTransitionWizard.fadeOut(selectedItem, FluidGlassBall.getFadeDuration(),
					FluidGlassBall.getFadeOutOpacityStart(), FluidGlassBall.getFadeOutOpacityEnd(),
					FluidGlassBall.getFadeCycleCount());
			fade.setOnFinished(toExecuteOnFinished -> removeSelectedData_BAREBONE());
			fade.play();
		}
	}

	private void removeSelectedData_BAREBONE() {
		myQueue.remove(myObjects.get(selectedItem));
		myObjects.remove(selectedItem);
		myWave.remove(selectedItem);
	}

	@Override
	public ObjectData getSelectedData() {
		if (selectedItem != null) {
			return myObjects.get(selectedItem);
		}
		return null;

	}

	private Node createQueueBoxFromObjData(ObjectData obj) {
		QueueBox queueBox = new QueueBox(obj);
		return queueBox.getView();
	}

	@Override
	public Node getView() {
		return myQueuePane;
	}

	@Override
	public void clearData() {

	}

	@Override
	public Collection<ObjectData> getData() {
		return myObjects.values();
	}

	public Collection<ObjectData> getObjectQueue() {
		return myQueue;
	}

	@Override
	public void refresh() {
		myWave.clear();
		myQueue.forEach(e -> {
			Node temp = createQueueBoxFromObjData(e);
			temp.setOnMouseClicked(a -> selectedItem = temp);
			myObjects.put(temp, e);
			myWave.add(temp);
		});
		myQueuePane.refresh();
	}

	@Override
	public void update(Observable o, Object arg) {
		refresh();

	}

}
