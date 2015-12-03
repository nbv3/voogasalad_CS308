package authoring.level;

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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import xml.data.ObjectData;

public class EnemyQueuePane {
	
	private ListView<Node> myQueuePane;
	private Queue<ObjectData> myQueue;
	private ObservableList<Node> myWave;
	private Node selectedItem;
	private HashMap<Node, ObjectData>  myObjects;

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
		for (int i=1;i<23;i++) {
			ObjectData objToAdd = new ObjectData();
			objToAdd.setImagePath(String.format("enemy_monster_%d.png",i));
			objToAdd.setType(GameObjectType.ENEMY);
			List<IAttribute> attributeList = new ArrayList<IAttribute>();
			attributeList.add(new HealthAttribute(i*100));
			objToAdd.setAttributes(attributeList);
			Map<GameObjectType, Collection<ICollisionEvent>> eventMap = new HashMap<GameObjectType, Collection<ICollisionEvent>>();
			List<ICollisionEvent> eventList = new ArrayList<ICollisionEvent>();
			ICollisionEvent eventToAdd = new HealthChangeEvent(-i*10);
			eventList.add(eventToAdd);
			eventMap.put(GameObjectType.ENEMY,eventList);
			objToAdd.setCollisionMap(eventMap);
			addObjectToQueue(objToAdd);
		}
	}
	// end test
	
	// called when drag-drop happens
	public void addObjectToQueue(ObjectData obj) {
		myQueue.add(obj);
		Node temp = createQueueBoxFromObjData(obj);
		myWave.add(temp);
		myObjects.put(temp, obj);
		setHandlers();
	}
	
	private void setHandlers()
	{
		for(int i = 0; i < myQueuePane.getItems().size(); i++)
		{
			Node temp = myQueuePane.getItems().get(i);
			temp.setOnMouseClicked(e-> setSelectedItem(temp));
		}
	}
	
	private void setSelectedItem(Node n)
	{
		selectedItem = n;
	}
	
	public void removeObjectFromQueue()
	{
		if(selectedItem != null)
		{
			myQueue.remove(myObjects.get(selectedItem));
			myWave.remove(selectedItem);
		}

	}
	
	public Node createQueueBoxFromObjData(ObjectData obj) {
		// later will pass in ObjectData instance to QueueBox constructor
		QueueBox queueBox = new QueueBox(obj);
		return queueBox.getContent();	
	}

	public ListView<Node> getContent() {
		return myQueuePane;
	}
	
	public ObjectData getSelectedItem()
	{
		if(selectedItem != null)
		{
			return myObjects.get(selectedItem);
		}
		return null;

	}


}
