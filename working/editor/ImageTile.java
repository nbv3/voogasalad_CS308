package editor;

import java.io.InputStream;
import java.util.ResourceBundle;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageTile extends ImageView {
	
	public ImageTile(InputStream inputStream, double width, double height) {
			this.setImage(new Image(inputStream));
			this.focusedProperty().addListener((o,oldValue,newValue) -> {
		        if (newValue) {
		            this.setEffect(new Glow(0.7));
		        }
		        else {
		            this.setEffect(null);
		        }});
			
			this.setFitWidth(width);
			this.setFitHeight(height);		
	}
	
}
