package authoring.library;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.thoughtworks.xstream.XStream;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class IconPane {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	
	private Map<Node, String> myImagePaths;
	
	private ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<ImageView>();
	private final int DEFAULT_ICON_DIMENSION = 50;
	private final double GLOW_PERCENTAGE = 0.7;
	private final int INSETS = 10;
	private XStream myXStream;

	public IconPane() {
		myImagePaths = new HashMap<Node, String>();
		myScrollPane = new ScrollPane();
		myScrollPane.setFitToWidth(true);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myIconPane = new TilePane();
//		myIconPane.setPadding(new Insets(INSETS, INSETS, INSETS, INSETS));
		myScrollPane.setContent(myIconPane);
		//myXStream = new XStream();
	}
	
	public ScrollPane getIconPane(){
		return myScrollPane;
	}

	private LabeledIcon makeIconFromImage(Image image){
		LabeledIcon icon = new LabeledIcon(image, DEFAULT_ICON_DIMENSION);
		registerMouseClickHandler(icon);
		return icon;
	}
	
	private LabeledIcon makeLabeledIconFromImage(Image image, String name){
		LabeledIcon labeledIcon = new LabeledIcon(name, image, DEFAULT_ICON_DIMENSION);
		registerMouseClickHandler(labeledIcon);
		return labeledIcon;
	}

	public void showImageOptions(String[] iconPath) {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
		mySelectedIcon.addListener((o, s1, s2) -> setGlowEffect(s1, s2));
		for (int i = 0; i < iconPath.length; i++) {
			Image iconImage = new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i]));
			LabeledIcon icon = makeIconFromImage(iconImage);
			myImagePaths.put(icon, iconPath[i]);
			myIconPane.getChildren().add(icon);
		}
	}

	public void showImageOptionsFromXML(File XMLDirectory) {
		for (File file: XMLDirectory.listFiles()){
			if (file.getName().endsWith("xml")){
				ObjectData objectData = new ObjectData();
				//ObjectData objectData = (ObjectData) myXStream.fromXML(file);
				// ^ DOES THIS WORK ?
				Image iconImage = new Image(
						getClass().getClassLoader().getResourceAsStream(objectData.getImagePath()));
				LabeledIcon icon = makeLabeledIconFromImage(iconImage, objectData.getObjectName());
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

	private void registerMouseClickHandler(LabeledIcon icon) {
		icon.setOnMouseClicked(e -> mySelectedIcon.setValue(icon.getImageView()));
	}
	
	public Image getSelectedImage() {
		return mySelectedIcon.get().getImage();
	}

	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}
	
}
