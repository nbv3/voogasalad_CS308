package editor.sidepanes;

import java.io.InputStream;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemBlock extends ImageView {
	
	//private ImageView myImage;
	
	public ItemBlock(String string) {
		super(new Image(string));	
	}
	
	public ImageView getImageview(){
		return this;
	}

}
