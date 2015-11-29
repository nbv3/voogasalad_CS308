package authoring;

import com.syntacticsugar.vooga.menu.SceneManager;

import authoring.level.LevelTabManager;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class AuthoringScreenManager {

	private BorderPane myWindow;
	private GridPane myWindowGrid;
	
	private LevelTabManager myLevelEditor;
//	private LibraryManager myLibraryManager;
	private Stage myStage;
	private Scene myScene;
	
	// injected for returning to main menu
	private SceneManager sceneManager;
	
	public AuthoringScreenManager() {
		initLevelEditor();
		initObjectLibrary();
		initWindow();
	}
	
	private void initObjectLibrary() {
		// TODO Auto-generated method stub
		
	}
	
	public void setSceneManager(SceneManager sceneManager) {
		this.sceneManager = sceneManager;
	}

	private void initWindow() {
		myWindow = new BorderPane();
		buildMenuBar();
		
		myWindowGrid = new GridPane();
		myWindowGrid.setGridLinesVisible(true);
		addGridConstraints();
		
		myWindowGrid.add(myLevelEditor.getTabPane(), 0, 0, 1, 3);
		
		myWindow.setCenter(myWindowGrid);
		
		myScene = new Scene(myWindow);
		myStage = new Stage();
		myStage.setScene(myScene);
		myStage.setMaximized(true);
		myStage.show();
	}
	
	public void minimize() {
		myStage.hide();
	}
	
	private void buildMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu();
		file.setText("File");
		MenuItem newLevel = new MenuItem();
		newLevel.setText("New Level");
		newLevel.setOnAction(e -> myLevelEditor.addNewLevel());
		// return to main menu
		MenuItem mainMenu = new MenuItem();
		mainMenu.setText("Main Menu");
		mainMenu.setOnAction(e -> sceneManager.initFirstGameMenuAuthoring());
		// return to authoring menu
		MenuItem authoringMenu = new MenuItem();
		authoringMenu.setText("Authoring Menu");
		authoringMenu.setOnAction(e -> sceneManager.initAuthoringGameMenuAuthoring());
		
		file.getItems().addAll(newLevel, mainMenu, authoringMenu);
		
		menuBar.getMenus().add(file);
		myWindow.setTop(menuBar);
	}
	
	private void initLevelEditor() {
		myLevelEditor = new LevelTabManager();
		myLevelEditor.addNewLevel();
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