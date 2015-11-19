package editor;

import java.util.ResourceBundle;

import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageTile extends ImageView {

	public ImageTile(String s, ResourceBundle tileIconBundle, int[] dimensions) {
		String[] tileIconPath = tileIconBundle.getString(s).split(",");
		//
		for (int i = 0; i < tileIconPath.length; i++) {
			ImageView img = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(tileIconPath[i])));
			
			
			img.focusedProperty().addListener((o,oldValue,newValue) -> {
		        if (newValue) {
		            img.setEffect(new Glow(0.7));
		        }
		        else {
		            img.setEffect(null);
		        }});
			
			img.setFitWidth(dimensions[0]);
			img.setFitHeight(dimensions[1]);
			//iconPane.add(img, i % NUMBER_COLUMN_ICON_PANEL, i / NUMBER_COLUMN_ICON_PANEL, 1, 1);
		}
		
		//iconPane.add(createOkButton(s),0, tileIconPath.length / NUMBER_COLUMN_ICON_PANEL + 1, 1, 1);
	}

}
