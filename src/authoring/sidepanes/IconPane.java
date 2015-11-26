package authoring.sidepanes;

import java.io.File;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class IconPane extends TilePane {

	private int myWidth;
	private int myHeight;
	private ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<ImageView>();
	private final int DEFAULT_ICON_DIMENSION = 50;

	public IconPane(int paneWidth, int paneHeight) {
		super();
		this.setPrefSize(paneWidth, paneHeight);
		myWidth = paneWidth;
		myHeight = paneHeight;
	}

	protected void showImageOptions(String[] iconPath) {
		this.getChildren().clear();
		
		mySelectedIcon.addListener((o, s1, s2) -> setGlowEffect(s1, s2));
		
		for (int i = 0; i < iconPath.length; i++) {
			Image iconImage = new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i]));
			ImageView icon = new ImageView(iconImage);
			registerMouseClickHandler(icon);
			icon.setFitWidth(DEFAULT_ICON_DIMENSION);
			icon.setFitHeight(DEFAULT_ICON_DIMENSION);
			this.getChildren().add(icon);
		}
	}

	private void setGlowEffect(ImageView iv1, ImageView iv2) {
		if (iv1 == null) {
			iv2.setEffect(new Glow(0.7));
			return;
		}
		iv1.setEffect(null);
		iv2.setEffect(new Glow(0.7));
	}
	
	protected void showImageOptions(File XMLDirectory){
		
	}
	
	private void registerMouseClickHandler(ImageView icon){
		icon.setOnMouseClicked(e -> mySelectedIcon.setValue(icon));
	}

}
