package editor;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ImageSelector {
	private HBox imageSelector;
	private ImageView img;
	private final String defaultEnemy = "default_tile.jpg";

	public ImageSelector() {
		imageSelector = new HBox();
		img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(defaultEnemy)));
//		img.setFitWidth(300.1);
//		img.setFitHeight(300.1);
//		Button selectImage = new Button();
//		imageSelector.setSpacing(10);
//		imageSelector.getChildren().addAll(selectImage, img);
	}
	
	public HBox getNode() {
		return imageSelector;
	}

}
