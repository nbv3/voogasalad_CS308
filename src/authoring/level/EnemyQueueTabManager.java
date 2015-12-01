package authoring.level;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import authoring.data.MapData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class EnemyQueueTabManager {
	private TabPane myTabPane;
	private Map<Tab, LevelEditor> myLevelMap;
	private boolean canAdd = true;

	public EnemyQueueTabManager() {
		myTabPane = new TabPane();

		Tab addTab = new Tab("+");

		Tab tab1 = new Tab("Wave 1");
		tab1.setContent(new EnemyQueuePane().getContent());
		tab1.setOnClosed(e -> removeLevel(tab1));
		myTabPane.getSelectionModel().select(tab1);
		myTabPane.getTabs().addAll(addTab, tab1);

		myTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> arg0, Tab arg1, Tab arg2) {
				if (arg2 == addTab && (!arg1.getText().equals("Wave 1") || canAdd == true)) {
					addNewWave();
					updateLevelNumbers();
				}
			}
		});
	}

	public void addNewWave() {
		canAdd = false;
		EnemyQueuePane newWave;
		try {
			newWave = new EnemyQueuePane();
		} catch (Exception e) {
			AlertBoxFactory.createObject(e.getMessage());
			return;
		}
		Tab newWaveTab = new Tab("");
		newWaveTab.setContent(newWave.getContent());
		newWaveTab.setOnClosed(e -> removeLevel(newWaveTab));

		myTabPane.getTabs().add(newWaveTab);
		myTabPane.getSelectionModel().select(newWaveTab);
		updateLevelNumbers();

	}

	public TabPane getTabPane() {
		return myTabPane;
	}

	private void removeLevel(Tab levelTab) {
		myTabPane.getTabs().remove(levelTab);
		updateLevelNumbers();
	}

	private void updateLevelNumbers() {
		int i = 1;
		for (Tab t : myTabPane.getTabs()) {
			if (!t.getText().equals("+")) {
				t.setText(String.format("%s %s", "Wave", i));
				i++;
			}

		}
	}
}