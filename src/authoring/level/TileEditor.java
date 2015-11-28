package authoring.level;

import com.syntacticsugar.vooga.util.ResourceManager;
import authoring.library.IconPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class TileEditor {

	private VBox myContainer;
	private Button mySelectAllButton;
	private Button myClearAllButton;
	private ComboBox<String> myTileTypeChooser;
	private IconPane myIconPane;
	
	public TileEditor(EventHandler<ActionEvent> selectAll, EventHandler<ActionEvent> clearAll) {
		mySelectAllButton = buildSelectAllButton(selectAll);
		myClearAllButton = buildClearAllButton(clearAll);
		myTileTypeChooser = buildTypeChooser();
		myIconPane = new IconPane();
		
		myContainer = new VBox();
		myContainer.setSpacing(10);
		myContainer.setPadding(new Insets(10, 10, 10, 10));
		
		myContainer.getChildren().addAll(mySelectAllButton, 
										 myClearAllButton, 
										 myTileTypeChooser, 
										 myIconPane.getIconPane());
	}
	
	private Button buildSelectAllButton(EventHandler<ActionEvent> selectAll) {
		Button select = new Button();
		select.setText("Select All");
		select.setOnAction(selectAll);
		return select;
	}
	
	private Button buildClearAllButton(EventHandler<ActionEvent> clearAll) {
		Button clear = new Button();
		clear.setText("Clear All");
		clear.setOnAction(clearAll);
		return clear;
	}
	
	private ComboBox<String> buildTypeChooser() {
		ComboBox<String> box = new ComboBox<String>();
		box.setPromptText("Select tile type");
		box.getItems().add("Path");
		box.getItems().add("Scenery");
		box.valueProperty().addListener((o, s1, s2) -> showImageOptions(s2));
		return box;
	}
	
	private void showImageOptions(String type) {
		String[] imagePaths = ResourceManager.getString(type).split(",");
		myIconPane.showImageOptions(imagePaths);
	}
	
	public VBox getContent() {
		return myContainer;
	}
	
}
