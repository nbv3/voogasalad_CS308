package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import editor.sidepanes.EditorTab;
import editor.sidepanes.EditorTabPane;
import environment.GameMap;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tiles.DecoratorTile;

public class AuthoringEnvironment implements Observer {

	private Stage myStage;
	private Scene myScene;
	private BorderPane myWindow;
	private MenuBar myMainMenu;
	//private LevelToolBar myLevelMenu;
	private GridPane myMapDisplay;
	private EditorTabPane editor;
	private List<DecoratorTile> myTileSelection;
	private GameMap myMap;

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
		myScene = new Scene(myWindow);
		myScene.getStylesheets().add("css/default.css");
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

	private GridPane createMapDisplay() {
		GridPane gp = new GridPane();
		gp.setPrefSize(800, 800);
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
		i.setOnMouseClicked(e -> toggleTileSelection(tile));
		i.setFitWidth(gp.getPrefWidth() / (new Double(myMap.getMapSize())));
		i.setFitHeight(gp.getPrefHeight() / (new Double(myMap.getMapSize())));
		return i;
	}

	private void toggleTileSelection(DecoratorTile t) {
		if (myTileSelection.contains(t)) {
			myTileSelection.remove(t);
			tileOpacityOff(t);
		} else {
			myTileSelection.add(t);
			tileOpacityOn(t);
		}
		System.out.println(t.getImplementation().getClass().getName());
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
		t.getView().getStyleClass().add("tile-select-on");
		t.getView().getStyleClass().remove("tile-select-off");
	}

	private void refreshMapDisplay() {
		myMapDisplay.getChildren().clear();
		for (DecoratorTile tile : myMap.getTileMap().values()) {
			ImageView i = tile.getView();
			i.setOnMouseClicked(e -> toggleTileSelection(tile));
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
