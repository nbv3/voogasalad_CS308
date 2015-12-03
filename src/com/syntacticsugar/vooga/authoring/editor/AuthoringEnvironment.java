package com.syntacticsugar.vooga.authoring.editor;

import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.authoring.editor.sidepanes.EditorTab;
import com.syntacticsugar.vooga.authoring.editor.sidepanes.EditorTabPane;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.view.ViewController;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AuthoringEnvironment {

	private Stage myStage;
	private Scene myScene;
	private BorderPane myWindow;
	private MenuBar myMainMenu;
	//private LevelToolBar myLevelMenu;
	//private GameView myMapDisplay;
	private EditorTabPane editor;
	private List<DecoratorTile> myTileSelection;
	private IGameMap myMap;
	private final double DEFAULT_MAP_SIZE = 800;
	private final int DEFAULT_NUM_TILES = 20;
	private ViewController myViewController;
	private String imageFileName = "enemy_ghost_1.png";


	public AuthoringEnvironment() {
		myMap = new GameMap(DEFAULT_MAP_SIZE,DEFAULT_NUM_TILES);
		myViewController = new ViewController(DEFAULT_MAP_SIZE, DEFAULT_MAP_SIZE);
		myTileSelection = new ArrayList<>();
		myStage = initializeStage();
		myStage.setTitle("Authoring Environment");
		myStage.show();
	}

	private Stage initializeStage() {
		myWindow = new BorderPane();
		myMainMenu = createMenuBar();
		myWindow.setTop(myMainMenu);
		myWindow.setLeft(new ToolbarOptions(myTileSelection, myMap, myViewController));
		createMapDisplay();
		myWindow.setCenter(myViewController.getGameView());
		createEditorTabPane();
		myWindow.setRight(editor);
		myScene = new Scene(myWindow);
		myScene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		Stage stage = new Stage();
		stage.setScene(myScene);
		stage.setMaximized(true);
		return stage;
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

	private void createMapDisplay() {
		for (int i = 0; i < myMap.getTiles().length; i++) {
			for (int j = 0; j < myMap.getTiles()[0].length; j++) {
				DecoratorTile tile = (DecoratorTile) myMap.getTiles()[i][j];
				myViewController.addViewObject(tile);
				
				ImageView img = myViewController.getViewMap().get(tile).getImageView();
				img.setOnMouseClicked(e -> toggleTileSelection(tile, e));
				img.setOnMouseEntered(e -> multiSelectTile(tile, e));
				img.setOnDragOver(new EventHandler<DragEvent>() {
				    public void handle(DragEvent event) {
				        /* data is dragged over the target */
				        /* accept it only if it is not dragged from the same node 
				         * and if it has a string data */
				    		Dragboard db = event.getDragboard();
				    		System.out.println(db);
				            /* allow for both copying and moving, whatever user chooses */
				        	System.out.println("Tile is ready to accept dragged object");
				            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

				     
				        event.consume();
				    }
				});
				
				img.setOnDragEntered(new EventHandler<DragEvent>() {
				    public void handle(DragEvent event) {
				    /* the drag-and-drop gesture entered the target */
				    /* show to the user that it is an actual gesture target */

			            if (event.getGestureSource() != img &&
		                        event.getDragboard().hasString()) {
		                    img.setOpacity(0);
		                }
		                
				    }
				});
				
				img.setOnDragExited(new EventHandler<DragEvent>(){

					@Override
					public void handle(DragEvent event) {
						// TODO Auto-generated method stub
						if (event.getGestureSource() != img &&
		                        event.getDragboard().hasString()) {
						img.setOpacity(1);
						}
						
					}
					
				});
				img.setOnDragDropped(new EventHandler<DragEvent>() {
				    public void handle(DragEvent event) {
				        /* data dropped */
				        /* if there is a string data on dragboard, read it and use it */
				        Dragboard db = event.getDragboard();
				        boolean success = false;
				        if (db.hasString()) {
				        	img.setOpacity(1);
				           img.setImage(new Image(getClass().getClassLoader().getResourceAsStream(db.getString())));
				           success = true;
				        }
				        /* let the source know whether the string was successfully 
				         * transferred and used */
				        event.setDropCompleted(success);
				        
				        event.consume();
				     }
				});

			}
		}
	}
	
	private void createEditorTabPane() {
		EditorTab levelTab = new EditorTab();
		
		levelTab.setContent(new VBox());	//need to be modified to the level related content
		levelTab.setTabDescription("Level Settings");

		EditorTab tileTab = new EditorTab();
		tileTab.setContent(new TileEditor(myViewController, myTileSelection));
		tileTab.setTabDescription("Tile Settings");

		EditorTab enemyEditorTab = new EditorTab();

		enemyEditorTab.setContent(new GameObjectEditor());
		enemyEditorTab.setTabDescription("Game Object");
	
		editor = new EditorTabPane(levelTab, tileTab, enemyEditorTab);
	}
	
	private void multiSelectTile(DecoratorTile tile, MouseEvent e) {
		if (e.isControlDown())
			toggleTileSelection(tile, e);
	}


	private void toggleTileSelection(DecoratorTile t, MouseEvent e) {
		//System.out.println(t.getImplementation().getClass().getName());
		if (myTileSelection.contains(t)) {
			myTileSelection.remove(t);
			tileOpacityOff(t);
		} else {
			myTileSelection.add(t);
			tileOpacityOn(t);
		}
	}

	private void tileOpacityOff(DecoratorTile t) {
		myViewController.getViewMap().get(t).getImageView().getStyleClass().add("tile-select-off");
		myViewController.getViewMap().get(t).getImageView().getStyleClass().remove("tile-select-on");
	}

	private void tileOpacityOn(DecoratorTile t) {
		myViewController.getViewMap().get(t).getImageView().getStyleClass().add("tile-select-on");
		myViewController.getViewMap().get(t).getImageView().getStyleClass().remove("tile-select-off");
	}

}
