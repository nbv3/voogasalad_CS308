package authoring.level;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import authoring.library.IconPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MapEditor {

	private Map<TileData, ImageView> myTiles;
	private Collection<TileData> myTileSelection;
	
	private Button mySelectAllButton;
	private Button myClearAllButton;
	private Button myApplyButton;
	private ComboBox<String> myTileTypeChooser;
	private IconPane myIconPane;
	private VBox myTileControls;
	
	private int myMapSize;
	private GridPane myMapGrid;
	
	public MapEditor() throws Exception {
		myTiles = new HashMap<TileData, ImageView>();
		myTileSelection = new ArrayList<TileData>();
		myMapSize = inputMapSize();
		myMapGrid = populateGrid(600, 600);
		mySelectAllButton = buildSelectAllButton();
		myClearAllButton = buildClearAllButton();
		myApplyButton = buildApplyButton();
		myTileTypeChooser = buildTypeChooser();
		myIconPane = new IconPane();
		
		myTileControls = new VBox();
		myTileControls.setSpacing(10);
		myTileControls.setPadding(new Insets(10, 10, 10, 10));
		
		myTileControls.getChildren().addAll(mySelectAllButton, 
										 myClearAllButton, 
										 myTileTypeChooser, 
										 myIconPane.getIconPane(),
										 myApplyButton);
	}
	
	private Button buildSelectAllButton() {
		Button select = new Button();
		select.setText("Select All");
		select.setOnAction(e -> selectAllTiles());
		return select;
	}
	
	private Button buildClearAllButton() {
		Button clear = new Button();
		clear.setText("Clear All");
		clear.setOnAction(e -> clearAllTiles());
		return clear;
	}
	
	private Button buildApplyButton() {
		Button apply = new Button();
		apply.setText("Apply");
		apply.setOnAction(e -> applyTileChanges());
		return apply;
	}
	
	private void applyTileChanges() {
		Image newImage = null;
		try {
			newImage = myIconPane.getSelectedImage();
		} catch (NullPointerException e) {
			AlertBoxFactory.createObject("Must select an image.");
			return;
		}
		for (TileData tile : myTileSelection) {
			tile.setImplementation(myTileTypeChooser.getSelectionModel().getSelectedItem());
			tile.setImagePath(myIconPane.getSelectedImagePath());
			myTiles.get(tile).setImage(newImage);
		}
	}
	
	private ComboBox<String> buildTypeChooser() {
		ComboBox<String> box = new ComboBox<String>();
		box.setPromptText("Select tile type");
		box.getItems().add("Path");
		box.getItems().add("Scenery");
		box.valueProperty().addListener((o, s1, s2) -> showImageOptions(s2));
		return box;
	}
	
	private void showImageOptions(String type) {
		String[] imagePaths = ResourceManager.getString(type).split(",");
		myIconPane.showImageOptions(imagePaths);
	}
	
	public VBox getTileControls() {
		return myTileControls;
	}

	private int inputMapSize() throws Exception {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setHeaderText(null);
		dialog.setContentText("Enter size of grid");
		dialog.setTitle("Input Map Size");
		dialog.showAndWait();
		String result = dialog.getResult();
		int size = 0;
		try {
			size = Integer.parseInt(result);
		} catch (NumberFormatException e) {
			throw new Exception("Please input a positive integer.");
		}
		return size;
	}

	private GridPane populateGrid(double width, double height) {
		GridPane grid = new GridPane();
		grid.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
		grid.getStylesheets().add("/com/syntacticsugar/vooga/authoring/css/default.css");
		String default_img_path = "scenery_grass_1.png";
		Image default_img = new Image(getClass().getClassLoader().getResourceAsStream(default_img_path));
		for (int i=0; i<myMapSize; i++) {
			for (int j=0; j<myMapSize; j++) {
				TileData tile = new TileData(default_img_path);
				ImageView iv = new ImageView(default_img);
				myTiles.put(tile, iv);
				iv.setFitWidth(width/myMapSize);
				iv.setFitHeight(height/myMapSize);
				iv.setOnMouseEntered(e -> multiSelectTile(tile, iv, e.isControlDown()));
				iv.setOnMouseClicked(e -> toggleTileSelection(tile, iv));
				grid.add(iv, i, j, 1, 1);
			}
		}
		return grid;
	}

	private void multiSelectTile(TileData tile, ImageView tileView, boolean controlDown) {
		if (controlDown) {
			toggleTileSelection(tile, tileView);
		}
	}


	private void toggleTileSelection(TileData tile, ImageView tileView) {
		if (myTileSelection.contains(tile)) {
			myTileSelection.remove(tile);
			tileOpacityOff(tileView);
		} else {
			myTileSelection.add(tile);
			tileOpacityOn(tileView);
		}
		System.out.println(tile.getImagePath());
	}

	private void tileOpacityOff(ImageView iv) {
		iv.getStyleClass().remove("tile-select-on");
	}

	private void tileOpacityOn(ImageView iv) {
		iv.getStyleClass().add("tile-select-on");
	}

	private void selectAllTiles() {
		for (TileData tile : myTileSelection) {
			tileOpacityOff(myTiles.get(tile));
		}
		myTileSelection.clear();
		for (TileData tile : myTiles.keySet()) {
			myTileSelection.add(tile);
			tileOpacityOn(myTiles.get(tile));
		}
	}
	
	private void clearAllTiles() {
		myTileSelection.clear();
		for (TileData tile : myTiles.keySet()) {
			tileOpacityOff(myTiles.get(tile));
		}
	}
	
	public GridPane getMapGrid() {
		return myMapGrid;
	}

}
