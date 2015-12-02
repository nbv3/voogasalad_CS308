package authoring;

import java.io.File;

import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.menu.SceneManager;

import authoring.data.MapData;
import authoring.data.ObjectData;
import authoring.level.LevelTabManager;
import authoring.library.ObjectLibrary;
import authoring.library.AuthoringSidePane;
import authoring.objectediting.ObjectEditor;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import xml.MapDataXML;
import xml.ObjectDataXML;

public class AuthoringScreenManager {

	private BorderPane myWindow;
	private GridPane myWindowGrid;

	private LevelTabManager myLevelEditor;
	//	private LibraryManager myLibraryManager;
	private Stage myStage;
	private Scene myScene;
	//private ObjectLibrary myObjectLibrary;
	private ObjectEditor myObjectEditor;
//	private AuthoringSidePane myObjectManager;

	// injected for returning to main menu
	private SceneManager sceneManager;

	public AuthoringScreenManager() {
		myLevelEditor = new LevelTabManager();
//		myObjectLibrary = new ObjectLibrary();
		myObjectEditor = new ObjectEditor();
		initWindow();
	}

//	private void initObjectLibrary() {
		//		myObjectLibrary = new ObjectLibrary(null);
//		myObjectManager = new AuthoringSidePane(null);
//	}


	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	private void initWindow() {
		myWindow = new BorderPane();
		buildMenuBar();

		myWindowGrid = new GridPane();
		myWindowGrid.setGridLinesVisible(true);
		addGridConstraints();

		myWindowGrid.add(myLevelEditor.getTabPane(), 0, 0, 1, 2);
//		myWindowGrid.add(myObjectManager.getLibrary(), 1, 0, 1 ,1);
		myWindowGrid.add(myObjectEditor.getView(), 1, 1, 1, 1);
		myWindow.setCenter(myWindowGrid);

		myScene = new Scene(myWindow);
		myScene.setOnKeyPressed(e -> handleKeyPress(e));
		myStage = new Stage();
		myStage.setOnCloseRequest(e -> sceneManager.launchFirstMenuFromAuthoring());
		myStage.setScene(myScene);
		myStage.setMaximized(true);
		myStage.show();
	}

	private void handleKeyPress(KeyEvent e) {
		if (e.isControlDown() && e.getCode().equals(KeyCode.N)) {
			myLevelEditor.addNewLevel();
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

	private void buildMenuBar() {
		MenuBar menuBar = new MenuBar();
		// file menu
		Menu file = new Menu();
		file.setText("File");
		MenuItem newLevel = new MenuItem();
		newLevel.setText("New Level");
		newLevel.setOnAction(e -> myLevelEditor.addNewLevel());

		MenuItem loadMap = new MenuItem();
		loadMap.setText("Load map");
		loadMap.setOnAction(e -> loadMap());
		
		MenuItem saveMap = new MenuItem();
		saveMap.setText("Save map");
		saveMap.setOnAction(e -> saveMap());

		MenuItem loadData = new MenuItem();
		loadData.setText("Load ObjectData");
		loadData.setOnAction(e -> loadData());
		
		file.getItems().addAll(newLevel, loadMap, saveMap, loadData);

		// menu menu
		//		Menu menu = new Menu();
		//		menu.setText("Menu");
		// return to main menu
		// return to authoring menu
		//		MenuItem authoringMenu = new MenuItem();
		//		authoringMenu.setText("Authoring Menu");
		//		authoringMenu.setOnAction(e -> sceneManager.launchAuthoringMenuFromAuthoring());
		//		menu.getItems().addAll(mainMenu, authoringMenu);

		menuBar.getMenus().addAll(file);
		myWindow.setTop(menuBar);
	}

	private void loadData() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("XML Files", "*.xml"));
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		if (selectedFile != null) {
			ObjectDataXML xml = new ObjectDataXML();
			ObjectData toload = xml.loadFromFile(selectedFile);
			System.out.println(toload);
			System.out.println(toload.getAttributes());
			myObjectEditor.displayData(toload);
		}
	}
	
	private void loadMap() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("XML Files", "*.xml"));
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		if (selectedFile != null) {
			MapDataXML xml = new MapDataXML();
			MapData toload = xml.loadFromFile(selectedFile);
			myLevelEditor.loadMap(toload);
		}
	}
	
	private void saveMap() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Resource File");
		File selectedFile = fileChooser.showSaveDialog(new Stage());
		if (selectedFile != null) {
			MapDataXML xml = new MapDataXML();
			MapData toSave = myLevelEditor.getMapData();
			String xmlString = xml.generateXML(toSave);
			xml.writeXMLToFile(xmlString, selectedFile);
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

}