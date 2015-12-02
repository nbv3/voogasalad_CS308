package authoring.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.syntacticsugar.vooga.gameplayer.attribute.HealthAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.AIMovementAttribute;
import com.syntacticsugar.vooga.gameplayer.attribute.movement.MovementControlAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.event.implementations.HealthChangeEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import authoring.data.ObjectData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class EnemyQueuePane {
	
	private ListView<Node> myQueuePane;
	private Queue<ObjectData> myQueue;
	private ObservableList<Node> myWave;

	public EnemyQueuePane() {
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
		for (int i=1;i<10;i++) {
			ObjectData objToAdd = new ObjectData();
			objToAdd.setImagePath(String.format("enemy_moster_%d.png",i));
			objToAdd.setType(GameObjectType.ENEMY);
			List<IAttribute> attributeList = new ArrayList<IAttribute>();
			attributeList.add(new HealthAttribute(i*100));
			objToAdd.setAttributes(attributeList);
			Map<GameObjectType, Collection<IGameEvent>> eventMap = new HashMap<GameObjectType, Collection<IGameEvent>>();
			List<IGameEvent> eventList = new ArrayList<IGameEvent>();
			IGameEvent eventToAdd = new HealthChangeEvent(-i*10);
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
		myWave.add(createQueueBoxFromObjData(obj));
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
