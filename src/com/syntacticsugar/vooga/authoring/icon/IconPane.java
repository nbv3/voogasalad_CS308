package com.syntacticsugar.vooga.authoring.icon;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.dragdrop.DragDropManager;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TileImplementation;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class IconPane implements IVisualElement, IDirectoryViewer<String> {

	private ScrollPane myScrollPane;
	private TilePane myIconPane;
	private Map<ImageView, String> myImagePaths;
	private Icon selectedTile;

	public Icon getSelectedTile() {
		return selectedTile;
	}

	public void setSelectedTile(Icon selectedTile) {
		this.selectedTile = selectedTile;
	}

	private final ObjectProperty<ImageView> mySelectedIcon = new SimpleObjectProperty<>();
	private final double GLOW_PERCENTAGE = 0.75;
	private final double INSET_VALUE = 6;
	private final int NUM_COLS = 3;

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
	public void addPreviewListener(ChangeListener<ImageView> event){
		mySelectedIcon.addListener(event);
	}
	private void initializeGridPane() {
		myIconPane = new TilePane();
		myIconPane.setPrefColumns(NUM_COLS);
		myIconPane.setHgap(INSET_VALUE);
		myIconPane.setVgap(INSET_VALUE);
		myScrollPane.setContent(myIconPane);
		myIconPane.maxWidthProperty().set(myScrollPane.viewportBoundsProperty().get().getWidth());
	}

	@Override
	public void showDirectoryContents(File directory, IConverter<String> fileConverter) {
		clearIconPane();
		initializeGridPane();
		Collection<String> imagePaths = fileConverter.getContent(directory);
		for (String path : imagePaths) {
			ImageView iv = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream(path)));
			iv.fitWidthProperty().bind(myIconPane.maxWidthProperty().divide(NUM_COLS).subtract(INSET_VALUE));
			iv.fitHeightProperty().bind(iv.fitWidthProperty());
			iv.setOnMouseClicked(e -> setSelectedIcon(iv));
			myIconPane.getChildren().add(iv);
			myImagePaths.put(iv, path);
		}
	}

	@Override
	public Node getView() {
		return myScrollPane;
	}

	/**
	 * Return the String image path representing the currently selected Tile.
	 * @return
	 */
	public String getSelectedImagePath() {
		return myImagePaths.get(mySelectedIcon.get());
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

}
