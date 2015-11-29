package authoring;

import authoring.level.LevelTabManager;
import authoring.library.ObjectLibrary;
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
	private ObjectLibrary myObjectLibrary;
	
	public AuthoringScreenManager() {
		initLevelEditor();
		initObjectLibrary();
		initWindow();
	}
	
	private void initObjectLibrary() {
		myObjectLibrary = new ObjectLibrary(null);
		
	}

	private void initWindow() {
		myWindow = new BorderPane();
		buildMenuBar();
		
		myWindowGrid = new GridPane();
		myWindowGrid.setGridLinesVisible(true);
		addGridConstraints();
		
		myWindowGrid.add(myLevelEditor.getTabPane(), 0, 0, 1, 3);
		myWindowGrid.add(myObjectLibrary.getContent(), 1, 0, 1 ,1);
		myWindow.setCenter(myWindowGrid);
		
		myScene = new Scene(myWindow);
		myStage = new Stage();
		myStage.setScene(myScene);
		myStage.setMaximized(true);
		myStage.show();
	}
	
	private void buildMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu();
		file.setText("File");
		MenuItem newLevel = new MenuItem();
		newLevel.setText("New Level");
		newLevel.setOnAction(e -> myLevelEditor.addNewLevel());
		
		file.getItems().add(newLevel);
		
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