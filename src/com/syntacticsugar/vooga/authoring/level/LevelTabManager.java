package com.syntacticsugar.vooga.authoring.level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objectediting.IObjectDataClipboard;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.xml.data.LevelSettings;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.SpawnerData;
import com.syntacticsugar.vooga.xml.data.TowerData;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class LevelTabManager {

	private TabPane myTabPane;
	private Map<Tab, LevelEditor> myLevelMap;
	private IObjectDataClipboard iObject;

	public LevelTabManager(IObjectDataClipboard clip) {
		myLevelMap = new HashMap<Tab, LevelEditor>();
		myTabPane = new TabPane();
		iObject = clip;
		addNewLevel();
	}

	public void addNewLevel() {
		LevelEditor newLevel = null;
		try {
			newLevel = new LevelEditor(iObject);
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

	public ArrayList<LevelEditor> getLevels() {
		ArrayList<LevelEditor> levels = new ArrayList<LevelEditor>();
		for (LevelEditor level : myLevelMap.values()) {
			levels.add(level);
		}
		return levels;
	}

	private void removeLevel(Tab levelTab) {
		myLevelMap.remove(levelTab);
		updateLevelNumbers();
	}

	private void updateLevelNumbers() {
		for (int i = 0; i < myTabPane.getTabs().size(); i++) {
			Tab t = myTabPane.getTabs().get(i);
			t.setText(String.format("%s %s", "Level", i + 1));
		}
	}

	public Map<Integer, MapData> getMapData() {
		Map<Integer, MapData> map = new HashMap<Integer, MapData>();
		for (Tab t : myLevelMap.keySet()) {
			int i = t.getText().charAt(t.getText().length() - 1);
			MapData level = myLevelMap.get(t).getMapData();
			map.put(i, level);
		}
		return map;
	}

	public MapData getIndividualMapData() {

		return myLevelMap.get(myTabPane.getSelectionModel().getSelectedItem()).getMapData();
	}

	public Map<Integer, SpawnerData> getSpawnerQueues() {
		Map<Integer, SpawnerData> map = new HashMap<Integer, SpawnerData>();
		for (Tab t : myLevelMap.keySet()) {
			int i = t.getText().charAt(t.getText().length() - 1);
			SpawnerData level = myLevelMap.get(t).getSpawnerQueues();
			map.put(i, level);
		}
		return map;
	}

	public Map<Integer, TowerData> getTowerLists() {
		Map<Integer, TowerData> map = new HashMap<Integer, TowerData>();
		for (Tab t : myLevelMap.keySet()) {
			int i = t.getText().charAt(t.getText().length() - 1);
			TowerData list = myLevelMap.get(t).getTowerList();
			map.put(i, list);
		}

		return map;
	}

	public Map<Integer, LevelSettings> getConditionsList() {
		Map<Integer, LevelSettings> map = new HashMap<Integer, LevelSettings>();
		for (Tab t : myLevelMap.keySet()) {
			int i = t.getText().charAt(t.getText().length() - 1);
			LevelSettings list = myLevelMap.get(t).getConditions();
			map.put(i, list);
		}

		return map;
	}

}
