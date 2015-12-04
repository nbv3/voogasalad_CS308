package com.syntacticsugar.vooga.social;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ObjectDataViewer extends ListViewer {

	private int mySelectedItemID = Integer.MIN_VALUE;
	
	public ObjectDataViewer(){
		super();
		makeMyViewer("Information:");
	}
	
	private Node makeMyViewer(String viewerTitle) {
		VBox view = GUIFactory.buildTitledPane(makeContentBox(), viewerTitle);
		HBox viewAndButtons = new HBox();
		viewAndButtons.getChildren().addAll(view, GUIFactory.buildButton("Download", e->{}, 100.0, null),
				GUIFactory.buildButton("Upload", e->{}, 100.0,null));
		return viewAndButtons;
	}
	
	private void populateList(JSONObject object){
		while (object.keys().hasNext()){
			String key = (String) object.keys().next();
			try {
				Node listElement = makeListElement(key, object.getString(key));
				addElementToList(listElement);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	private JSONObject getJSONObject(int id) {
		JSONObject XMLs = WebConnector.getXMLs();
		while (XMLs.keys().hasNext()) {
			JSONArray array;
			try {
				array = XMLs.getJSONArray((String) XMLs.keys().next());
				for (int i = 0; i < array.length(); i++) {
					JSONObject current = (JSONObject) array.get(i);
					if (Integer.parseInt(current.getString("id")) == id) {
						return current;
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return new JSONObject();
	}
	
	private Node makeListElement(String key, String value){
		Node keyNode = GUIFactory.buildTitleNode(key);
		Node valueNode = GUIFactory.buildTitleNode(value);
		return GUIFactory.buildAnchorPane(keyNode, valueNode);
	}
	
	private void downloadSelectedItem(){
		int id = mySelectedItemID;
		if (id == Integer.MIN_VALUE){
			return;
		}
	}
	
	public void update(int id){
		populateList(getJSONObject(id));
		mySelectedItemID = id;
	}
	
}
