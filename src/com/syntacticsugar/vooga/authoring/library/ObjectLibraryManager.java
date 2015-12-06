package com.syntacticsugar.vooga.authoring.library;

import java.util.ArrayList;

import com.syntacticsugar.vooga.authoring.level.LevelTabManager;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.IData;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TowerData;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.GridPane;

public class ObjectLibraryManager {

	private GridPane myView;
	private Button addSpawn;
	private Button addTower;
	private TabPane myLibraryTabs;
	private ArrayList<DataLibrary> myLibraries;

	public ObjectLibraryManager(LevelTabManager levels) {
		myView = new GridPane();
		myLibraryTabs = new TabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		myLibraries = new ArrayList<>();
		populateLibraryTabs();
		addSpawn = GUIFactory.buildButton("Add To Wave", e -> processSpawner(levels), 150.0, null);
		addTower = GUIFactory.buildButton("Add To Towers", e -> processTower(levels), 150.0, null);
		myView.add(addSpawn, 0, 0, 1, 1);
		myView.add(addTower, 1, 0, 1, 1);
		myView.add(myLibraryTabs, 0, 1, 2, 1);

	}

	private GameObjectType[] getObjectTypes() {
		return GameObjectType.values();
	}

	private void populateLibraryTabs() {

		for (GameObjectType type : getObjectTypes()) {
			DataLibrary lib = new DataLibrary(type);
			Tab tab = new Tab(type.toString());
			tab.setContent(lib.getContent().getView());
			myLibraryTabs.getTabs().add(tab);
			myLibraries.add(lib);
		}
	}

	public Node getView() {
		return myView;
	}

	public void refresh() {
		for (DataLibrary lib : myLibraries) {
			lib.refresh();
		}
	}

	public ArrayList<DataLibrary> getLibraries() {
		return myLibraries;
	}

	private IData getCurrentData() {
		int num = myLibraryTabs.getSelectionModel().getSelectedIndex();
		IData data = myLibraries.get(num).getCurrentData();
		return data;
	}

	private void processSpawner(LevelTabManager levels) {
		if (getCurrentData().getType().equals(GameObjectType.ENEMY)) {
			ObjectData data = (ObjectData) getCurrentData();
			levels.addCurrentSpawner(data);
		}
	}

	private void processTower(LevelTabManager levels) {
		if (getCurrentData().getType().equals(GameObjectType.TOWER)) {
			TowerData data = (TowerData) getCurrentData();
			levels.addCurrentTower(data);
		}
	}

}
