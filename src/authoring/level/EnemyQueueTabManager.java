package authoring.level;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import authoring.data.MapData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnemyQueueTabManager {
	private TabPane myTabPane;
	private boolean canAdd = true;

	public EnemyQueueTabManager() {
		myTabPane = new TabPane();
		myTabPane.setPrefWidth(600);

		Tab addTab = new Tab("+");
		Tab tab1 = new Tab("Wave 1");
		tab1.setContent(new EnemyQueuePane().getContent());
		myTabPane.getTabs().addAll(addTab, tab1);
		myTabPane.getSelectionModel().select(tab1);
		myTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

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
		EnemyQueuePane newWave;
		try {
			newWave = new EnemyQueuePane();
		} catch (Exception e) {
			AlertBoxFactory.createObject(e.getMessage());
			return;
		}
		canAdd = false;
		Tab newWaveTab = new Tab("");
		newWaveTab.setContent(newWave.getContent());

		myTabPane.getTabs().add(newWaveTab);
		myTabPane.getSelectionModel().select(newWaveTab);

		updateLevelNumbers();
		System.out.println(myTabPane.getTabs().size());

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
	
	public Node getView() {
		return myTabPane;
	}
	
}
