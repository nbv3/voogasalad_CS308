package com.syntacticsugar.vooga.authoring.editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.editor.sidepanes.EditorTab;
import com.syntacticsugar.vooga.authoring.editor.sidepanes.EditorTabPane;
import com.syntacticsugar.vooga.authoring.editor.sidepanes.TilePropertyPane;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.scene.Scene;
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

public class AuthoringEnvironment implements Observer {

	private Stage myStage;
	private Scene myScene;
	private BorderPane myWindow;
	private MenuBar myMainMenu;
	//private LevelToolBar myLevelMenu;
	private GridPane myMapDisplay;
	private EditorTabPane editor;
	private List<DecoratorTile> myTileSelection;
	private IGameMap myMap;
	private boolean isEditorPane;

	public AuthoringEnvironment() {
//		myMap = new GameMap();
		myTileSelection = new ArrayList<>();
		myStage = initializeStage();
		myStage.show();
	}

	private Stage initializeStage() {
		myMainMenu = createMenuBar();
		myMapDisplay = createMapDisplay();
		myWindow = new BorderPane();
		myWindow.setTop(myMainMenu);
//		myWindow.setLeft(new ToolbarOptions(myTileSelection, myMap));
		myWindow.setCenter(myMapDisplay);
		EditorTab levelTab = new EditorTab();
		//setPropertyPane();
		levelTab.setContent(new VBox());
		levelTab.setTabDescription("Level Settings");
		
		EditorTab tileTab = new EditorTab();
		tileTab.setContent(new TileEditor(myTileSelection).getEditorPane());
		tileTab.setTabDescription("Tile Settings");
		
		EditorTab enemyEditorTab = new EditorTab();
		enemyEditorTab.setContent(new EnemyEditor(myTileSelection).getNode());
		enemyEditorTab.setTabDescription("Spawners");
		
		EditorTab towerTab = new EditorTab();
//		towerTab.setContent(new TowerEditor(myTileSelection).getNode());
		towerTab.setTabDescription("Towers");
		
		editor = new EditorTabPane(levelTab, 
								   tileTab, 
								   enemyEditorTab, 
								   towerTab);
		
		myWindow.setRight(editor.getPaneNode());
		isEditorPane = true;
		myScene = new Scene(myWindow);
		myScene.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		Stage stage = new Stage();
		stage.setScene(myScene);
		//stage.setMaximized(true);
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

	private GridPane createMapDisplay() {
		GridPane gp = new GridPane();
		gp.setPrefSize(700, 700);
//		for (Point p : myMap.getTileMap().keySet()) {
//			DecoratorTile tile = myMap.getTile(p);
//			tile.addObserver(this);
//			ImageView i = createTileCell(gp, tile);
//			gp.add(i, (int) p.getX(), (int) p.getY(), 1, 1);
//		}
		return gp;
	}

	private ImageView createTileCell(GridPane gp, DecoratorTile tile) {
		ImageView i = null;
//		ImageView i = tile.getView();
//		i.setOnMouseClicked(e -> toggleTileSelection(tile, e));
//		i.setFitWidth(gp.getPrefWidth() / (new Double(myMap.getMapSize())));
//		i.setFitHeight(gp.getPrefHeight() / (new Double(myMap.getMapSize())));
		return i;
	}

	private void toggleTileSelection(DecoratorTile t, MouseEvent e) {
		if (e.getButton() == MouseButton.SECONDARY) {
			ContextMenu menu = new ContextMenu();
			menu.getStyleClass().add("context-menu");
			MenuItem editMenu = new MenuItem("Edit");
			editMenu.setOnAction(e1 -> changeToPropertyPane());
			MenuItem addMenu = new MenuItem("Add Object");
			addMenu.setOnAction(e2 -> changeToEditorPane());
			menu.getItems().addAll(editMenu, addMenu);
			menu.setAnchorX(e.getSceneX());
			menu.setAnchorY(e.getSceneY());
			menu.show(myStage);
		}
		else {
			if (myTileSelection.contains(t)) {
				myTileSelection.remove(t);
				tileOpacityOff(t);
			} else {
				myTileSelection.add(t);
				tileOpacityOn(t);
			}
		}
	}
	
	private void changeToPropertyPane() {
		if (myTileSelection.size() == 0) {
			new AlertBoxFactory().createObject("Please select a tile first");
			return;
		}
	
		if (myTileSelection.size() > 1) {
			new AlertBoxFactory().createObject("Cannot view properties for multiple tiles");
			return;
		}
		
		//if (isEditorPane) {
//			myWindow.setRight(new TilePropertyPane(myTileSelection).getPaneNode());
			isEditorPane = false;
		//}
	}
	
	private void changeToEditorPane() {
		if (!isEditorPane) {
			myWindow.setRight(editor.getPaneNode());
			isEditorPane = true;
		}
	}

	/**
	 * @param t
	 */
	private void tileOpacityOff(DecoratorTile t) {
//		t.getView().getStyleClass().add("tile-select-off");
//		t.getView().getStyleClass().remove("tile-select-on");
	}

	/**
	 * @param t
	 */
	private void tileOpacityOn(DecoratorTile t) {
//		t.getView().getStyleClass().remove("tile-select-off");
//		t.getView().getStyleClass().add("tile-select-on");
	}

	private void refreshMapDisplay() {
		myMapDisplay.getChildren().clear();
//		for (DecoratorTile tile : myMap.getTileMap().values()) {
//			ImageView i = tile.getView();
//			i.setOnMouseClicked(e -> toggleTileSelection(tile, e));
//			i.setFitWidth(myMapDisplay.getPrefWidth() / (new Double(myMap.getMapSize())));
//			i.setFitHeight(myMapDisplay.getPrefHeight() / (new Double(myMap.getMapSize())));
//			myMapDisplay.add(tile.getView(), (int) tile.getPoint().getX(), (int) tile.getPoint().getY(),1,1);
//		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		refreshMapDisplay();
	}

}