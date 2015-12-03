package com.syntacticsugar.vooga.authoring.objectediting;

import java.io.File;

import com.syntacticsugar.vooga.authoring.icon.Icon;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ObjectEditor {

	private GridPane myView;
	private AttributeViewer myAttributeViewer;
	private CollisionViewer myCollisionViewer;
	private Icon myIcon;
	private Button myCreateButton;
	private ObjectData currentData;

	public ObjectEditor(){
		currentData = new ObjectData();
		currentData.setType(GameObjectType.ENEMY);
		myAttributeViewer = new AttributeViewer();
		myCollisionViewer = new CollisionViewer();
		myView = buildView();			
	}
	
	private GridPane buildView() {
		AnchorPane attributeAnchor = buildButtons(
				e -> buildNewAttribute(),
				e -> myAttributeViewer.removeSelectedItem(),
				ResourceManager.getString("attributes_added"));
		
		AnchorPane collisionAnchor = buildButtons(
				e -> buildNewCollision(),
				e -> myCollisionViewer.removeSelectedItem(),
				"Collisions Defined");
		
		GridPane grid = createMainGrid();
				
		VBox att = createEditorVBox(attributeAnchor, myAttributeViewer.getView());
		
		VBox coll = createEditorVBox(collisionAnchor, myCollisionViewer.getView());
		
		GridPane iconGrid = createIconGrid();
		
		myCreateButton = GUIFactory.buildButton("Save Object", e -> saveObject(), null, null);
		myCreateButton.setAlignment(Pos.CENTER_RIGHT);
		myCreateButton.setDisable(true);
		
		grid.add(iconGrid, 0, 0, 1, 1);
		grid.add(coll, 0, 1, 2, 1);
		grid.add(att, 1, 0, 1, 1);
		grid.add(myCreateButton, 1, 2, 1, 1);
		GridPane.setHalignment(myCreateButton, HPos.RIGHT);
		GridPane.setValignment(myCreateButton, VPos.CENTER);
		return grid;
	}

	public void displayData(ObjectData data) {
		if (data != null) {
			if (myCreateButton.isDisabled()) {
				myCreateButton.setDisable(false);
			}
			this.currentData = data;
			myAttributeViewer.displayData(data.getAttributes());
			myCollisionViewer.displayData(data.getCollisionMap());
			myIcon.setImage(new Image(ResourceManager.getResource(this, data.getImagePath())));
		}
	}
	
	private void saveObject() {
		currentData.setAttributes(myAttributeViewer.getData());
		currentData.setCollisionMap(myCollisionViewer.getData());
		currentData.setType(currentData.getType());
		
		TextInputDialog td = new TextInputDialog("Name your creation");
		td.showAndWait();
		if (td.getResult() == null)
			return;
		currentData.setObjectName(td.getResult());

		//TODO : EXTRACT FILE CHOOSING INTO A UTILITY
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("XML Data", "*.xml"));
		fileChooser.setTitle("Save Resource File");
		fileChooser.setInitialDirectory(new File(ResourceManager.getString(String.format("%s_%s", currentData.getType().toString().toUpperCase(), "data"))));
		fileChooser.setInitialFileName(String.format("%s.%s", currentData.getObjectName(), "xml"));
		File selectedFile = fileChooser.showSaveDialog(new Stage());
		if (selectedFile != null) {
			XMLHandler<ObjectData> xml = new XMLHandler<>();
			xml.write(currentData, selectedFile);
		}
	}
	
	private void selectImage() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.jpeg", "*.gif", "*.png"));
		fileChooser.setTitle("Save Resource File");
		fileChooser.setInitialDirectory(new File(ResourceManager.getString("images")));
		File selectedFile = fileChooser.showOpenDialog(new Stage());
		if (selectedFile != null) {
			currentData.setImagePath(selectedFile.getName());
			myIcon.setImage(new Image(getClass().getClassLoader().getResourceAsStream(selectedFile.getName())));
		}
	}
	
	private void buildNewAttribute() {
		new AttributeMakerWizard(currentData.getType(), myAttributeViewer.getData());
	}
	
	private void buildNewCollision() {
		new CollisionMakerWizard(currentData.getType(), myCollisionViewer.getData());
	}
	
	public Node getView(){
		return myView;
	}

	private GridPane createIconGrid() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		myIcon = new Icon("gray.png");
		Button button = GUIFactory.buildButton("Select Image", e -> selectImage(), null, null);
		grid.getChildren().addAll(button, myIcon);
		GridPane.setConstraints(button, 0, 0, 1, 1);
		GridPane.setConstraints(myIcon, 0, 1, 1, 1);
		GridPane.setHalignment(myIcon, HPos.CENTER);
		GridPane.setHalignment(button, HPos.LEFT);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		return grid;
	}

	private VBox createEditorVBox(AnchorPane anchor, Node viewer) {
		VBox att = new VBox();
		att.getChildren().addAll(anchor, viewer);
		att.setSpacing(10);
		return att;
	}

	private GridPane createMainGrid() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.getColumnConstraints().addAll(
				columnWithPercentage(50),
				columnWithPercentage(50));
		grid.getRowConstraints().addAll(
				rowWithPercentage(45),
				rowWithPercentage(45),
				rowWithPercentage(10));
		grid.setHgap(10); grid.setVgap(10);
		grid.setPadding(new Insets(10));
		return grid;
	}
	
	private ColumnConstraints columnWithPercentage(double percent) {
		ColumnConstraints c = new ColumnConstraints();
		c.setPercentWidth(percent);
		return c;
	}
	
	private RowConstraints rowWithPercentage(double percent) {
		RowConstraints r = new RowConstraints();
		r.setPercentHeight(percent);
		return r;
	}
	
	private AnchorPane buildButtons(EventHandler<ActionEvent> add, EventHandler<ActionEvent> remove, String label) {
		Button a = new Button();
		a.setText("+");
		a.setOnAction(add);
		a.setPrefWidth(25);
		Button r = new Button();
		r.setText("-");
		r.setOnAction(remove);
		r.setPrefWidth(25);
		GridPane buttonGrid = new GridPane();
		buttonGrid.add(a, 0, 0, 1, 1);
		buttonGrid.add(r, 1, 0, 1, 1);
		buttonGrid.setHgap(5);
		a.setAlignment(Pos.CENTER);
		r.setAlignment(Pos.CENTER);
		GridPane.setHgrow(a, Priority.ALWAYS);
		GridPane.setHgrow(r, Priority.ALWAYS);
		AnchorPane anchor = GUIFactory.buildAnchorPane(new Label(label), buttonGrid);
		return anchor;
	}
	
}
