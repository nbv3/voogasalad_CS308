package editor.sidepanes;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import resources.LabelRetriever;

public abstract class AEditorPane {

	protected VBox myEditorPane;

	public VBox getEditorPane() {
		return myEditorPane;
	}

	protected Button makeImageChooser() {
		Button fileChooser = new Button(LabelRetriever.getLabel("ImageSelectPrompt"));
		fileChooser.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FileChooser file = new FileChooser();
				file.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter(LabelRetriever.getLabel("AllImages"), "*.*"),
						new FileChooser.ExtensionFilter("JPG", "*.jpg"),
						new FileChooser.ExtensionFilter("GIF", "*.gif"),
						new FileChooser.ExtensionFilter("BMP", "*.bmp"),
						new FileChooser.ExtensionFilter("PNG", "*.png"));
				// String imageURL = "file://" +
				// file.showOpenDialog(stage).getPath();

			}
		});

		return fileChooser;
	}

}
