package com.syntacticsugar.vooga.authoring.objectediting;

import java.util.ArrayList;
import java.util.Collection;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditingViewer {

	protected VBox myView;
	protected Button myAddButton;
	protected Button myRemoveButton;
	protected ListView<HBox> myListView;
	protected Insets myPadding = new Insets(10,10,10,10);
	
	public EditingViewer(String viewerTitle){
		myView = new VBox();
		myView.setPadding(myPadding);
		myView.getChildren().add(makeTitleStrip(viewerTitle));
		makeContentBox();
	}
	
	private void makeContentBox(){ 
		// makes the VBox that contains the ListView and the buttons.
		myListView = new ListView<HBox>();
		myView.getChildren().add(myListView);
	}
	
	private AnchorPane makeTitleStrip(String title){
		Collection<Node> buttons = new ArrayList<Node>(); 
		buttons.add(makeAddButton()); 
		buttons.add(makeRemoveButton());
		AnchorPane titleStrip = (AnchorPane) GUIFactory.buildTitleNodeWithButtons(title, buttons);
		titleStrip.setPadding(myPadding);
		return titleStrip;
	}
	
	
	private Button makeAddButton(){
		myAddButton = GUIFactory.buildButton(ResourceManager.getString("add_symbol"), null, 30.0, null);
		return myAddButton;
	}
	
	private Button makeRemoveButton(){
		myRemoveButton = GUIFactory.buildButton(ResourceManager.getString("remove_symbol"), null, 30.0, null);
		return myRemoveButton;
	}
	
	protected void addElementToList(HBox item){
		myListView.getItems().add(item);
	}
	
	public VBox getView(){
		return myView;
	}

}
