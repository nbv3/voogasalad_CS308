package editor;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ImageSelector {
	private HBox imageSelector;
	private ImageView img;
	private final String defaultEnemy = "enemy_soldier_1.jpg";

	public ImageSelector() {
		imageSelector = new HBox();
		img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(defaultEnemy)));
		img.setFitWidth(100.1);
		img.setFitHeight(100.1);
		
		Button selectImage = new Button("Load Image");
		imageSelector.setSpacing(20);
		imageSelector.getChildren().addAll(selectImage, img);
	}
	
	public HBox getNode() {
		return imageSelector;
	}

}
