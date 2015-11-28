package authoring.level;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.util.ResourceManager;

import authoring.library.icons.panes.ImageIconPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TileEditor {

	private VBox myContainer;
	private Button mySelectAllButton;
	private Button myClearAllButton;
	private ComboBox<String> myTileTypeChooser;
	private Button myAddNewImageButton;
	private Button myApplyButton;
	private ImageIconPane myIconPane;
	
	public TileEditor(MapEditor mapEditor) {
		mySelectAllButton = buildButton("Select All", e -> mapEditor.selectAllTiles());
		myClearAllButton = buildButton("Clear All", e -> mapEditor.clearAllTiles());
		myAddNewImageButton = buildButton("Add New Image", e -> selectNewImage());
		myTileTypeChooser = buildTypeChooser();
		
		myApplyButton = buildButton(
				"Apply", 
				e -> mapEditor.applyTileChanges(
						myTileTypeChooser.getSelectionModel().getSelectedItem(), 
						myIconPane.getSelectedImagePath()));
		
		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().addAll(myAddNewImageButton, myApplyButton);
		AnchorPane.setRightAnchor(myApplyButton, 0.0);
		AnchorPane.setLeftAnchor(myAddNewImageButton, 0.0);
		myIconPane = new ImageIconPane();
		
		myContainer = new VBox();
		myContainer.setSpacing(10);
		myContainer.setPadding(new Insets(10, 10, 10, 10));
		myContainer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		myContainer.getChildren().addAll(mySelectAllButton, 
										 myClearAllButton, 
										 myTileTypeChooser, 
										 myIconPane.getIconPane(),
										 anchor);
		VBox.setVgrow(myIconPane.getIconPane(), Priority.ALWAYS);
	}
	
	private Button buildButton(String title, EventHandler<ActionEvent> action) {
		Button select = new Button(title);
		select.setOnAction(action);
		return select;
	}
	
	private ComboBox<String> buildTypeChooser() {
		ComboBox<String> box = new ComboBox<String>();
		box.setPromptText("Select tile type");
		box.getItems().add("Path");
		box.getItems().add("Scenery");
		box.valueProperty().addListener((o, s1, s2) -> showImageOptions(s2));
		return box;
	}
	
	private void selectNewImage() {
		// TODO : New Image selection
		// Present the user with a file chooser (filtered to only show image files)
		// and allow them to select as many images as they like. Once selected, move 
		// the chosen images into the appropriate folder (either images/path or 
		// images/scenery, depending on the value of the TileTypeChooser combobox at the time).
		System.out.println("Adding new image");
	}
	
	private void showImageOptions(String type) {
		File imgDirectory = new File(ResourceManager.getString(String.format("%s%s", type, "_images")));
		File[] files = imgDirectory.listFiles(new ImageFileFilter());
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i=0; i<files.length; i++) {
			imagePaths.add(files[i].getName());
		}
		myIconPane.showIcons(imagePaths);
	}
	
	public VBox getControlBox() {
		return myContainer;
	}
	
}
