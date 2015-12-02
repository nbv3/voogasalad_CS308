package authoring.icons.implementations;

import javafx.beans.property.DoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Icon extends Pane {

	private ImageView myImageView;

	public Icon(String imagePath){
		Image img = new Image(getClass().getClassLoader().getResourceAsStream(imagePath));
		myImageView = new ImageView(img);
		makeResizable(myImageView);
		this.getChildren().add(myImageView);
	}

	private void makeResizable(ImageView iv){
		iv.fitWidthProperty().bind(this.widthProperty());
		iv.fitHeightProperty().bind(this.heightProperty());
		iv.translateXProperty().bind(this.translateXProperty());
		iv.translateYProperty().bind(this.translateYProperty());
	}

	public DoubleProperty getWidthProperty() {
		return myImageView.fitWidthProperty();
	}

	public DoubleProperty getHeightProperty() {
		return myImageView.fitHeightProperty();
	}

	public void setImage(Image image) {
		myImageView.setImage(image);
	}
	
}
