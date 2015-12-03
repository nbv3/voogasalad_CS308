package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class LevelTabManager{

	private TabPane myTabPane;
	private Map<Tab, LevelEditor> myLevelMap;
	private ObjectData itemToEdit;
	
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