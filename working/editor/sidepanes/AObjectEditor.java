package editor.sidepanes;

import editor.ImageTile;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public abstract class AObjectEditor extends VBox {

	protected GridPane myIconPane;
	protected ImageTile selectImg;
	protected ScrollPane myScrollPane;

	public AObjectEditor() {
		//formatImageChooser();
		myIconPane = new GridPane();
		myScrollPane = new ScrollPane();
	}

	private void formatImageChooser() {
		Button fileChooser = new Button("Select Image");
		fileChooser.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FileChooser file = new FileChooser();
				file.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
						new FileChooser.ExtensionFilter("JPG", "*.jpg"),
						new FileChooser.ExtensionFilter("GIF", "*.gif"),
						new FileChooser.ExtensionFilter("BMP", "*.bmp"),
						new FileChooser.ExtensionFilter("PNG", "*.png"));
				// String imageURL = "file://" +
				// file.showOpenDialog(stage).getPath();

			}
		});

		this.getChildren().add(fileChooser);

	}
	/*
	protected void showImageOptions(int numRows, int numColumns, String[] iconPath) {
		myIconPane.getChildren().clear();
		for (int i = 0; i < iconPath.length; i++) {
			ImageTile img = new ImageTile(
					getClass().getClassLoader().getResourceAsStream(iconPath[i]), 
					myIconPane.getPrefWidth() / numColumns,
					myIconPane.getPrefHeight() / numRows);
			
			img.setOnMouseClicked(e -> {
				selectImg = img;
				img.requestFocus();
				}
			);

			myIconPane.add(img, i % numColumns, i / numColumns, 1, 1);
		}
		return;
	}
	*/
	
	protected void showImageOptions(int numRows, int numColumns, String[] iconPath) {
		myScrollPane = new ScrollPane();
		myIconPane.getChildren().clear();
		
		myScrollPane.setContent(myIconPane);
		for (int i = 0; i < iconPath.length; i++) {
			ImageTile img = new ImageTile(
					getClass().getClassLoader().getResourceAsStream(iconPath[i]), 
					myIconPane.getPrefWidth() / numColumns,
					myIconPane.getPrefHeight() / numRows);
			
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
			
			img.setFitWidth(myIconPane.getPrefWidth() / numColumns);
			img.setFitHeight(myIconPane.getPrefHeight() / numRows);
			//System.out.println("WIdht= " + img.getFitWidth() + "HEIGHt= " + img.getFitHeight());
			myIconPane.add(img, i % numColumns, i / numColumns, 1, 1);
			//System.out.println("indexX= " + i % NUMBER_COLUMN_ICON_PANEL + "indexY= " + i / NUMBER_COLUMN_ICON_PANEL);
		}
	}

}
