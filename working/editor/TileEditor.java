package editor;

import java.util.ResourceBundle;

import tiles.implementations.DecoratorTile;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TileEditor {
	
	private DecoratorTile tile;
	private VBox tilePane;
	private GridPane iconPane;
	private ResourceBundle tileIconBundle;
	
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private final int NUMBER_ROW_ICON_PANEL = 5;
	private final int NUMBER_COLUMN_ICON_PANEL = 3;
	private final double WIDTH_ICON_PANEL = 300.1;
	private final double HEIGHT_ICON_PANEL = 500.1;
			
	public TileEditor(DecoratorTile tile) {
		this.tile = tile;
		tilePane = new VBox();
		tilePane.getChildren().add(createMenubar());
		iconPane = new GridPane();
		iconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		tilePane.getChildren().add(iconPane);
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
		text.setText(tile.getImplementation().getClass().getSimpleName());
		return text;
	}

	private ComboBox<String> createDropdownList() {
		ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPromptText("Select a category");
        comboBox.getItems().add("SceneryTile");
        comboBox.getItems().add("PathTile");
        comboBox.valueProperty().addListener((o, s1, s2) -> showGridPane(s2));
		return comboBox;
	}

	private void showGridPane(String s) {
		//GridPane iconPane = new GridPane();
		
		tileIconBundle = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "TileIcon");
		String[] tileIconPath = tileIconBundle.getString(s).split(",");
		
		tile.setImage("path_brick_1.png");
		
		
		for (int i = 0;i< tileIconPath.length;i++) {
			System.out.println(tileIconPath[i]);
		}
		
		iconPane.getChildren().clear();
				
		for (int i = 0; i < tileIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(tileIconPath[i])));
			img.setFitWidth(iconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(iconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			iconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		
		return;
	}
	
	public VBox getEditorPane() {
		return tilePane;
	}

}
