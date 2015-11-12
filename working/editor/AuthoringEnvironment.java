package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import environment.GameMap;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tiles.AbstractGameTile;
import tiles.IGameTile;
import tiles.implementations.DecoratorTile;
import tiles.implementations.PathTile;
import tiles.implementations.SceneryTile;

public class AuthoringEnvironment {
	
	private Stage myStage;
	private Scene myScene;
	private BorderPane myWindow;
	private MenuBar myMenu;
	private GridPane myMapDisplay;
	//private VBox myEditDisplay;
	
	private GameMap myMap;

	public AuthoringEnvironment(){
		myMap = new GameMap();
		myStage = initializeStage();
		myStage.show();
	}

	private Stage initializeStage() {
		myMenu = createMenuBar();
		myMapDisplay = createMapDisplay();
		//myEditDisplay = createEditDisplay();
		
		myWindow = new BorderPane();
		myWindow.setTop(myMenu);
		myWindow.setCenter(myMapDisplay);
		//window.setRight(myEditDisplay);
		
		myScene = new Scene(myWindow);
		Stage stage = new Stage();
		stage.setScene(myScene);
		stage.setMaximized(true);
		return stage;
	}

	private MenuBar createMenuBar() {
		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");
		mb.getMenus().add(file);
		return mb;	
	}
	
	private GridPane createMapDisplay() {
		GridPane gp = new GridPane();
		// For some reason, using round numbers like 600 causes the imageview to get scaled to 0 when 
		// dividing by 10 in the next part. Any non-round double (ie. 600.1) fixes the problem
		gp.setPrefSize(600.1, 600.1);
//		addConstraints(gp);
		//Populate gridpane
		for (Point p: myMap.getTileMap().keySet()) {
			DecoratorTile tile = myMap.getTile(p);
			ImageView i = tile.getView();
			i.setOnMouseClicked(e -> openTileSettingsDialog(tile));
			i.setFitWidth(gp.getPrefWidth() / (new Double(myMap.getMapSize())));
			i.setFitHeight(gp.getPrefHeight() / (new Double(myMap.getMapSize())));
			gp.add(i, (int) p.getX(), (int) p.getY(), 1, 1);
		}
		return gp;
	}
	
	private void openTileSettingsDialog(DecoratorTile tile) {
//		Node editSettings = gt.getEditView(gt);
		// Set this node to be viewed in the right hand side of the authoring environment
		System.out.println(String.format("%s : Is walkable? %s", tile.toString(), tile.isWalkable()));
		if (tile.isWalkable())
			tile.setImplementation(new SceneryTile(tile));
		else
			tile.setImplementation(new PathTile(tile));
		
		TileEditor tileEditor = new TileEditor(tile);
		myWindow.setRight(tileEditor.getEditorPane());
//		updateGridView(gt);
	}
	
//	private void addConstraints(GridPane gp) {
//		List<ColumnConstraints> ccon = new ArrayList<ColumnConstraints>();
//		List<RowConstraints> rcon = new ArrayList<RowConstraints>();
//		
//		gp.setMaxHeight(300);
//		gp.setMaxWidth(300);
//		
//		for (int i=0; i<myMap.getMapSize(); i++) {
//			ColumnConstraints c = new ColumnConstraints();
//			c.setPercentWidth(1.0 / myMap.getMapSize());
//			RowConstraints r = new RowConstraints();
//			r.setPercentHeight(1.0 / myMap.getMapSize());
//			
//			ccon.add(c);
//			rcon.add(r);
//		}
//		gp.getColumnConstraints().addAll(ccon);
//		gp.getRowConstraints().addAll(rcon);
//	}	
}
