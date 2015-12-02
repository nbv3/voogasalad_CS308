package authoring.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class EnemyQueuePane {
	private ListView<VBox> myWave;

	public EnemyQueuePane() {
		myWave = new ListView<VBox>();
		List<VBox> list1 = new ArrayList<VBox>();
		ObservableList<VBox> observable1 = FXCollections.observableList(list1);
		myWave.setItems(observable1);
		myWave.setOrientation(Orientation.HORIZONTAL);
	}

	public ListView<VBox> getContent() {
		return myWave;
	}


}
