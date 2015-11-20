package com.syntacticsugar.vooga.authoring.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.authoring.editor.sidepanes.SpawnerPropertyBox;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.ButtonFactory;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TowerEditor {
	private VBox towerEditor;
	private TilePane towerQueuePane;
	private ResourceBundle towerIconBundle;
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
//	private List<AbstractTower> towerList;	// here SpawnerTester need to change to Spawner later
	private SpawnerPropertyBox towerProperty;
	private List<DecoratorTile> currentTileSelection;
	private final int NUMBER_ROW_ICON_PANEL = 2;
	private final int NUMBER_COLUMN_ICON_PANEL = 5;
	private final double WIDTH_ICON_PANEL = 250;
	private final double HEIGHT_ICON_PANEL = 100;
	private final int NUMBER_ROW_QUEUE_PANEL = 3;
	private final int NUMBER_COLUMN_QUEUE_PANEL = 10;
	private final double WIDTH_QUEUE_PANEL = 500;
	private final double HEIGHT_QUEUE_PANEL = 150;
	private ImageView selectImg;

	public TowerEditor(List<DecoratorTile> selectedTiles) {
		currentTileSelection = selectedTiles;
		towerEditor = new VBox();
//		towerList = new LinkedList<AbstractTower>();	// here String need to change to Spawner later
		VBox d = new DamageBox().getNode();
		d.getStyleClass().add("properties-module");
		VBox w = new WeaponBox().getNode();
		w.getChildren().add(createAddTowerButton());
		w.getStyleClass().add("properties-module");
		towerQueuePane = createSpawnQueueIconPane();
		towerQueuePane.getStyleClass().add("properties-module");
		towerEditor.getChildren().add(createTowerIconPane());
		towerEditor.getChildren().addAll(d, w);
		towerEditor.getChildren().add(createTowerListPane());
	}

	public VBox getNode() {
		return towerEditor;
	}
	
	private GridPane createTowerIconPane() {
		GridPane towerIconPane = new GridPane();
		towerIconPane.getStyleClass().add("properties-module");
		towerIconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		//towerQueuePane.setGridLinesVisible(true);
		towerIconBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "TowerIcon");
		String[] towerIconPath = towerIconBundle.getString("Tower").split(",");	
		towerIconPane.getChildren().clear();
		for (int i = 0; i < towerIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(towerIconPath[i])));
			
			img.setOnMouseClicked(e -> {
				selectImg = img;
				img.requestFocus();});
			
			img.focusedProperty().addListener((o,oldValue,newValue) -> {
		        if (newValue) {
		            img.setEffect(new Glow(0.7));
		        }
		        else {
		            img.setEffect(null);
		        }});
			
			img.setFitWidth(towerIconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(towerIconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			towerIconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		return towerIconPane;
	}
	
	private VBox createTowerListPane() {
		VBox spawnListPane = new VBox();
		spawnListPane.getStyleClass().add("properties-module");
		spawnListPane.getChildren().add(createTowerQueueText());
		spawnListPane.getChildren().add(towerQueuePane);
		spawnListPane.getChildren().add(createSetTowerButton());
		return spawnListPane;
	}

	private Node createSetTowerButton() {
		Button setButton = new ButtonFactory().createObject("Set");
		setButton.setOnAction(e -> addTowerListToUniverse());
		return setButton;
	}

	private void addTowerListToUniverse() {
//		if (towerList.isEmpty()) {
//			new AlertBoxFactory().createObject("No tower added, please add at least one spawner");
//			return;
//		}
		
		if (currentTileSelection.isEmpty()) {
			new AlertBoxFactory().createObject("No tile selected, please slect at least one tile");
			return;
		}
		
		for (DecoratorTile t: currentTileSelection) {
			if (t.isWalkable()) {
				new AlertBoxFactory().createObject("Tower can only be added to scenary tiles");
				return;
			}
		}
		
		// need to implement later to add the final SpawnerObject list to the selected tiles
		// (code here)
		towerQueuePane.getChildren().clear();
		return;
	}

	private Button createAddTowerButton() {
		Button addButton = new ButtonFactory().createObject("Add");
		addButton.setOnAction(e -> addSpawnerToQueue(selectImg));
		return addButton;
	}
	
	private Text createTowerQueueText() {
		Text spawnerTitle = new Text("Spawner Queue");
		spawnerTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		return spawnerTitle;
	}

	private void addSpawnerToQueue(ImageView iv) {
		
//		AbstractTower towerObj = new AbstractTower();
		
		if (iv == null) {
			new AlertBoxFactory().createObject("Please select a tower image first");
			return;
		}
		
		ImageView i = new ImageView(iv.getImage());
		i.setFitWidth(towerQueuePane.getPrefWidth() / NUMBER_COLUMN_QUEUE_PANEL);
		i.setFitHeight(towerQueuePane.getPrefHeight() / NUMBER_ROW_QUEUE_PANEL);
		towerQueuePane.getChildren().add(i);
		i.setOnMouseClicked(e -> handleClickEvent(e,i));
//		towerObj.setImage(i);
//		towerList.add(towerObj);

//		System.out.println("The tower list length is " + towerList.size());
		 
		return;
	}
	
	private void handleClickEvent(MouseEvent e, ImageView i) {
		if (e.getClickCount() == 1) {
			diplaySpawnerInfo(i);
		}
		
		if (e.getClickCount() == 2) {
			removeFromSpawnList(i);
		}

		return;
	}
	
	private void diplaySpawnerInfo(ImageView i) {
		// TODO Auto-generated method stub
		
	}

	private void removeFromSpawnList(ImageView i) {
//		towerList.remove(towerQueuePane.getChildren().indexOf(i));
//		towerQueuePane.getChildren().remove(i);
//		System.out.println("The tower list length is " + towerList.size());
		return;
	}
	
	
	private TilePane createSpawnQueueIconPane() {
		TilePane towerQueuePane = new TilePane();
		towerQueuePane.setPrefSize(WIDTH_QUEUE_PANEL, HEIGHT_QUEUE_PANEL);
//		for (AbstractTower towerObj: towerList) {
//			towerQueuePane.getChildren().add(towerObj.getImage());
//		}
		return towerQueuePane;
	}
	
	public ArrayList<Object> getSpawnQueue()
	{
		ArrayList<Object> myList = (ArrayList<Object>) Arrays.asList(towerQueuePane.getChildren().toArray());
		return myList;
	}

}
