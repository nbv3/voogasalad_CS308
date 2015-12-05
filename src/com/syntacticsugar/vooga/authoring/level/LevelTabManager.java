package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.xml.data.MapData;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class LevelTabManager{

	private TabPane myTabPane;
	private Map<Tab, LevelEditor> myLevelMap;
	
	public LevelTabManager() {
		myLevelMap = new HashMap<Tab, LevelEditor>();
		myTabPane = new TabPane();
		addNewLevel();
	}
	
	
	public void addNewLevel() {
		LevelEditor newLevel = null;
		try {
			newLevel = new LevelEditor();
		} catch (Exception e) {
			AlertBoxFactory.createObject(e.getMessage());
			e.printStackTrace();
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

	public ArrayList<LevelEditor> getLevels()
	{
		ArrayList<LevelEditor> levels = new ArrayList<LevelEditor>();
		for(LevelEditor level: myLevelMap.values())
		{
			levels.add(level);
		}
		return levels;
	}
	private void removeLevel(Tab levelTab) {
		myLevelMap.remove(levelTab);
		updateLevelNumbers();
	}
	
	private void updateLevelNumbers() {
		for (int i=0; i<myTabPane.getTabs().size(); i++) {
			Tab t = myTabPane.getTabs().get(i);
			t.setText(String.format("%s %s", "Level", i+1));
		}
	}
	
	public MapData getMapData() {
		return myLevelMap.get(myTabPane.getSelectionModel().getSelectedItem()).getMapData();
	}

	
}
