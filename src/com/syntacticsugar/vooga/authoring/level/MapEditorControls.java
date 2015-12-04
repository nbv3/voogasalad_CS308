package com.syntacticsugar.vooga.authoring.level;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.dragdrop.DragDropManager;
import com.syntacticsugar.vooga.authoring.icon.Icon;
import com.syntacticsugar.vooga.authoring.icon.IconPane;
import com.syntacticsugar.vooga.authoring.icon.ImageFileFilter;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.TileImplementation;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MapEditorControls{

	private VBox myContainer;
	private Button selectAll;
	private Button clearAll;
	private Button makeDest;
	private Button removeDest;
	private Button addNewImage;
	private Button applyChanges;
	private TileImplementation mySelectedType;
	private IconPane myIconPane;
	private ImageView previewTile = new ImageView(); 

	public ImageView getPreviewTile() {
		return previewTile;
	}

	public void setPreviewTile(ImageView previewTile) {
		this.previewTile = previewTile;
	}

	public MapEditorControls(IMapEditor mapEditor) {

		myIconPane = new IconPane();
		previewTile.setOnDragDetected(event -> DragDropManager.createTileClipboard(myIconPane.getSelectedTile(), mySelectedType.name(), event));
		myIconPane.addPreviewListener((o,s1,s2)-> updatePreview());
		ComboBox<TileImplementation> typeChooser = buildImplementationChooser();

		selectAll = 
				GUIFactory.buildButton("Select All", 
						e -> mapEditor.selectAllTiles(),
						null, null);
		clearAll = 
				GUIFactory.buildButton("Clear All", 
						e -> mapEditor.clearAllTiles(),
						null, null);

		makeDest = 
				GUIFactory.buildButton("Make Destination", 
						e -> mapEditor.setAsDestination(true),
						Double.MAX_VALUE, null);

		removeDest = 
				GUIFactory.buildButton("Remove Destination", 
						e -> mapEditor.setAsDestination(false),
						Double.MAX_VALUE, null);

		addNewImage = 
				GUIFactory.buildButton("Add New Image", 
						e -> createNewImage(),
						null, null);

		applyChanges = 
				GUIFactory.buildButton("Apply", 
						e -> applyChanges(mapEditor), 
						null, null);

		VBox dest = new VBox();
		dest.getChildren().addAll(makeDest, removeDest);
		dest.setSpacing(3);
		dest.setAlignment(Pos.CENTER);

		AnchorPane top = GUIFactory.buildAnchorPane(selectAll, clearAll);
		AnchorPane middle = GUIFactory.buildAnchorPane(typeChooser, dest);
		AnchorPane bottom = GUIFactory.buildAnchorPane(addNewImage, applyChanges);
		
		myContainer = new VBox();
		myContainer.setSpacing(10);
		myContainer.setPadding(new Insets(10));
		myContainer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		myContainer.getChildren()
		.addAll(top, middle, myIconPane.getIconPane(), bottom);
		VBox.setVgrow(myIconPane.getIconPane(), Priority.ALWAYS);
	}

	private void updatePreview() {
		System.out.println(myIconPane.getSelectedImagePath());

		previewTile.setImage(new Image(getClass().getClassLoader().getResourceAsStream(myIconPane.getSelectedImagePath())));
	}
	
	private void applyChanges(IMapEditor editor) {
		if (mySelectedType == null) {
			AlertBoxFactory.createObject("Please select a tile type.");
			return;
		}
		String imagePath = myIconPane.getSelectedImagePath();
		if (imagePath == null) {
			AlertBoxFactory.createObject("Please select an image.");
			return;
		}
		editor.setImplementation(mySelectedType);
		editor.setImagePath(imagePath);
	}

	private ComboBox<TileImplementation> buildImplementationChooser() {
		ComboBox<TileImplementation> box = new ComboBox<TileImplementation>();
		box.setPromptText("Tile Type");
		box.getItems().addAll(TileImplementation.values());
		box.valueProperty().addListener((o, s1, s2) -> updateSelectedType(s2));
		return box;
	}

	private void updateSelectedType(TileImplementation type) {
		mySelectedType = type;
		showImageOptions(type);
	}

	private void showImageOptions(TileImplementation type) {
		File imgDirectory = new File(
				ResourceManager.getString(String.format("%s%s", mySelectedType, "_images")));
				myIconPane.showIcons(imgDirectory, e -> convertImageFiles(imgDirectory));
	}
		
	private Collection<String> convertImageFiles(File directory) {
		File[] files = directory.listFiles(new ImageFileFilter());
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i=0; i<files.length; i++) {
			imagePaths.add(files[i].getName());
		}
		return imagePaths;
	}

	private void createNewImage(){
		if (mySelectedType == null) {
			AlertBoxFactory.createObject("Select a tile type.");
			return;
		}
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Add Image File");
		chooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.jpeg", "*.gif", "*.png"));
		File selectedFile = chooser.showOpenDialog(new Stage());
		if(selectedFile != null) {
			try {
				String path = ResourceManager.getString(String.format("%s%s", mySelectedType, "_images"));
				Files.copy(selectedFile.toPath(),
						(new File(path + "/" + mySelectedType.toString().toLowerCase() + "_" + selectedFile.getName())).toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				AlertBoxFactory.createObject("Image already exists. Please select another.");
			}
		}
		showImageOptions(mySelectedType);
	}

	public Node getContent() {
		return myContainer;
	}
}
