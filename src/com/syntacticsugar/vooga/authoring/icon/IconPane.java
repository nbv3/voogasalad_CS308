package com.syntacticsugar.vooga.authoring.icon;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	private TilePane myIconPane;
	private Map<ImageView, String> myImagePaths;

	private final ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<>();
	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 6;
	private final int NUM_COLS = 2;

	public IconPane() {
		mySelectedIcon.addListener((o, s1, s2) -> setSelectedEffect(s1, s2));
		myImagePaths = new HashMap<>();
		myScrollPane = new ScrollPane();
		myScrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myScrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
		myScrollPane.setFitToWidth(true);
		initializeGridPane();
		myScrollPane.setPadding(new Insets(INSET_VALUE));
	}

	private void initializeGridPane() {
		myIconPane = new TilePane();
		myIconPane.setPrefColumns(NUM_COLS);
		myIconPane.setHgap(INSET_VALUE);
		myIconPane.setVgap(INSET_VALUE);
		myScrollPane.setContent(myIconPane);
	}

	/**
	 * Show all icons representing the relevant file types as specified by this
	 * subclass of AbstractIconPane.
	 * 
	 * @param directory
	 */
	public void showIcons(File directory, IConverter fileConverter) {
		clearIconPane();
		initializeGridPane();
		Collection<String> imagePaths = fileConverter.getImages(directory);
		for (String path : imagePaths) {
			ImageView iv = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
			// icon.getWidthProperty().set(myIconPane.getTileWidth());
			// icon.getHeightProperty().set(myIconPane.getTileHeight());
			iv.setOnMouseClicked(e -> setSelectedIcon(iv));
			myIconPane.getChildren().add(iv);
			myImagePaths.put(iv, path);
		}
		setSelectedIcon(null);
	}

	/**
	 * Return the JavaFX Node used to display this IconPane.
	 * 
	 * @return
	 */
	public ScrollPane getIconPane() {
		return myScrollPane;
	}

	private void clearIconPane() {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
		myScrollPane.setContent(null);
	}

	private void setSelectedEffect(ImageView oldIv, ImageView newIv) {
		if (oldIv == null) {
			newIv.setEffect(new Glow(GLOW_PERCENTAGE));
			return;
		}
		if (newIv == null) {
			oldIv.setEffect(null);
			return;
		}
		oldIv.setEffect(null);
		newIv.setEffect(new Glow(GLOW_PERCENTAGE));
	}

	private void setSelectedIcon(ImageView iv) {
		mySelectedIcon.set(iv);
	}

	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
	}

}
