package authoring.level;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;

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

	public EnemyQueueTabManager() {
		myTabPane = new TabPane();
		myTabPane.setPrefWidth(600);

		Tab tab1 = new Tab("Wave 1");
		tab1.setContent(new EnemyQueuePane().getContent());
		myTabPane.getTabs().addAll(tab1);
		myTabPane.getSelectionModel().select(tab1);
	}

	public void addNewWave() {
		EnemyQueuePane newWave;
		try {
			newWave = new EnemyQueuePane();
		} catch (Exception e) {
			AlertBoxFactory.createObject(e.getMessage());
			return;
		}
		MsgInputBoxFactory msgBox = new MsgInputBoxFactory("Choose Wave Number");

		Tab newWaveTab = new Tab(String.format("%s %d", "Wave", (int) msgBox.getValue()));
		newWaveTab.setContent(newWave.getContent());

		myTabPane.getTabs().add(newWaveTab);
		myTabPane.getSelectionModel().select(newWaveTab);

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
