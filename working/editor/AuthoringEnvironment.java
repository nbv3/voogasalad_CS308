package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


import editor.sidepanes.EditorTab;
import editor.sidepanes.EditorTabPane;
import editor.sidepanes.PropertiesPane;
import editor.sidepanes.SpawnerPropertyBox;
import environment.GameMap;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tiles.DecoratorTile;

public class AuthoringEnvironment implements Observer {

	private Stage myStage;
	private Scene myScene;
	private BorderPane myWindow;
	private MenuBar myMainMenu;
	//private LevelToolBar myLevelMenu;
	private GridPane myMapDisplay;
	private EditorTabPane editor;
	private PropertiesPane myPropertyPane;
	private List<DecoratorTile> myTileSelection;
	private GameMap myMap;
	private boolean isEditorPane;

	public AuthoringEnvironment() {
		myMap = new GameMap();
		myTileSelection = new ArrayList<>();
		myStage = initializeStage();
		myStage.show();
	}

	private Stage initializeStage() {
		//VBox menus = new VBox();
		myMainMenu = createMenuBar();
		myMapDisplay = createMapDisplay();
		myWindow = new BorderPane();
		myWindow.setTop(myMainMenu);
		myWindow.setLeft(new ToolbarOptions(myTileSelection, myMap));
		myWindow.setCenter(myMapDisplay);
		EditorTab levelTab = new EditorTab();
		setPropertyPane();
		levelTab.setContent(new VBox());
		levelTab.setTabDescription("Level Settings");
		
		EditorTab tileTab = new EditorTab();
		tileTab.setContent(new TileEditor(myTileSelection).getEditorPane());
		tileTab.setTabDescription("Tile Settings");
		
		EditorTab enemyEditorTab = new EditorTab();
		enemyEditorTab.setContent(new EnemyEditor(myTileSelection).getNode());
		enemyEditorTab.setTabDescription("Spawners");
		
		EditorTab towerTab = new EditorTab();
		towerTab.setContent(new TowerEditor().getNode());
		towerTab.setTabDescription("Towers");
		
		editor = new EditorTabPane(levelTab, 
								   tileTab, 
								   enemyEditorTab, 
								   towerTab);
		
		myWindow.setRight(editor.getPaneNode());
		isEditorPane = true;
		myScene = new Scene(myWindow);
		myScene.getStylesheets().add("css/default.css");
		Stage stage = new Stage();
		stage.setScene(myScene);
		//stage.setMaximized(true);
		return stage;
	}

	private void setPropertyPane() {
		myPropertyPane = new PropertiesPane();
		SpawnerPropertyBox healthBox = new SpawnerPropertyBox();
		Button OkButton = new Button("OK");
		myPropertyPane.addChildren(OkButton);
		myPropertyPane.addChildren(healthBox.getNode());
		healthBox.getNode().setLayoutX(-100);
		healthBox.getNode().setLayoutY(100);
		OkButton.setLayoutX(-100);
		OkButton.setLayoutY(200);
	}

	private MenuBar createMenuBar() {
		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");

		MenuItem loadMenu = new MenuItem("Load");
		//loadMenu.setOnAction(e -> loadStuffs());

		MenuItem saveMenu = new MenuItem("Save");
		//saveMenu.setOnAction(e -> saveStuffs());
		file.getItems().addAll(loadMenu, saveMenu);
		mb.getMenus().add(file);
		return mb;
	}

	private GridPane createMapDisplay() {
		GridPane gp = new GridPane();
		gp.setPrefSize(700, 700);
		for (Point p : myMap.getTileMap().keySet()) {
			DecoratorTile tile = myMap.getTile(p);
			tile.addObserver(this);
			ImageView i = createTileCell(gp, tile);
			gp.add(i, (int) p.getX(), (int) p.getY(), 1, 1);
		}
		return gp;
	}

	private ImageView createTileCell(GridPane gp, DecoratorTile tile) {
		ImageView i = tile.getView();
		i.setOnMouseClicked(e -> toggleTileSelection(tile, e));
		i.setFitWidth(gp.getPrefWidth() / (new Double(myMap.getMapSize())));
		i.setFitHeight(gp.getPrefHeight() / (new Double(myMap.getMapSize())));
		return i;
	}

