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
	private TabPane myQueueTabs;
	private Map<Integer, ListView<VBox>> myQueues = new HashMap<Integer, ListView<VBox>>();

	public EnemyQueuePane() {
		myQueueTabs = new TabPane();

		ListView<VBox> wave1 = new ListView<VBox>();
		List<VBox> list1 = new ArrayList<VBox>();
		ObservableList<VBox> observable1 = FXCollections.observableList(list1);
		observable1.add(new QueueBox().getContent());
		wave1.setItems(observable1);
		wave1.setOrientation(Orientation.HORIZONTAL);
		myQueues.put(1, wave1);

		Tab tab1 = new Tab("Wave 1");
		tab1.setContent(wave1);

		Tab addTab = new Tab("+");
		myQueueTabs.getTabs().addAll(addTab, tab1);
		myQueueTabs.getSelectionModel().select(tab1);
		myQueueTabs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> arg0, Tab arg1, Tab arg2) {
				if (arg2 == addTab) {
					addNewTab();
					updateLevelNumbers();
				}
			}
		});
	}

	public TabPane getContent() {
		return myQueueTabs;
	}

	private void addNewTab() {
		ListView<VBox> newWave = new ListView<VBox>();
		List<VBox> newList = new ArrayList<VBox>();
		ObservableList<VBox> observableNew = FXCollections.observableList(newList);
		observableNew.add(new QueueBox().getContent());
		newWave.setItems(observableNew);
		newWave.setOrientation(Orientation.HORIZONTAL);
		myQueues.put(myQueues.size(), newWave);

		Tab newTab = new Tab("");
		newTab.setContent(newWave);
		newTab.setOnClosed(e -> removeLevel(newTab));

		myQueueTabs.getTabs().add(newTab);
		myQueueTabs.getSelectionModel().select(newTab);

	}
	private void removeLevel(Tab levelTab) {
		myQueueTabs.getTabs().remove(levelTab);
		updateLevelNumbers();
	}

	private void updateLevelNumbers() {
		int i = 1;
		for (Tab t : myQueueTabs.getTabs()) {
			if (!t.getText().equals("+")) {
				t.setText(String.format("%s %s", "Wave", i));
				i++;
			}
		}
	}
}
