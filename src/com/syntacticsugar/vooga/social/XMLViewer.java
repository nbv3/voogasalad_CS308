package com.syntacticsugar.vooga.social;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class XMLViewer {

	private VBox myView;
	private ListView<HBox> myListView;
	private Insets myPadding = new Insets(10, 10, 10, 10);

	public XMLViewer(String viewerTitle){
		myView = (VBox) makeMyViewer(viewerTitle);
	}

	private Node makeContentBox() {
		myListView = new ListView<HBox>();
		return myListView;
	}

	private Node makeMyViewer(String viewerTitle) {
		Node refreshButton = GUIFactory.buildButton("Refresh", e->{}, 100.0, null);
		Collection<Node> buttons = new ArrayList<Node>(); buttons.add(refreshButton);
		//VBox view = GUIFactory.buildTitledNodeWithButtons(makeContentBox(), viewerTitle, buttons);
		return null;

	}
	
	private void populateListViewFromDatabase(){
		JSONObject XMLs = WebConnector.getXMLs();
	}
	
	private void addElementToList(HBox item) {
		myListView.getItems().add(item);
	}

	public VBox getView() {
		return myView;
	}

}
