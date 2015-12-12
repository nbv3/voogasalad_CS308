package com.syntacticsugar.vooga.authoring.library;

import java.util.ArrayList;

import com.syntacticsugar.vooga.authoring.level.LevelTabManager;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.IData;
import com.syntacticsugar.vooga.xml.data.TowerData;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;

public class ObjectLibraryManager {

	private VBox myView;
	private Button addTowerButton;
	private TabPane myLibraryTabs;
	private ArrayList<DataLibrary> myLibraries;

	public ObjectLibraryManager(LevelTabManager levels) {
		myView = new VBox();
		myLibraryTabs = new TabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		myLibraries = new ArrayList<>();
		populateLibraryTabs();
		addTowerButton = GUIFactory.buildButton("Add To Towers", e -> processTower(levels), null, null);
		addTowerButton.setPrefWidth(120);
		addTowerButton.setAlignment(Pos.CENTER);
		myView.setAlignment(Pos.TOP_CENTER);
		myView.getChildren().addAll(addTowerButton, myLibraryTabs);

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

	public void loadLibraries() {
		myLibraryTabs.getTabs().clear();
		populateLibraryTabs();
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

	private void processTower(LevelTabManager levels) {

		if (getCurrentData() == null) {
			AlertBoxFactory.createObject(ResourceManager.getString("select_tower"));
			return;
		}
		if (getCurrentData().getType().equals(GameObjectType.TOWER)) {
			TowerData data = (TowerData) getCurrentData();
			levels.addCurrentTower(data);
		}
	}

}
