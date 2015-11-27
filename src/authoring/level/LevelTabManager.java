package authoring.level;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class LevelTabManager {

	private TabPane myTabPane;
	
	public LevelTabManager() {
		myTabPane = new TabPane();
	}
	
	public void addNewLevel() throws NumberFormatException {
		LevelTab newLevel = null;
		try {
			newLevel = new LevelTab();
		} catch (NumberFormatException e) {
			AlertBoxFactory.createObject(e.getMessage());
			return;
		}
		newLevel.getTab().setOnClosed(e -> updateLevelNumbers());
		myTabPane.getTabs().add(newLevel.getTab());
		updateLevelNumbers();
	}
	
	public TabPane getTabPane() {
		return myTabPane;
	}
	
	private void updateLevelNumbers() {
		int i=1;
		for (Tab t : myTabPane.getTabs()) {
			t.setText(String.format("%s %s", "Level", i));
			i++;
		}
	}
	
}
