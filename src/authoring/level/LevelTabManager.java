package authoring.level;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class LevelTabManager {

	private TabPane myTabPane;
	
	public LevelTabManager() {
		myTabPane = new TabPane();
	}
	
	public void addNewLevel() {
		int numLevels = myTabPane.getTabs().size();
		LevelTab newLevel = null;
		try {
			newLevel = new LevelTab(numLevels+1);
		} catch (Exception e) {
			e.printStackTrace();
			AlertBoxFactory.createObject("Error");
			return;
		}
		newLevel.getTab().setOnClosed(e -> updateLevelNumbers());
		myTabPane.getTabs().add(newLevel.getTab());
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
