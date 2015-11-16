package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import editor.sidepanes.EditorTabPane;
import engine.environment.GameMap;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tiles.DecoratorTile;

public class AuthoringEnvironment implements Observer {
	
	private Stage myStage;
	private Scene myScene;
	private BorderPane myWindow;
	private MenuBar myMenu;
	private GridPane myMapDisplay;
	private TileEditor myTileEditor;
	
	private List<DecoratorTile> myTileSelection;
	//private VBox myEditDisplay;
	
	private GameMap myMap;

	public AuthoringEnvironment(){
		myMap = new GameMap();
		myTileSelection = new ArrayList<>();
		myStage = initializeStage();
		myStage.show();
	}

	private Stage initializeStage() {
		myMenu = createMenuBar();
		myMapDisplay = createMapDisplay();
		myWindow = new BorderPane();
		myWindow.setTop(myMenu);
		myWindow.setCenter(myMapDisplay);		
		myScene = new Scene(myWindow);
		Stage stage = new Stage();
		stage.setScene(myScene);
		stage.setMaximized(true);
		return stage;
	}

	private MenuBar createMenuBar() {
		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");
		
		MenuItem editTiles = new MenuItem("Edit Tiles");
		editTiles.setOnAction(e -> openTileSettingsDialog(myTileSelection));
		
		MenuItem clear = new MenuItem("Clear Selection");
		clear.setOnAction(e -> clearTileSelection());
		
		MenuItem selectAll = new MenuItem("Select All");
		selectAll.setOnAction(e -> addAllTiles());
		
		file.getItems().addAll(editTiles, selectAll, clear);
		mb.getMenus().add(file);
		return mb;	
	}
	
	private void addAllTiles() {
		myTileSelection.clear();
		for (DecoratorTile tile: myMap.getTileMap().values()) {
			toggleTileSelection(tile);
		}
	}
	
	private GridPane createMapDisplay() {
		GridPane gp = new GridPane();
//		gp.setPrefSize(800, 800);
////		addConstraints(gp);
//		//Populate gridpane
//		for (Point2D p: myMap.getTileMap().keySet()) {
//			DecoratorTile tile = myMap.getTile(p);
//			tile.registerObserver(this);
//			ImageView i = tile.getView();
//			i.setOnMouseClicked(e -> toggleTileSelection(tile));
//			i.setFitWidth(gp.getPrefWidth() / (new Double(myMap.getMapSize())));
//			i.setFitHeight(gp.getPrefHeight() / (new Double(myMap.getMapSize())));
//			gp.add(i, (int) p.getX(), (int) p.getY(), 1, 1);
//		}
		return gp;
	}
	
	private void toggleTileSelection(DecoratorTile t) {
//		if (myTileSelection.contains(t)) {
//			myTileSelection.remove(t);
//			t.getView().setOpacity(1);
//		}
//		else {
//			myTileSelection.add(t);
//			t.getView().setOpacity(0.75);
//		}
	}
	
	private void openTileSettingsDialog(List<DecoratorTile> tiles) {
		myTileEditor = new TileEditor(tiles);
		myWindow.setRight(myTileEditor.getEditorPane());
	}

	private void refreshMapDisplay() {
//		myMapDisplay.getChildren().clear();
//		for (DecoratorTile tile: myMap.getTileMap().values()) {
//			ImageView i = tile.getView();
//			i.setOnMouseClicked(e -> toggleTileSelection(tile));
//			i.setFitWidth(myMapDisplay.getPrefWidth() / (new Double(myMap.getMapSize())));
//			i.setFitHeight(myMapDisplay.getPrefHeight() / (new Double(myMap.getMapSize())));
//			myMapDisplay.add(tile.getView(), (int) tile.getPoint().getX(), (int) tile.getPoint().getY()); 
//		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		refreshMapDisplay();
	}

	public void clearTileSelection() {
//		for (DecoratorTile tile: myTileSelection) {
//			tile.getView().setOpacity(1);
//		}
//		myTileSelection.clear();
//		myWindow.setRight(null);
	}
	
}
