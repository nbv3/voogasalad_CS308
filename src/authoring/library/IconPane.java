package authoring.library;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class IconPane {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	
	private Map<ImageView, String> myImagePaths;
	
	private ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<ImageView>();
	private final int DEFAULT_ICON_DIMENSION = 50;
	private final double GLOW_PERCENTAGE = 0.7;

	public IconPane() {
		myImagePaths = new HashMap<ImageView, String>();
		myScrollPane = new ScrollPane();
		myScrollPane.setFitToWidth(true);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myIconPane = new TilePane();
		myScrollPane.setContent(myIconPane);
	}
	
	public ScrollPane getIconPane(){
		return myScrollPane;
	}

	private ImageView makeIconFromImage(Image image){
		ImageView icon = new ImageView(image);
		registerMouseClickHandler(icon);
		icon.setFitWidth(DEFAULT_ICON_DIMENSION);
		icon.setFitHeight(DEFAULT_ICON_DIMENSION);
		return icon;
	}
	
	public void showImageOptions(String[] iconPath) {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
		mySelectedIcon.addListener((o, s1, s2) -> setGlowEffect(s1, s2));
		for (int i = 0; i < iconPath.length; i++) {
			Image iconImage = new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i]));
			ImageView icon = makeIconFromImage(iconImage);
			myImagePaths.put(icon, iconPath[i]);
			myIconPane.getChildren().add(icon);
		}
	}

	protected void showImageOptions(File XMLDirectory) {
		for (File file: XMLDirectory.listFiles()){
			if (file.getName().endsWith("xml")){
				ObjectData objectData = new ObjectData(); // NEED TO FIND METHOD THAT PARSES XML TO OBJECTDATA FILE
				Image iconImage = new Image(
						getClass().getClassLoader().getResourceAsStream(objectData.getImagePath()));
				ImageView icon = makeIconFromImage(iconImage);
				myIconPane.getChildren().add(icon);
			}
		}
	}
	
	private void setGlowEffect(ImageView iv1, ImageView iv2) {
		if (iv1 == null) {
			iv2.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		iv1.setEffect(null);
		iv2.setEffect(new Glow(GLOW_PERCENTAGE));
	}

	private void registerMouseClickHandler(ImageView icon) {
		icon.setOnMouseClicked(e -> mySelectedIcon.setValue(icon));
	}
	
	public Image getSelectedImage() {
		return mySelectedIcon.get().getImage();
	}

	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}
	
}
