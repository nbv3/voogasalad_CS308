package authoring.library;

import java.io.File;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

public class ObjectLibraryManager {

	private TabPane myLibraryTabs;
	private ObjectLibrary myEnemyLibrary;
	private ObjectLibrary myTowerLibrary;
	private ObjectLibrary myPlayerLibrary;
	private ObjectLibrary myItemLibrary;

	public ObjectLibraryManager(File GameDirectory) {
		initializeLibraryTabs(GameDirectory);
		myLibraryTabs = new TabPane();
		populateTabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	}

	private void initializeLibraryTabs(File GameDirectory) {
		myEnemyLibrary = new EnemyLibrary(GameDirectory);
		myTowerLibrary = new TowerLibrary(GameDirectory);
		myPlayerLibrary = new PlayerLibrary(GameDirectory);
		myItemLibrary = new ItemLibrary(GameDirectory);
	}

	private void populateTabPane() {
		Tab myEnemyTab = new Tab("Enemies");
		myEnemyTab.setContent(myEnemyLibrary.getContent());
		Tab myTowerTab = new Tab("Towers");
		myTowerTab.setContent(myTowerLibrary.getContent());
		Tab myPlayerTab = new Tab("Players");
		myPlayerTab.setContent(myPlayerLibrary.getContent());
		Tab myItemTab = new Tab("Items");
		myItemTab.setContent(myItemLibrary.getContent());
		myLibraryTabs.getTabs().addAll(myEnemyTab, myTowerTab, myPlayerTab, myItemTab);

	}

	public TabPane getTabPane() {
		return myLibraryTabs;
	}
}
