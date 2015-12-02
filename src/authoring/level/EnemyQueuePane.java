package authoring.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
		
		ObservableList<Node> wave = FXCollections.observableArrayList();
		myQueuePane.setItems(wave);
		myQueuePane.setOrientation(Orientation.HORIZONTAL);
	}
	
	// called when drag-drop happens
	public void addObjectToQueue(ObjectData obj) {
		myQueue.add(obj);
		myWave.add(createQueueBoxFromObjData(obj));
	}
	
	public Node createQueueBoxFromObjData(ObjectData obj) {
		// later will pass in ObjectData instance to QueueBox constructor
		QueueBox queueBox = new QueueBox();
		return queueBox.getContent();	
	}

	public ListView<Node> getContent() {
		return myQueuePane;
	}


}
