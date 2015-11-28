package authoring.library;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.objecteditor.ObjectData;
import com.thoughtworks.xstream.XStream;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class IconPane {

	private ScrollPane myScrollPane;
	protected TilePane myIconPane;
	protected LabeledIcon myAddButton;
	private Map<LabeledIcon, String> myImagePaths;

	private static final ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<ImageView>();
	private static final int DEFAULT_ICON_DIMENSION = 50;
	private static final double GLOW_PERCENTAGE = 0.7;
	private static final int INSET_VALUE = 3;

	private final String[] myAcceptableImageTypes = {".jpg", ".JPG", ".png", ".PNG"};

	public IconPane() {
		mySelectedIcon.addListener((o, s1, s2) -> setGlowEffect(s1, s2));
		myImagePaths = new HashMap<LabeledIcon, String>();
		myScrollPane = new ScrollPane();
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		myIconPane = new TilePane();
		myIconPane.setHgap(INSET_VALUE);
		myIconPane.setVgap(INSET_VALUE);
		myAddButton = makeAddButtonIcon();
		myScrollPane.setContent(myIconPane);
		myScrollPane.setPadding(new Insets(INSET_VALUE));
		//myXStream = new XStream();
	}
	
	public ScrollPane getIconPane(){
		return myScrollPane;
	}
	
	protected LabeledIcon makeAddButtonIcon(){
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("add_button.png"));
		LabeledIcon addButton = makeIconFromImage(image);
		return addButton;
	}
	
	private LabeledIcon makeIconFromImage(Image image){
		LabeledIcon icon = new LabeledIcon(image, DEFAULT_ICON_DIMENSION);
		registerMouseClickHandler(icon);
		return icon;
	}
	

	public void showImageOptions(String[] iconPath) {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
		for (int i = 0; i < iconPath.length; i++) {
			Image iconImage = new Image(getClass().getClassLoader().getResourceAsStream(iconPath[i]));
			LabeledIcon icon = makeIconFromImage(iconImage);
			myImagePaths.put(icon, iconPath[i]);
			myIconPane.getChildren().add(icon);
		}
		registerAddButtonMouseClickHandler(myAcceptableImageTypes);
		myIconPane.getChildren().add(myAddButton);
	}


	private void setGlowEffect(ImageView iv1, ImageView iv2) {
		if (iv1 == null) {
			iv2.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		iv1.setEffect(null);
		iv2.setEffect(new Glow(GLOW_PERCENTAGE));
	}

	protected void registerMouseClickHandler(LabeledIcon icon) {
		icon.setOnMouseClicked(e -> mySelectedIcon.setValue(icon.getImageView()));
	}
	
	protected void registerAddButtonMouseClickHandler(String[] fileTypes){
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
