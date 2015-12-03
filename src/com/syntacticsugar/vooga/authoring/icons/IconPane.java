package com.syntacticsugar.vooga.authoring.icons;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.dragdrop.DragDropManager;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;

public class IconPane {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	private Map<Icon, String> myImagePaths;

	private final ObjectProperty<Icon> mySelectedIcon = new SimpleObjectProperty<>();
	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 6;
	private final int NUM_COLS = 4;

	public IconPane() {
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
	public void showIcons(File directory, IConverter fileConverter) {
		clearIconPane();
		Collection<String> imagePaths = fileConverter.getImages(directory);
		for (String path : imagePaths) {
			Icon icon = new Icon(path);
			icon.setOnDragDetected((MouseEvent e) -> DragDropManager.createDragClipBoards(icon, e));
			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			addIconToPane(icon, path);
		}
		setSelectedIcon(null);
	}
	
	/**
	 * Return the JavaFX Node used to display this IconPane.
	 * @return
	 */
	public ScrollPane getIconPane(){
		return myScrollPane;
	}
	
	protected void clearIconPane() {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
	}
	
	public void addIconToPane(Icon icon, String imagePath) {
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
