package com.syntacticsugar.vooga.authoring.level;

import java.util.Observable;

import com.sun.deploy.uitoolkit.impl.fx.ui.resources.ResourceManager;
import com.syntacticsugar.vooga.authoring.level.map.MapManager;
import com.syntacticsugar.vooga.authoring.level.spawner.SpawnerManager;
import com.syntacticsugar.vooga.authoring.level.towers.TowerManager;
import com.syntacticsugar.vooga.authoring.objectediting.IDataClipboard;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.xml.data.IData;
import com.syntacticsugar.vooga.xml.data.LevelSettings;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.SpawnerData;
import com.syntacticsugar.vooga.xml.data.TowerData;
import com.syntacticsugar.vooga.xml.data.TowerListData;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class LevelEditor implements IAddToSpawner {

	private GridPane myContentGrid;

	private MapManager myMapManager;
	private SpawnerManager mySpawnerManager;
	private TowerManager myTowerManager;
	private LevelConditionManager myConditions;

	public LevelEditor(IDataClipboard clip) throws Exception {
		IAddToSpawner iSpawn = this;
		myMapManager = new MapManager(clip, iSpawn);
		mySpawnerManager = new SpawnerManager();
		myTowerManager = new TowerManager();
		myConditions = new LevelConditionManager();

		buildTabContents();
	}

	private void buildTabContents() {
		myContentGrid = new GridPane();
		myContentGrid.setPadding(new Insets(10));
		myContentGrid.setHgap(10);
		myContentGrid.setVgap(10);

		addColumnConstraints(myContentGrid);
		addRowConstraints(myContentGrid);

		myContentGrid.add(myMapManager.getControlNode(), 0, 0, 1, 3);
		myContentGrid.add(myMapManager.getViewNode(), 1, 0, 1, 3);

		myContentGrid.add(mySpawnerManager.getControlNode(), 0, 3, 1, 1);
		myContentGrid.add(mySpawnerManager.getViewNode(), 1, 3, 3, 1);

		VBox towerBox = new VBox();
		towerBox.getChildren().addAll(myTowerManager.getControlNode(), myTowerManager.getViewNode());
		towerBox.setAlignment(Pos.CENTER);
		towerBox.setSpacing(20);
		myContentGrid.add(towerBox, 2, 0, 1, 2);

		myContentGrid.add(myConditions.getView(), 2, 2, 1, 1);
	}

	public Node getContent() {
		BorderPane myView = new BorderPane();
		myView.setCenter(myContentGrid);
		return myView;
	}

	private void addColumnConstraints(GridPane grid) {
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(20);
		ColumnConstraints c2 = new ColumnConstraints();
		c2.setPercentWidth(55);
		ColumnConstraints c3 = new ColumnConstraints();
		c3.setPercentWidth(25);
		grid.getColumnConstraints().addAll(c1, c2, c3);
	}

	private void addRowConstraints(GridPane grid) {
		RowConstraints r0 = new RowConstraints();
		r0.setPercentHeight(10);
		RowConstraints r1 = new RowConstraints();
		r1.setPercentHeight(20);
		RowConstraints r2 = new RowConstraints();
		r2.setPercentHeight(30);
		RowConstraints r3 = new RowConstraints();
		r3.setPercentHeight(40);
		grid.getRowConstraints().addAll(r0, r1, r2, r3);
	}

	public MapData getMapData() {
		return myMapManager.getMapData();
	}

	public SpawnerData getSpawnerQueues() {
		return mySpawnerManager.getSpawnerData();
	}

	public Observable getTowerControls() {
		return myTowerManager.getObservableController();
	}

	public Observable getSpawnerControls() {
		return mySpawnerManager.getObservableController();
	}

	public TowerListData getTowerList() {
		return myTowerManager.getTowerData();
	}

	public LevelSettings getConditions() {
		return myConditions.getConditions();
	}

	public void loadMap(MapData loadedMap) {
		myMapManager.setMapData(loadedMap);
	}

	public SpawnerManager getSpawnerManager() {
		return mySpawnerManager;
	}

	public TowerManager getTowerManager() {
		return myTowerManager;
	}

	public void addToSpawner(ObjectData data) {
		ObjectData copyData = new ObjectData(data);
		if (copyData.getType().equals(GameObjectType.ENEMY))
			mySpawnerManager.getCurrentView().addData(copyData);
		else
			AlertBoxFactory.createObject(ResourceManager.getString("select_enemy"));

	}

	public void addToTowers(TowerData data) {
		myTowerManager.addTowerData(data);
	}

}
