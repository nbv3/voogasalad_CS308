package authoring.level;

import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import xml.data.MapData;

public class LevelTabManager {

	private TabPane myTabPane;
	private Map<Tab, LevelEditor> myLevelMap;
	
	public LevelTabManager() {
		myLevelMap = new HashMap<Tab, LevelEditor>();
		myTabPane = new TabPane();
	}
	
	public void addNewLevel() {
		LevelEditor newLevel = null;
		try {
			newLevel = new LevelEditor();
		} catch (Exception e) {
			AlertBoxFactory.createObject(e.getMessage());
			return;
		}
		Tab newLevelTab = new Tab();
		newLevelTab.setContent(newLevel.getContent());
		myLevelMap.put(newLevelTab, newLevel);
		newLevelTab.setOnClosed(e -> removeLevel(newLevelTab));
		
		myTabPane.getTabs().add(newLevelTab);
		myTabPane.getSelectionModel().select(newLevelTab);
		updateLevelNumbers();
	}
	
	public void loadMap(MapData loadedMap) {
		myLevelMap.get(myTabPane.getSelectionModel().getSelectedItem()).loadMap(loadedMap);
	}
	
	public TabPane getTabPane() {
		return myTabPane;
	}
	
	private void removeLevel(Tab levelTab) {
		myLevelMap.remove(levelTab);
		updateLevelNumbers();
	}
	
	private void updateLevelNumbers() {
		int i=1;
		for (Tab t : myTabPane.getTabs()) {
			t.setText(String.format("%s %s", "Level", i));
			i++;
		}
	}
	
	public MapData getMapData() {
		return myLevelMap.get(myTabPane.getSelectionModel().getSelectedItem()).getMapData();
	}
	
}
