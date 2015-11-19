package editor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ResourceBundle;

import editor.sidepanes.AObjectEditor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import tiles.DecoratorTile;
import tiles.IGameTile;

public class TileEditor extends AObjectEditor implements ITileEditor {

	private List<DecoratorTile> currentTileSelection;
	private VBox tilePane;
	private VBox iconBox;
	private ResourceBundle tileIconBundle;
	
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private final int NUMBER_ROW_ICON_PANEL = 3;
	private final int NUMBER_COLUMN_ICON_PANEL = 5;
	private final double WIDTH_ICON_PANEL = 250;
	private final double HEIGHT_ICON_PANEL = 150;
			
	public TileEditor(List<DecoratorTile> tiles) {
		super();
		currentTileSelection = tiles;
		//tilePane = new VBox();
		iconBox = new VBox();
		this.getChildren().addAll(createDropdownList(),iconBox);
	}
	
	private Button createOkButton(String s) {
		Button okButton = new Button("OK");
		okButton.setPrefHeight(30);
		okButton.setPrefWidth(80);
		okButton.setOnAction(e -> {updateSelectedTile(selectImg,s);});
		return okButton;
	}

	private ComboBox<String> createDropdownList() {
		ComboBox<String> comboBox = new ComboBox<String>();
		comboBox.setPromptText("Select a category");
		comboBox.getItems().add("Scenery");
		comboBox.getItems().add("Path");
		comboBox.valueProperty().addListener((o, s1, s2) -> showTileOptions(s2));
		return comboBox;
	}

	private void showTileOptions(String s) {
		tileIconBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "TileIcon");
		String[] tileIconPath = tileIconBundle.getString(s).split(",");
		//myIconPane.getChildren().clear();
		
		//iconBox.getChildren().clear();
		showImageOptions(NUMBER_ROW_ICON_PANEL, NUMBER_COLUMN_ICON_PANEL, tileIconPath);
		myIconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
				
		iconBox.getChildren().addAll(myIconPane, createOkButton(s));
		
		return;
	}
	
	private void showAlertBox(String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(str);
		alert.showAndWait();
	}
	
	private void updateSelectedTile(ImageTile iv, String s) {
		
		if (currentTileSelection.isEmpty()) {
			 showAlertBox("No tile selected, please at least select one tile");
			 return;
		}
		
		for (DecoratorTile tile: currentTileSelection) {
			ImageView i = new ImageView(iv.getImage());
			//i.getStyleClass().add("tile-select-on");
			tile.setImage(i);
			try {
				Class<?> arg = IGameTile.class;
				tile.setImplementation((IGameTile) Class.forName("tiles.implementations." + s + "Tile").getDeclaredConstructor(arg).newInstance(tile));
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
		currentTileSelection.clear();
	
	}

	public ITileEditor getEditorPane() {
		return this;
	}

}