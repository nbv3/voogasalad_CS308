package authoring.sidepanes;

import java.io.File;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
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
		for (int i = 0; i < iconPath.length; i++) {
			Image iconImage = new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i]));
			ImageView icon = new ImageView(iconImage);
			setIconOnClickVisual(icon);
			icon.setFitWidth(DEFAULT_ICON_DIMENSION);
			icon.setFitHeight(DEFAULT_ICON_DIMENSION);
			this.getChildren().add(icon);
		}
	}
	
	protected void showImageOptions(File XMLDirectory){
		
	}
	
	private void setIconOnClickVisual(ImageView icon){
		icon.setOnMouseClicked(e -> {
			mySelectedIcon.setValue(icon);
		});
		
		mySelectedIcon.addListener((o,s1,s2) -> {
			if (s1 == null) {
				s2.setEffect(new Glow(0.7));
				return;
			}
			
			s1.setEffect(null);
			s2.setEffect(new Glow(0.7));
			});
		
	}

}
