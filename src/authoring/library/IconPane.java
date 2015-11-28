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
	private LabeledIcon myAddButton;
	
	private Map<LabeledIcon, String> myImagePaths;
	
	private ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<ImageView>();
	private final int DEFAULT_ICON_DIMENSION = 50;
	private final double GLOW_PERCENTAGE = 0.7;
	private final int INSETS = 10;
	private final String[] myAcceptableImageTypes = {".jpg", ".JPG", ".png", ".PNG"};
	private final String[] myAcceptableXMLTypes = {".XML", ".xml"};
	private XStream myXStream;

	public IconPane() {
		myImagePaths = new HashMap<LabeledIcon, String>();
		myScrollPane = new ScrollPane();
		myScrollPane.setFitToWidth(true);
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myIconPane = new TilePane();
		myAddButton = makeAddButtonIcon();
		myScrollPane.setContent(myIconPane);
		//myXStream = new XStream();
	}
	
	public ScrollPane getIconPane(){
		return myScrollPane;
	}
	
	private LabeledIcon makeAddButtonIcon(){
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("add_button.png"));
		LabeledIcon addButton = makeIconFromImage(image);
		return addButton;
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
		registerAddButtonMouseClickHandler(myAcceptableImageTypes);
		myIconPane.getChildren().add(myAddButton);
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
			registerAddButtonMouseClickHandler(myAcceptableXMLTypes);
			myIconPane.getChildren().add(myAddButton);
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
	
	private void registerAddButtonMouseClickHandler(String[] fileTypes){
		myAddButton.setOnMouseClicked(e -> displayFileSelector(fileTypes));
	}
	
	private void displayFileSelector(String[] fileType){
		// needs implementation
	}

	public Image getSelectedImage() {
		return mySelectedIcon.get().getImage();
	}

	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}
	
}
