package authoring.level;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;

import authoring.data.TileImplementation;
import authoring.icons.ImageFileFilter;
import authoring.icons.panes.ImageIconPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class TileEditor {

	private VBox myContainer;
	private ImageIconPane myIconPane;
	
	public TileEditor(MapEditor mapEditor) {
		Button selectAll = buildButton("Select All", e -> mapEditor.selectAllTiles());
		Button clearAll = buildButton("Clear All", e -> mapEditor.clearAllTiles());

		Button makeDest = buildButton("Make Destination", e -> mapEditor.markDestination());
		Button removeDest = buildButton("Remove Destination", e -> mapEditor.unmarkDestination());
		makeDest.setMaxWidth(Double.MAX_VALUE);
		removeDest.setMaxWidth(Double.MAX_VALUE);
		VBox dest = new VBox();
		dest.getChildren().addAll(makeDest, removeDest);
		dest.setSpacing(3);
		
		
		ComboBox<TileImplementation> typeChooser = buildImplementationChooser();

		Button addNewImage = buildButton("Add New Image", e -> selectNewImage(typeChooser.getSelectionModel().getSelectedItem()));
		myIconPane = new ImageIconPane();
		Button applyChanges = buildButton("Apply", 
							e -> mapEditor.applyTileChanges(
								 typeChooser.getSelectionModel().getSelectedItem(),
								 myIconPane.getSelectedImagePath()));
		
		AnchorPane top = buildAnchorPane(selectAll, clearAll);
		AnchorPane middle = buildAnchorPane(typeChooser, dest);
		AnchorPane bottom = buildAnchorPane(addNewImage, applyChanges);
		
		myContainer = new VBox();
		myContainer.setSpacing(10);
		myContainer.setPadding(new Insets(10, 10, 10, 10));
		myContainer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		myContainer.getChildren().addAll(top,
										 middle,
										 myIconPane.getIconPane(),
										 bottom);
		VBox.setVgrow(myIconPane.getIconPane(), Priority.ALWAYS);
	}

	private AnchorPane buildAnchorPane(Node left, Node right) {
		AnchorPane anchor = new AnchorPane();
		anchor.getChildren().addAll(left, right);
		AnchorPane.setLeftAnchor(left, 0.0);
		AnchorPane.setRightAnchor(right, 0.0);
		return anchor;
	}
	
	private Button buildButton(String title, EventHandler<ActionEvent> action) {
		Button button = new Button(title);
		button.setOnAction(action);
		return button;
	}
	
	private ComboBox<TileImplementation> buildImplementationChooser() {
		ComboBox<TileImplementation> box = new ComboBox<TileImplementation>();
		box.setPromptText("Select tile type");
		box.getItems().addAll(TileImplementation.values());
		box.valueProperty().addListener((o, s1, s2) -> updateSelectedType(s2));
		return box;
	}
	
	private void updateSelectedType(TileImplementation type) {
		showImageOptions(type);
	}
	
	private void showImageOptions(TileImplementation type) {
		File imgDirectory = new File(ResourceManager.getString(String.format("%s%s", type, "_images")));
		File[] files = imgDirectory.listFiles(new ImageFileFilter());
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i=0; i<files.length; i++) {
			imagePaths.add(files[i].getName());
		}
		myIconPane.showIcons(imagePaths);
	}
	
	private void selectNewImage(TileImplementation type) {
		if (type == null) {
			AlertBoxFactory.createObject("Select a tile type.");
			return;
		}
		// TODO : New Image selection
		// Present the user with a file chooser (filtered to only show image files)
		// and allow them to select as many images as they like. Once selected, move 
		// the chosen images into the appropriate folder (either images/path or 
		// images/scenery, depending on the value of the TileTypeChooser combobox at the time).
		System.out.println("Adding new " + type + " image");
	}
	
	public VBox getControlBox() {
		return myContainer;
	}
	
}
