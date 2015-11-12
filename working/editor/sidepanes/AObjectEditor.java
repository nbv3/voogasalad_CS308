package editor.sidepanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public abstract class AObjectEditor {

	private GridPane myEditorPane;
	private FileChooser file;

	public AObjectEditor() {
		formatImageChooser();
	}

	public GridPane getEditorPane() {
		return myEditorPane;

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

		myEditorPane.getChildren().add(fileChooser);

	}

}
