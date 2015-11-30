package authoring.icons.panes;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import authoring.icons.implementations.AbstractIcon;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
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
	
	/**
	 * Show all icons representing the relevant file types as specified
	 * by this subclass of AbstractIconPane.
	 * @param directory
	 */
	public abstract void showIcons(File directory);
	
	/**
	 * Return the JavaFX Node used to display this IconPane.
	 * @return
	 */
	public ScrollPane getIconPane(){
		return myScrollPane;
	}
	
	protected Collection<String> getImagePaths(File directory, FileFilter filter) {
		File[] files = directory.listFiles(filter);
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i=0; i<files.length; i++) {
			imagePaths.add(files[i].getName());
		}
		return imagePaths;
	}
	
	protected void clearIconPane() {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
	}
	
	protected void addIconToPane(AbstractIcon icon, String imagePath) {
		myIconPane.getChildren().add(icon);
		myImagePaths.put(icon, imagePath);
	}
	
	protected void setSelectedEffect(AbstractIcon oldIcon, AbstractIcon newIcon) {
		if (oldIcon == null) {
			newIcon.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		oldIcon.setEffect(null);
		newIcon.setEffect(new Glow(GLOW_PERCENTAGE));
	}

	protected void setSelectedIcon(AbstractIcon icon) {
		mySelectedIcon.set(icon);
	}
	
	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}
	
}
