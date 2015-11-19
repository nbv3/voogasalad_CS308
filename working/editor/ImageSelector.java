package editor;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImageSelector {
	private HBox imageSelector;
	private ImageView img;
	private final String defaultEnemy = "enemy_soldier_1.png";

	public ImageSelector() {
	public ImageSelector(Stage stage) {
		imageSelector = new HBox();
		img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(defaultEnemy)));
		img.setFitWidth(100.1);
		img.setFitHeight(100.1);
		

		Button selectImage = new Button("Load Image");
		selectImage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				FileChooser fileChooser = new FileChooser();
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
				}
			}
		});
		imageSelector.setSpacing(20);
		imageSelector.getChildren().addAll(selectImage, img);

	}
	

	public HBox getNode() {
		return imageSelector;
	}
