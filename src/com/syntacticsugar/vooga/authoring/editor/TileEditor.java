package com.syntacticsugar.vooga.authoring.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TileEditor {

	private List<DecoratorTile> currentTileSelection;
	private VBox tilePane;
	private VBox iconBox;
	private ResourceBundle tileIconBundle;
	private ObjectProperty<ImageView> selectImg = new SimpleObjectProperty<ImageView>();
	
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private final int NUMBER_ROW_ICON_PANEL = 3;
	private final int NUMBER_COLUMN_ICON_PANEL = 5;
	private final double WIDTH_ICON_PANEL = 250;
	private final double HEIGHT_ICON_PANEL = 150;
			
	public TileEditor(List<DecoratorTile> tiles) {
		currentTileSelection = tiles;
		tilePane = new VBox();
		tilePane.getStyleClass().add("properties-module");
		iconBox = new VBox();
		tilePane.getChildren().addAll(createDropdownList(),iconBox);
	}
	
	private Button createOkButton(String s) {
		Button okButton = new Button("OK");
		okButton.setPrefHeight(30);
		okButton.setPrefWidth(80);
		okButton.setOnAction(e -> {updateSelectedTile(selectImg.getValue(),s);});
		return okButton;
	}

	private ComboBox<String> createDropdownList() {
		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.setPromptText("Select a category");
		comboBox.getItems().add("Scenery");
		comboBox.getItems().add("Path");
		comboBox.valueProperty().addListener((o, s1, s2) -> showImageOptions(s2));
		return comboBox;
	}

	private void showImageOptions(String s) {
		tileIconBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "TileIcon");
		String[] tileIconPath = tileIconBundle.getString(s).split(",");
		iconBox.getChildren().clear();
		ScrollPane sp = new ScrollPane();
		GridPane iconPane = new GridPane();
		iconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		sp.setContent(iconPane);
		for (int i = 0; i < tileIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(tileIconPath[i])));
			
			img.setOnMouseClicked(e -> {
				selectImg.setValue(img);
				});
			
			selectImg.addListener((o,s1,s2) -> {
				if (s1 == null) {
					s2.setEffect(new Glow(0.7));
					return;
				}
				s1.setEffect(null);
				s2.setEffect(new Glow(0.7));
				});
			
			img.setFitWidth(iconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(iconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			//System.out.println("WIdht= " + img.getFitWidth() + "HEIGHt= " + img.getFitHeight());
			iconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
			//System.out.println("indexX= " + i % NUMBER_COLUMN_ICON_PANEL + "indexY= " + i / NUMBER_COLUMN_ICON_PANEL);
		}
		
		iconBox.getChildren().addAll(iconPane, createOkButton(s));
		return;
	}
	
	private void updateSelectedTile(ImageView iv, String s) {
		
		if (currentTileSelection.isEmpty()) {
			new AlertBoxFactory().createObject("No tile selected, please at least select one tile");
			 return;
		}
		
		for (DecoratorTile tile: currentTileSelection) {
//			ImageView i = new ImageView(iv.getImage());
//			tile.setImage(i);
//			tile.getView().getStyleClass().remove("tile-select-off");
//			tile.getView().getStyleClass().add("tile-select-on");
//			try {
//				Class<?> arg = IGameTile.class;
//				tile.setImplementation((IGameTile) Class.forName("tiles.implementations." + s + "Tile").getDeclaredConstructor(arg).newInstance(tile));
//			} catch (InstantiationException | IllegalAccessException
//					| ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
//				e.printStackTrace();
//			}
//			tile.getSpawnerList().clear();
		}
	
	}

	public VBox getEditorPane() {
		return tilePane;
	}

}