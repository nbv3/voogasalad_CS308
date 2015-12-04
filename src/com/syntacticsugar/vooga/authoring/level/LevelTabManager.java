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
	private int nextLevelNum = 1;
	
	public LevelTabManager() {
		myLevelMap = new HashMap<Tab, LevelEditor>();
		myTabPane = new TabPane();
		createAddTab();
	}
	
	private void createAddTab() {
		Tab addNew = new Tab();
		addNew.setContent(null);
		addNew.setText("Add level");
		addNew.setClosable(false);
		addNew.setOnSelectionChanged(e -> addNewLevel());
		myTabPane.getTabs().add(addNew);
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
		newLevelTab.setText("Level" + " " + nextLevelNum);
		nextLevelNum++;
		myLevelMap.put(newLevelTab, newLevel);
		newLevelTab.setOnCloseRequest(e -> removeLevel(newLevelTab));
		
		myTabPane.getTabs().add(newLevelTab);
		myTabPane.getSelectionModel().select(newLevelTab);
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
		int removeInd = myTabPane.getTabs().indexOf(levelTab);
		myLevelMap.remove(levelTab);
		nextLevelNum--;
		updateLevelNumbers(removeInd-1);
		myTabPane.getSelectionModel().select(myTabPane.getTabs().size()-1);
	}
	
	private void updateLevelNumbers(int start) {
		for (int i=start; i<myTabPane.getTabs().size(); i++) {
			Tab t = myTabPane.getTabs().get(i);
			t.setText(String.format("%s %s", "Level", i));
		}
	}
	
	public MapData getMapData() {
		return myLevelMap.get(myTabPane.getSelectionModel().getSelectedItem()).getMapData();
	}

	
}
