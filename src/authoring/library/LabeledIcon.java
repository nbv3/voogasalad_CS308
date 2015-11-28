package authoring.library;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LabeledIcon extends VBox {
	
	private ImageView myImageView;
	private Text myLabel;
	
	
	public LabeledIcon(Image image, double dimension){
		super();		
		myImageView = new ImageView(image);
		setIconDimensions(dimension);
		this.getChildren().add(myImageView);
	}
	
	public LabeledIcon(String label, Image image, double dimension){
		myImageView = new ImageView(image);
		setIconDimensions(dimension);
		myLabel = new Text(label);
		this.getChildren().add(myImageView);
		this.getChildren().add(myLabel);
	}
	
	private void setIconDimensions(double dimension){
		myImageView.setFitWidth(dimension);
		myImageView.setFitHeight(dimension);
	}
	
	public ImageView getImageView(){
		return myImageView;
	}
}
