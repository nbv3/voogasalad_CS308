package editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import editor.sidepanes.SpawnerPropertyBox;
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
import objects.SpawnerObject;
import objects.towers.AbstractTower;
import tiles.DecoratorTile;

public class TowerEditor {
	private VBox towerEditor;
	private TilePane spawnQueuePane;
	private ResourceBundle towerIconBundle;
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private List<AbstractTower> towerList;	// here SpawnerTester need to change to Spawner later
	private SpawnerPropertyBox spawnerProperty;
	private List<DecoratorTile> currentTileSelection;
	private final String PATH_SPAWN_ICON = "spawner.png";
	private final int NUMBER_ROW_ICON_PANEL = 2;
	private final int NUMBER_COLUMN_ICON_PANEL = 5;
	private final double WIDTH_ICON_PANEL = 250;
	private final double HEIGHT_ICON_PANEL = 100;
	private final int NUMBER_ROW_QUEUE_PANEL = 3;
	private final int NUMBER_COLUMN_QUEUE_PANEL = 10;
	private final double WIDTH_QUEUE_PANEL = 500;
	private final double HEIGHT_QUEUE_PANEL = 150;
	private ImageView selectImg;

	public TowerEditor() {
		towerEditor = new VBox();
		//VBox h = new SpawnerPropertyBox().getNode();
		towerList = new LinkedList<AbstractTower>();	// here String need to change to Spawner later
		VBox d = new DamageBox().getNode();
		d.getStyleClass().add("properties-module");
		VBox w = new WeaponBox().getNode();
		w.getChildren().add(createAddSpawnerButton());
		w.getStyleClass().add("properties-module");
		spawnQueuePane = createSpawnQueueIconPane();
		spawnQueuePane.getStyleClass().add("properties-module");
		towerEditor.getChildren().add(createTowerIconPane());
		towerEditor.getChildren().addAll(d, w);
		//towerEditor.getChildren().add(spawnerProperty.getNode());
		//towerEditor.getChildren().add(createAddSpawnerButton());
		towerEditor.getChildren().add(createSpawnListPane());
	}

	public VBox getNode() {
		return towerEditor;
	}
	
	private VBox createSpawnListPane() {
		VBox spawnListPane = new VBox();
		spawnListPane.getStyleClass().add("properties-module");
		spawnListPane.getChildren().add(createSpawnerQueueText());
		spawnListPane.getChildren().add(spawnQueuePane);
		spawnListPane.getChildren().add(createSetSpawnerButton());
		return spawnListPane;
	}

	private Node createSetSpawnerButton() {
		Button setButton = new Button("Set");
		setButton.setPrefHeight(30);
		setButton.setPrefWidth(80);
		setButton.setOnAction(e -> addSpawnerListToSelectedTile());
		return setButton;
	}

	private void addSpawnerListToSelectedTile() {
		if (towerList.isEmpty()) {
			showAlertBox("No tower added, please add at least one spawner");
			return;
		}
		
		if (currentTileSelection.isEmpty()) {
			showAlertBox("No tile selected, please select at least one tile");
			return;
		}
		
		for (DecoratorTile t: currentTileSelection) {
			if (!t.isWalkable()) {
				showAlertBox("Tower can only be added to path tiles");
				return;
			}
		}
		
		for (DecoratorTile t: currentTileSelection) {
			ImageView spawnIcon = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(PATH_SPAWN_ICON)));
			t.setImage(spawnIcon);
			t.setTowerList(towerList);
		}
		// need to implement later to add the final SpawnerObject list to the selected tiles
		// (code here)
		spawnQueuePane.getChildren().clear();
		return;
	}

	private Button createAddSpawnerButton() {
		Button addButton = new Button("Add");
		addButton.setPrefHeight(30);
		addButton.setPrefWidth(80);
		addButton.setOnAction(e -> addSpawnerToQueue(selectImg));
		return addButton;
	}
	
	private Text createSpawnerQueueText() {
		Text spawnerTitle = new Text("Spawner Queue");
		spawnerTitle.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		return spawnerTitle;
	}
	
	private void showAlertBox(String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(str);
		alert.showAndWait();
	}

	private void addSpawnerToQueue(ImageView iv) {
		
		AbstractTower towerObj = new AbstractTower();
		
		if (iv == null) {
			showAlertBox("Please select a tower image first");
			return;
		}

		try {
			towerObj.setMaxHealth(spawnerProperty.getMaxHP());
			towerObj.setDamage(spawnerProperty.getDamage());
			//spnObj.setSpawnNum(spawnerProperty.getSpawnNum());
			System.out.println(spawnerProperty.getMaxHP());  	// test info.
			System.out.println(spawnerProperty.getDamage());	// test info.
		}
		catch (NumberFormatException nfe) {
			showAlertBox("Bad input, please input an integer number");
			return;
		}
		
		spawnerProperty.clearInput();
		
		ImageView i = new ImageView(iv.getImage());
		i.setFitWidth(spawnQueuePane.getPrefWidth() / NUMBER_COLUMN_QUEUE_PANEL);
		i.setFitHeight(spawnQueuePane.getPrefHeight() / NUMBER_ROW_QUEUE_PANEL);
		spawnQueuePane.getChildren().add(i);
		i.setOnMouseClicked(e -> handleClickEvent(e,i));
		towerObj.setImage(i);
		towerList.add(towerObj);

		System.out.println("The spawn list length is " + towerList.size());
		 
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
		towerList.remove(spawnQueuePane.getChildren().indexOf(i));
		spawnQueuePane.getChildren().remove(i);
		System.out.println("The spawn list length is " + towerList.size());
		return;
	}
	
	private GridPane createTowerIconPane() {
		GridPane towerIconPane = new GridPane();
		towerIconPane.getStyleClass().add("properties-module");
		towerIconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		//spawnQueuePane.setGridLinesVisible(true);
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
	
	private TilePane createSpawnQueueIconPane() {
		TilePane spawnQueuePane = new TilePane();
		spawnQueuePane.setPrefSize(WIDTH_QUEUE_PANEL, HEIGHT_QUEUE_PANEL);
		for (AbstractTower towerObj: towerList) {
			spawnQueuePane.getChildren().add(towerObj.getImage());
		}
		return spawnQueuePane;
	}
	
	public ArrayList<Object> getSpawnQueue()
	{
		ArrayList<Object> myList = (ArrayList<Object>) Arrays.asList(spawnQueuePane.getChildren().toArray());
		return myList;
	}

}
