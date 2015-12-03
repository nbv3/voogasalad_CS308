package authoring.icons.panes;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import authoring.icons.implementations.Icon;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;

public abstract class AbstractIconPane {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	private Map<Icon, String> myImagePaths;

	private final ObjectProperty<Icon> mySelectedIcon = new SimpleObjectProperty<>();
	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 6;
	private final int NUM_COLS = 4;

	public AbstractIconPane() {
		mySelectedIcon.addListener((o, s1, s2) -> setSelectedEffect(s1, s2));
		myImagePaths = new HashMap<>();
		myScrollPane = new ScrollPane();
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myScrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myIconPane = new TilePane();
		myIconPane.setPrefColumns(NUM_COLS);
		myIconPane.setHgap(INSET_VALUE);
		myIconPane.setVgap(INSET_VALUE);
		myScrollPane.setContent(myIconPane);
		myScrollPane.setPrefViewportWidth(Region.USE_COMPUTED_SIZE);
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
	
	public void addIconToPane(Icon icon, String imagePath) {
		double size = ((getIconPane().getWidth() - 2.0*INSET_VALUE - (NUM_COLS-1.0)*2.0*INSET_VALUE)/(NUM_COLS));
		myIconPane.getChildren().add(icon);
		myImagePaths.put(icon, imagePath);
	}
	
	protected void setSelectedEffect(Icon oldIcon, Icon newIcon) {
		if (oldIcon == null) {
			newIcon.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		if (newIcon == null) {
			oldIcon.setEffect(null);
			return;
		}
		oldIcon.setEffect(null);
		newIcon.setEffect(new Glow(GLOW_PERCENTAGE));
	}

	public void setSelectedIcon(Icon icon) {
		mySelectedIcon.set(icon);
	}
	
	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}
}
