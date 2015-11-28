package authoring.library.implementations;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public abstract class AbstractIcon extends VBox {
	
	private ImageView myImageView;
	
	public AbstractIcon(String imagePath, double dimension){
		Image img = new Image(getClass().getClassLoader().getResourceAsStream(imagePath));
		myImageView = new ImageView(img);
		setIconDimensions(dimension);
		this.getChildren().add(myImageView);
	}
	
	private void setIconDimensions(double dimension){
		myImageView.setFitWidth(dimension);
		myImageView.setFitHeight(dimension);
	}
	
	public ImageView getImageView(){
		return myImageView;
	}
	
}
