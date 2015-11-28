package authoring.icons.panes;

import java.util.HashMap;
import java.util.Map;

import authoring.icons.implementations.AbstractIcon;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;

public abstract class AbstractIconPane {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	private Map<AbstractIcon, String> myImagePaths;

	private final ObjectProperty<AbstractIcon> mySelectedIcon = new SimpleObjectProperty<AbstractIcon>();
	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 3;

	public AbstractIconPane() {
		mySelectedIcon.addListener((o, s1, s2) -> setSelectedEffect(s1, s2));
		myImagePaths = new HashMap<AbstractIcon, String>();
		myScrollPane = new ScrollPane();
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		myIconPane = new TilePane();
		myIconPane.setHgap(INSET_VALUE);
		myIconPane.setVgap(INSET_VALUE);
		myScrollPane.setContent(myIconPane);
		myScrollPane.setPadding(new Insets(INSET_VALUE));
	}
	
	protected void clearIconPane() {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
	}
	
	protected void addIconToPane(AbstractIcon icon) {
		myIconPane.getChildren().add(icon);
	}
	
	protected void addIconImageToMap(AbstractIcon icon, String imagePath) {
		myImagePaths.put(icon, imagePath);
	}
	
	public ScrollPane getIconPane(){
		return myScrollPane;
	}
	
	protected void setSelectedEffect(AbstractIcon oldIcon, AbstractIcon newIcon) {
		if (oldIcon == null) {
			newIcon.getImageView().setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		if (newIcon == null) {
			oldIcon.getImageView().setEffect(null);
			return;
		}
		oldIcon.getImageView().setEffect(null);
		newIcon.getImageView().setEffect(new Glow(GLOW_PERCENTAGE));
	}

	protected void setSelectedIcon(AbstractIcon icon) {
		mySelectedIcon.set(icon);
	}
	
	protected abstract void createNewIcon();

	public Image getSelectedImage() {
		return mySelectedIcon.get().getImageView().getImage();
	}

	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}
	
}
