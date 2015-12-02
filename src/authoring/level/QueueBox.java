package authoring.level;

import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class QueueBox {
	private VBox myEnemy;
	private ImageView image;

	public QueueBox() {
		myEnemy = new VBox();
		image = new ImageView();
		myEnemy.getChildren().add(image);
	}

	public VBox getContent() {
		return myEnemy;
	}

}
