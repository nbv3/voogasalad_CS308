package authoring.library;

import java.io.File;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.Region;

public class ObjectLibraryManager {

	private TabPane myLibraryTabs;
	private ObjectLibrary myEnemyLibrary;
	private ObjectLibrary myTowerLibrary;
	private ObjectLibrary myPlayerLibrary;
	private ObjectLibrary myItemLibrary;

	public ObjectLibraryManager() {
		initializeLibraryTabs();
		myLibraryTabs = new TabPane();
		populateTabPane();
		myLibraryTabs.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
	}

	private void initializeLibraryTabs() {
		myEnemyLibrary = new EnemyLibrary(GameObjectType.ENEMY);
		myTowerLibrary = new TowerLibrary(GameObjectType.TOWER);
		myPlayerLibrary = new PlayerLibrary(GameObjectType.PLAYER);
		myItemLibrary = new ItemLibrary(GameObjectType.ITEM);
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
