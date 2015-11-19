package editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import objects.SpawnerObject;
import tiles.DecoratorTile;
import editor.sidepanes.SpawnerPropertyBox;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class EnemyEditor {
	
	private List<DecoratorTile> currentTileSelection;
	private List<SpawnerObject> spawnerList;	// here SpawnerTester need to change to Spawner later
	private SpawnerPropertyBox spawnerProperty;
	private VBox enemyPane;
	private TilePane spawnQueuePane;
	private ResourceBundle enemyIconBundle;
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
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

	public EnemyEditor(List<DecoratorTile> tiles) {
		currentTileSelection = tiles;
		spawnerList = new LinkedList<SpawnerObject>();	// here String need to change to Spawner later
		spawnerProperty = new SpawnerPropertyBox();
		enemyPane = new VBox();
		spawnQueuePane = createSpawnQueueIconPane();
		enemyPane.getChildren().add(createEnemyIconPane());
		enemyPane.getChildren().add(spawnerProperty.getNode());
		enemyPane.getChildren().add(createAddSpawnerButton());
		enemyPane.getChildren().add(createSpawnListPane());
	}

	private VBox createSpawnListPane() {
		VBox spawnListPane = new VBox();
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
		if (spawnerList.isEmpty()) {
			showAlertBox("No spawner added, please add at least one spawner");
			return;
		}
		
		if (currentTileSelection.isEmpty()) {
			showAlertBox("No tile selected, please slect at least one tile");
			return;
		}
		
		for (DecoratorTile t: currentTileSelection) {
			if (!t.isWalkable()) {
				showAlertBox("Spawner can only be added to path tiles");
				return;
			}
		}
		
		for (DecoratorTile t: currentTileSelection) {
			ImageView spawnIcon = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(PATH_SPAWN_ICON)));
			t.setImage(spawnIcon);
			t.setSpawnerList(spawnerList);
		}
		// need to implement later to add the final SpawnerObject list to the selected tiles
		// (code here)
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

	private void addSpawnerToQueue(ImageView iv) {
		
		SpawnerObject spnObj = new SpawnerObject();
		
		if (iv == null) {
			showAlertBox("Please select an spawner image first");
			return;
		}

		try {
			spnObj.setMaxHealth(spawnerProperty.getMaxHP());
			spnObj.setDamage(spawnerProperty.getDamage());
			spnObj.setSpawnNum(spawnerProperty.getSpawnNum());
			System.out.println(spawnerProperty.getMaxHP());  	// test info.
			System.out.println(spawnerProperty.getDamage());	// test info.
			System.out.println(spawnerProperty.getSpawnNum());	// test info.
		}
		catch (NumberFormatException nfe) {
			showAlertBox("Bad input, please input an interger number");
			return;
		}
		
		spawnerProperty.clearInput();
		
		ImageView i = new ImageView(iv.getImage());
		i.setFitWidth(spawnQueuePane.getPrefWidth() / NUMBER_COLUMN_QUEUE_PANEL);
		i.setFitHeight(spawnQueuePane.getPrefHeight() / NUMBER_ROW_QUEUE_PANEL);
		spawnQueuePane.getChildren().add(i);
		i.setOnMouseClicked(e -> handleClickEvent(e,i));
		spnObj.setImage(i);
		spawnerList.add(spnObj);

		System.out.println("The spawn list length is " + spawnerList.size());
		 
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
		spawnerList.remove(spawnQueuePane.getChildren().indexOf(i));
		spawnQueuePane.getChildren().remove(i);
		System.out.println("The spawn list length is " + spawnerList.size());
		return;
	}

	private void showAlertBox(String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(str);
		alert.showAndWait();
	}
	
	private GridPane createEnemyIconPane() {
		GridPane enemyIconPane = new GridPane();
		enemyIconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		//spawnQueuePane.setGridLinesVisible(true);
		enemyIconBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "EnemyIcon");
		String[] enemyIconPath = enemyIconBundle.getString("Enemy").split(",");	
		enemyIconPane.getChildren().clear();
		for (int i = 0; i < enemyIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(enemyIconPath[i])));
			
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
			
			img.setFitWidth(enemyIconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(enemyIconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			enemyIconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		return enemyIconPane;
	}
	
	private TilePane createSpawnQueueIconPane() {
		TilePane spawnQueuePane = new TilePane();
		spawnQueuePane.setPrefSize(WIDTH_QUEUE_PANEL, HEIGHT_QUEUE_PANEL);
		for (SpawnerObject sObj: spawnerList) {
			spawnQueuePane.getChildren().add(sObj.getImage());
		}
		return spawnQueuePane;
	}
	
	public ArrayList<Object> getSpawnQueue()
	{
		ArrayList<Object> myList = (ArrayList<Object>) Arrays.asList(spawnQueuePane.getChildren().toArray());
		return myList;
	}
	
	
	public VBox getNode() {
		return enemyPane;
	}

}
