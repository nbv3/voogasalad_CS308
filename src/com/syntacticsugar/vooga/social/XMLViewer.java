package com.syntacticsugar.vooga.social;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.authoring.library.IRefresher;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class XMLViewer extends ListViewer {

	
	private int mySelectedItemID = Integer.MIN_VALUE;
	private IUpdater myUpdater;

	public XMLViewer(IUpdater updater){
		super();
		myUpdater = updater;
		myView = (VBox) makeMyViewer("Downloadable Games");
		populateListFromDatabase();
	}	
	
	private Node makeMyViewer(String viewerTitle) {
		Node refreshButton = GUIFactory.buildButton("Refresh", e-> refresh(), 100.0, null);
		Collection<Node> buttons = new ArrayList<Node>(); buttons.add(refreshButton);
		VBox view = GUIFactory.buildTitledPaneWithButtons(makeContentBox(), viewerTitle, buttons);
		return view;
	}
	
	private void populateListFromDatabase() {
		JSONObject XMLs = WebConnector.getXMLs();
		while(XMLs.keys().hasNext()){
			JSONArray array;
			try {
				array = XMLs.getJSONArray((String) XMLs.keys().next());
				for(int i = 0; i< array.length(); i++){
					JSONObject current = (JSONObject) array.get(i);
					addElementToList(makeListElement(current.getString("gamename"),
							current.getString("author"), Integer.parseInt(current.getString("id"))));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}	
		}
	}
	
	private void refresh() {
		populateListFromDatabase();
	}

	private Node makeListElement(String itemName, String itemData, int itemID) {
		HBox listElement = new HBox();
		listElement.getChildren().add(
				GUIFactory.buildAnchorPane(GUIFactory.buildTitleNode(itemName),
						GUIFactory.buildTitleNode(itemData)));
		listElement.setOnMouseClicked(e-> {setCurrentlySelected(itemID); myUpdater.update(itemID);});
		return listElement;
	}
	
	private void setCurrentlySelected(int id){
		mySelectedItemID = id;
	}
	
	public int getCurrentlySelected(){
		return mySelectedItemID;
	}

}
