package authoring.level;

import java.io.File;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import authoring.data.TileImplementation;
import authoring.icons.panes.ImageIconPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class MapEditorControls {

	private VBox myContainer;
	private TileImplementation mySelectedType;
	private ImageIconPane myIconPane;
	
	public MapEditorControls(IMapEditor mapEditor) {
		
		myIconPane = new ImageIconPane();
		ComboBox<TileImplementation> typeChooser = buildImplementationChooser();

		Button selectAll = 
				GUIFactory.buildButton("Select All", 
						e -> mapEditor.selectAllTiles(),
						null, null);
		Button clearAll = 
				GUIFactory.buildButton("Clear All", 
						e -> mapEditor.clearAllTiles(),
						null, null);

		Button makeDest = 
				GUIFactory.buildButton("Make Destination", 
						e -> mapEditor.setAsDestination(true),
						Double.MAX_VALUE, null);
		
		Button removeDest = 
				GUIFactory.buildButton("Remove Destination", 
						e -> mapEditor.setAsDestination(false),
						Double.MAX_VALUE, null);
		
		Button addNewImage = 
				GUIFactory.buildButton("Add New Image", 
						e -> selectNewImage(),
						null, null);

		Button applyChanges = 
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
		myContainer.setPadding(new Insets(10, 10, 10, 10));
		myContainer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		myContainer.getChildren()
			.addAll(top, middle, myIconPane.getIconPane(), bottom);
		VBox.setVgrow(myIconPane.getIconPane(), Priority.ALWAYS);
	}
	
	private void applyChanges(IMapEditor editor) {
		editor.setImplementation(mySelectedType);
		String imagePath = myIconPane.getSelectedImagePath();
		if (imagePath == null) {
			AlertBoxFactory.createObject("Please select an image.");
			return;
		}
		editor.setImagePath(imagePath);
	}
	
	private ComboBox<TileImplementation> buildImplementationChooser() {
		ComboBox<TileImplementation> box = new ComboBox<TileImplementation>();
		box.setPromptText("Select tile type");
		box.getItems().addAll(TileImplementation.values());
		box.valueProperty().addListener((o, s1, s2) -> updateSelectedType(s2));
		return box;
	}
	
	private void updateSelectedType(TileImplementation type) {
		mySelectedType = type;
		showImageOptions(type);
	}
	
	private void showImageOptions(TileImplementation type) {
		File imgDirectory = new File(ResourceManager.getString(String.format("%s%s", type, "_images")));
		myIconPane.showIcons(imgDirectory);
	}
	
	private void selectNewImage() {
		if (mySelectedType == null) {
			AlertBoxFactory.createObject("Select a tile type.");
			return;
		}
		// TODO : New Image selection
		// Present the user with a file chooser (filtered to only show image files)
		// and allow them to select as many images as they like. Once selected, move 
		// the chosen images into the appropriate folder (either images/path or 
		// images/scenery, depending on the value of the TileTypeChooser combobox at the time).
		System.out.println("Adding new " + mySelectedType + " image");
	}
	
	public Node getContent() {
		return myContainer;
	}
	
}
