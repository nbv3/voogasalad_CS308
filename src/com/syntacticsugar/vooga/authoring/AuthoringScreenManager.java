package com.syntacticsugar.vooga.authoring;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.level.LevelTabManager;
import com.syntacticsugar.vooga.authoring.library.ObjectLibraryManager;
import com.syntacticsugar.vooga.authoring.objectediting.IObjectDataClipboard;
import com.syntacticsugar.vooga.authoring.objectediting.ObjectEditor;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.GameData;
import com.syntacticsugar.vooga.xml.data.GlobalSettings;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AuthoringScreenManager implements Observer, IVoogaApp {

	private BorderPane myWindow;
	private GridPane myWindowGrid;

	private LevelTabManager myLevelEditor;
	private ObjectLibraryManager myObjectLibraryManager;
	private Stage myStage;
	private Scene myScene;
	private ObjectEditor myObjectEditor;

	public AuthoringScreenManager() {
		myObjectLibraryManager = new ObjectLibraryManager(myLevelEditor);
		myObjectEditor = new ObjectEditor(() -> myObjectLibraryManager.refresh());
		IObjectDataClipboard iObject = myObjectEditor;
		myLevelEditor = new LevelTabManager(iObject);

		initWindow();
	}

	private void initWindow() {
		myWindow = new BorderPane();
		buildMenuBar();

		myWindowGrid = new GridPane();
		addGridConstraints();

		setUpObserver();
		myWindowGrid.add(myLevelEditor.getTabPane(), 0, 0, 1, 2);
		myWindowGrid.add(myObjectLibraryManager.getView(), 1, 0, 1, 1);
		myWindowGrid.add(myObjectEditor.getView(), 1, 1, 1, 1);
		myWindow.setCenter(myWindowGrid);

		myScene = new Scene(myWindow);
		myScene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		myScene.setOnKeyPressed(e -> handleKeyPress(e));
		myStage = new Stage();
		myStage.setScene(myScene);
		// myStage.setMaximized(true);
		myStage.show();
	}

	private void setUpObserver() {
		for (int i = 0; i < myLevelEditor.getLevels().size(); i++) {
			myLevelEditor.getLevels().get(i).getTowerControls().addObserver(this);
			myLevelEditor.getLevels().get(i).getSpawnerControls().addObserver(this);

		}

		for (int i = 0; i < myObjectLibraryManager.getLibraries().size(); i++) {
			myObjectLibraryManager.getLibraries().get(i).addObserver(this);

		}
	}

	private void handleKeyPress(KeyEvent e) {
		if (e.isControlDown() && e.getCode().equals(KeyCode.N)) {
			addLevelRefresh();
		}
		if (e.getCode().equals(KeyCode.S)) {
			ObjectData data = new ObjectData();
			data.setImagePath("enemy_moster_1.png");
			data.setType(GameObjectType.TOWER);
			myObjectEditor.displayData(data);
		}
	}

	public void minimize() {
		myStage.hide();
	}

	private void addLevelRefresh() {
		myLevelEditor.addNewLevel();
		setUpObserver();
	}

	private void buildMenuBar() {
		MenuBar menuBar = new MenuBar();
		// file menu
		Menu file = new Menu();
		file.setText("File");
		MenuItem newLevel = new MenuItem();
		newLevel.setText("New Level");
		// newLevel.setOnAction(e -> myLevelEditor.addNewLevel());
		newLevel.setOnAction(e -> addLevelRefresh());

		MenuItem loadMap = new MenuItem();
		loadMap.setText("Load map");
		loadMap.setOnAction(e -> loadMap());

		MenuItem saveMap = new MenuItem();
		saveMap.setText("Save map");
		saveMap.setOnAction(e -> saveMap());

		MenuItem loadData = new MenuItem();
		loadData.setText("Load ObjectData");
		loadData.setOnAction(e -> loadData());

		MenuItem saveGame = new MenuItem();
		saveGame.setText("Save Game");
		saveGame.setOnAction(e -> saveGame());

		file.getItems().addAll(newLevel, loadMap, saveMap, loadData, saveGame);

		// menu menu
		// Menu menu = new Menu();
		// menu.setText("Menu");
		// return to main menu
		// return to authoring menu
		// MenuItem authoringMenu = new MenuItem();
		// authoringMenu.setText("Authoring Menu");
		// authoringMenu.setOnAction(e ->
		// sceneManager.launchAuthoringMenuFromAuthoring());
		// menu.getItems().addAll(mainMenu, authoringMenu);

		menuBar.getMenus().addAll(file);
		myWindow.setTop(menuBar);
	}

	private void saveGame() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game File");
		File selectedFile = fileChooser.showSaveDialog(new Stage());
		if (selectedFile != null) {

			// need to change later with global settings
			GameData game = new GameData(myLevelEditor.getAllUniverseData(), new GlobalSettings());
			XMLHandler<GameData> xml = new XMLHandler<>();
			xml.write(game, selectedFile);
		}

	}

	private void loadData() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("XML Files", "*.xml"));
		fileChooser.setInitialDirectory(new File(ResourceManager.getString("data")));
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		if (selectedFile != null) {
			myObjectEditor.setUpdateButtonViability(false);
			XMLHandler<ObjectData> xml = new XMLHandler<>();
			ObjectData toload = xml.read(selectedFile);
			myObjectEditor.displayData(toload);
		}
	}

	private void loadMap() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("XML Files", "*.xml"));
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		if (selectedFile != null) {
			XMLHandler<MapData> xml = new XMLHandler<>();
			MapData toload = xml.read(selectedFile);
			myLevelEditor.loadMap(toload);
		}
	}

	private void saveMap() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Resource File");
		File selectedFile = fileChooser.showSaveDialog(new Stage());
		if (selectedFile != null) {
			XMLHandler<MapData> xml = new XMLHandler<>();
			MapData toSave = myLevelEditor.getIndividualMapData();
			xml.write(toSave, selectedFile);
		}
	}

	private void addGridConstraints() {
		addColumnConstraints();
		addRowConstraints();
	}

	private void addColumnConstraints() {
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(75.0);
		ColumnConstraints c2 = new ColumnConstraints();
		c2.setPercentWidth(25.0);
		myWindowGrid.getColumnConstraints().addAll(c1, c2);
	}

	private void addRowConstraints() {
		RowConstraints r1 = new RowConstraints();
		r1.setPercentHeight(50);
		RowConstraints r2 = new RowConstraints();
		r2.setPercentHeight(50);

		myWindowGrid.getRowConstraints().addAll(r1, r2);
	}

	@Override
	public void update(Observable o, Object arg) {
		myObjectEditor.setTypeChooserViability(false);
		myObjectEditor.setUpdateButtonViability(true);
		myObjectEditor.displayData((ObjectData) arg);

	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
	}

}