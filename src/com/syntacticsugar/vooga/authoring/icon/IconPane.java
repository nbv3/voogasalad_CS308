package com.syntacticsugar.vooga.authoring.icon;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.dragdrop.DragDropManager;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class IconPane {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	private Map<Icon, String> myImagePaths;
	private Map<Icon, ObjectData> myData;
	private Icon mine;

	private final ObjectProperty<Icon> mySelectedIcon = new SimpleObjectProperty<>();
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
		myData = new HashMap<Icon, ObjectData>();
	}

	private void initializeGridPane() {
		myIconPane = new TilePane();
		myIconPane.setPrefColumns(NUM_COLS);
		myIconPane.setHgap(INSET_VALUE);
		myIconPane.setVgap(INSET_VALUE);
		myScrollPane.setContent(myIconPane);
	}

	// private void addColumnConstraints() {
	// for (int i=0; i<NUM_COLS; i++) {
	// ColumnConstraints c1 = new ColumnConstraints();
	// c1.setPercentWidth(100.0 / (1.0*NUM_COLS));
	// myIconPane.getColumnConstraints().add(c1);
	// }
	// }

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
			Icon icon = new Icon(path);
			// icon.getWidthProperty().set(myIconPane.getTileWidth());
			// icon.getHeightProperty().set(myIconPane.getTileHeight());
			icon.setOnDragDetected((MouseEvent e) -> DragDropManager.createDragClipBoards(icon, e));
//			icon.setOnMouseClicked(e -> setSelectedIcon(icon));
			icon.setOnMouseClicked(e -> setMine(icon));
			myIconPane.getChildren().add(icon);
			myImagePaths.put(icon, path);
		}
		setSelectedIcon(null);
	}

	private void setMine(Icon i) {
		setSelectedIcon(i);
		mine = i;
	}

	public void showIcons(File directory, Map<Icon, ObjectData> map) {
		myData = map;
		clearIconPane();
		initializeGridPane();
		for (Icon i : map.keySet()) {
			i.setOnDragDetected((MouseEvent e) -> DragDropManager.createDragClipBoards(i, e));
			i.setOnMouseClicked(e -> setSelectedIcon(i));
			i.setOnMouseClicked(e -> setMine(i));

			myIconPane.getChildren().add(i);
			myImagePaths.put(i, map.get(i).getImagePath());
		}
		setSelectedIcon(null);
	}

	public ObjectData getCurrentData() {
		System.out.println("Get Data " + myData.get(mine));
		return myData.get(mine);
	}

	/**
	 * Return the JavaFX Node used to display this IconPane.
	 * 
	 * @return
	 */
	public ScrollPane getIconPane() {
		return myScrollPane;
	}

	protected void clearIconPane() {
		myIconPane.getChildren().clear();
		myImagePaths.clear();
		myScrollPane.setContent(null);
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