	private void toggleTileSelection(DecoratorTile t, MouseEvent e) {
		if(e.getButton() == MouseButton.SECONDARY)
		{
			ContextMenu menu = new ContextMenu();
			menu.getStyleClass().add("context-menu");
			MenuItem item = new MenuItem("Display Properties");
			MenuItem second = new MenuItem("Edit Properties");
			second.setOnAction(e1 -> changeToPropertyPane());
			MenuItem third = new MenuItem("Add Object");
			third.setOnAction(e2 -> changeToEditorPane());
			menu.getItems().addAll(item, second, third);
			menu.setAnchorX(e.getSceneX());
			menu.setAnchorY(e.getSceneY());
			menu.show(myStage);

		}
		else
		{
			if (myTileSelection.contains(t)) {
				myTileSelection.remove(t);
				tileOpacityOff(t);
			} else {
				myTileSelection.add(t);
				tileOpacityOn(t);
			}
			System.out.println(t.getImplementation().getClass().getName());
		}
		
	}
	
	private void changeToPropertyPane()
	{
		if(isEditorPane)
		{

			 FadeTransition ftOut = new FadeTransition(Duration.millis(300),myWindow.getRight());
		     ftOut.setFromValue(1.0);
		     ftOut.setToValue(0);
		     ftOut.setCycleCount(1);
		     ftOut.setAutoReverse(false);
		     ftOut.play();
		     ftOut.setOnFinished(e -> fadeInPropertiesPane());
//		     ftOut.setOnFinished(new EventHandler<ActionEvent>() {
//		    	    @Override
//		    	    public void handle(ActionEvent event) {
//		    	    myPropertyPane.getPane().setOpacity(0);
//		    	    myWindow.setRight(myPropertyPane.getPane());
//		    	    
//		    		FadeTransition ftIn = new FadeTransition(Duration.millis(300),myPropertyPane.getPane());
//		    		ftIn.setFromValue(0);
//		    		ftIn.setToValue(1.0);
//		    		ftIn.setCycleCount(1);
//		    		ftIn.setAutoReverse(false);
//		    		ftIn.play();	
//
//		   		     isEditorPane = false;
//		    	    }
//		    	});

		}
		createNextScene();
	}
	
	private void fadeInPropertiesPane(){
	    myPropertyPane.getPane().setOpacity(0);
	    myWindow.setRight(myPropertyPane.getPane());
	    
		FadeTransition ftIn = new FadeTransition(Duration.millis(300),myPropertyPane.getPane());
		ftIn.setFromValue(0);
		ftIn.setToValue(1.0);
		ftIn.setCycleCount(1);
		ftIn.setAutoReverse(false);
		ftIn.play();	

		isEditorPane = false;
	}
	
	private void changeToEditorPane()
	{
		if(!isEditorPane)
		{
			myWindow.setRight(editor.getPaneNode());
			isEditorPane = true;
		}
		createNextScene();
	}
	
	private void createNextScene() {
		Scene nextScene = new Scene(myWindow);
		nextScene.getStylesheets().add("css/default.css");
		myStage.setScene(nextScene);
	}

	/**
	 * @param t
	 */
	private void tileOpacityOff(DecoratorTile t) {
		t.getView().getStyleClass().add("tile-select-off");
		t.getView().getStyleClass().remove("tile-select-on");
	}

	/**
	 * @param t
	 */
	private void tileOpacityOn(DecoratorTile t) {
		t.getView().getStyleClass().remove("tile-select-off");
		t.getView().getStyleClass().add("tile-select-on");
	}

	private void refreshMapDisplay() {
		myMapDisplay.getChildren().clear();
		for (DecoratorTile tile : myMap.getTileMap().values()) {
			ImageView i = tile.getView();
			i.setOnMouseClicked(e -> toggleTileSelection(tile, e));
			i.setFitWidth(myMapDisplay.getPrefWidth() / (new Double(myMap.getMapSize())));
			i.setFitHeight(myMapDisplay.getPrefHeight() / (new Double(myMap.getMapSize())));
			myMapDisplay.add(tile.getView(), (int) tile.getPoint().getX(), (int) tile.getPoint().getY(),1,1);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		refreshMapDisplay();
	}

}
