package editor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.Glow;
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
	
	private List<DecoratorTile> currentTileSelection;
	private VBox tilePane;
	private GridPane iconPane;
	private ResourceBundle tileIconBundle;
	private ImageView selectImg;
	
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	private final int NUMBER_ROW_ICON_PANEL = 3;
	private final int NUMBER_COLUMN_ICON_PANEL = 5;
	private final double WIDTH_ICON_PANEL = 500;
	private final double HEIGHT_ICON_PANEL = 300;
			
	public TileEditor(List<DecoratorTile> tiles) {
		currentTileSelection = tiles;
		tilePane = new VBox();
		tilePane.getChildren().add(createMenubar());
		iconPane = new GridPane();
		iconPane.setPrefSize(WIDTH_ICON_PANEL, HEIGHT_ICON_PANEL);
		tilePane.getChildren().add(iconPane);
	}
	
	private Button createOkButton(String s) {
		Button okButton = new Button("OK");
		okButton.setPrefHeight(30);
		okButton.setPrefWidth(80);
		okButton.setOnAction(e -> {updateSelectedTile(selectImg,s);});
		return okButton;
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
			
			img.setOnMouseClicked(e -> {
				selectImg = img;
				img.requestFocus();});
			
			img.focusedProperty().addListener((o,oldValue,newValue) -> {
		        if (newValue) {
		            img.setEffect(new Glow(0.7));
		        }
		        else {
		            img.setEffect(null);
		        }});
			
			img.setFitWidth(iconPane.getPrefWidth() / NUMBER_COLUMN_ICON_PANEL);
			img.setFitHeight(iconPane.getPrefHeight() / NUMBER_ROW_ICON_PANEL);
			iconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		
		iconPane.add(createOkButton(s),0, tileIconPath.length / NUMBER_COLUMN_ICON_PANEL + 1, 1, 1);
		return;
	}
	
	private void showAlertBox(String str) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText(null);
		alert.setContentText(str);
		alert.showAndWait();
	}
	
	private void updateSelectedTile(ImageView iv, String s) {
		
		if (currentTileSelection.isEmpty()) {
			 showAlertBox("No tile selected, please at least select one tile");
			 return;
		}
		
		for (DecoratorTile tile: currentTileSelection) {
			ImageView i = new ImageView(iv.getImage());
			i.setOpacity(0.75);
			tile.setImage(i);
			try {
				Class<?> arg = IGameTile.class;
				tile.setImplementation((IGameTile) Class.forName("tiles.implementations." + s + "Tile").getDeclaredConstructor(arg).newInstance(tile));
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}	
	
	}
	
	public VBox getEditorPane() {
		return tilePane;
	}

}