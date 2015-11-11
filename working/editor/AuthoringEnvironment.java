package editor;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import environment.GameMap;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import tiles.AbstractGameTile;

public class AuthoringEnvironment {
	
	private Stage myStage;
	private MenuBar myMenu;
	private GridPane myMapDisplay;
	private GridPane myEditDisplay;
	
	private GameMap myMap;

	public AuthoringEnvironment(){
		myMap = new GameMap();
		myStage = initialize(new Stage());
		myStage.show();
	}

	private Stage initialize(Stage stage) {
		myMenu = createMenuBar();
		myMapDisplay = createMapDisplay();
		myEditDisplay = createEditDisplay();
		
		BorderPane window = new BorderPane();
		window.setTop(myMenu);
		window.setCenter(myMapDisplay);
		window.setRight(myEditDisplay);
		
		stage.setScene(new Scene(window));
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
		addConstraints(gp);
		//Populate gridpane
		for (Point p: myMap.getTileMap().keySet()) {
			AbstractGameTile g = myMap.getTile(p);
			ImageView i = g.getView();
			gp.add(i, (int) p.getX(), (int) p.getY(), 1, 1);
		}
		return gp;
	}
	
	private void addConstraints(GridPane gp) {
		List<ColumnConstraints> ccon = new ArrayList<ColumnConstraints>();
		List<RowConstraints> rcon = new ArrayList<RowConstraints>();
		
		gp.setMaxHeight(300);
		gp.setMaxWidth(300);
		
		for (int i=0; i<myMap.getMapSize(); i++) {
			ColumnConstraints c = new ColumnConstraints();
			c.setPercentWidth(1.0 / myMap.getMapSize());
			RowConstraints r = new RowConstraints();
			r.setPercentHeight(1.0 / myMap.getMapSize());
			
			ccon.add(c);
			rcon.add(r);
		}
		gp.getColumnConstraints().addAll(ccon);
		gp.getRowConstraints().addAll(rcon);
	}
	
	private GridPane createEditDisplay() {
		GridPane gp = new GridPane();
		// Populate gridpane
		return gp;
		
	}
	
}
