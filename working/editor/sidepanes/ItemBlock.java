package editor.sidepanes;

import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemBlock extends ImageView {
	
	//private ImageView myImage;
	
	public ItemBlock(InputStream inputStream) {
		super(new Image(inputStream));	
	}
	
	public ImageView getImageview(){
		return this;
	}

}
