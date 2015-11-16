package editor;

import java.util.List;
import java.util.ResourceBundle;

import view.IView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tiles.DecoratorTile;
import tiles.IGameTile;

public class TileEditor {

	// private DecoratorTile tile;
	private List<DecoratorTile> currentTileSelection;
	private VBox tilePane;
	private GridPane iconPane;
	private ResourceBundle tileIconBundle;

	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private final int NUMBER_ROW_ICON_PANEL = 5;
	private final int NUMBER_COLUMN_ICON_PANEL = 3;
	private final double WIDTH_ICON_PANEL = 300.1;
	private final double HEIGHT_ICON_PANEL = 500.1;

	public TileEditor(List<DecoratorTile> tiles) {
		// this.tile = tile;
		tilePane = new VBox();
		currentTileSelection = tiles;
		tilePane.getChildren().add(createMenubar());
		iconPane = new GridPane();
		iconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		VBox locations = createSpawningLocs();
		tilePane.getChildren().addAll(iconPane,locations);
	}

	public VBox createSpawningLocs() {
		CheckBox spawn = new CheckBox("Spawn Location");
		CheckBox finish = new CheckBox("Final Location");
		VBox locations = new VBox();
		locations.getChildren().addAll(spawn,finish);
		return locations;
	}

	public HBox createMenubar() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(createText(), createDropdownList());
		hbox.setAlignment(Pos.BASELINE_CENTER);
		return hbox;
	}

	private Text createText() {
		Text text = new Text();
		text.setFont(new Font(20));
		text.setText("Select Type:");
		return text;
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
		iconPane.getChildren().clear();
		for (int i = 0; i < tileIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(tileIconPath[i])));
			img.setOnMouseClicked(e -> updateTileViews(img));
			img.setFitWidth(iconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(iconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			iconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		return;
	}

	private void updateTileViews(ImageView iv) {
		for (DecoratorTile tile : currentTileSelection) {
			ImageView i = new ImageView(iv.getImage());
			i.getStyleClass().add("tile-select-on");
			tile.setImage(i);
		}
	}

	public VBox getEditorPane() {
		return tilePane;
	}

}