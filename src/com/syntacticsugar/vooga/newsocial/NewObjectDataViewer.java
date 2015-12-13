package com.syntacticsugar.vooga.newsocial;

import java.util.Observable;
import java.util.Observer;

import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

public class NewObjectDataViewer implements IVisualElement, Observer {

	private Node myView;
	private ListView<Node> myListView;
	
	public NewObjectDataViewer(){
		myView = makeView();
	}
	
	private Node makeView() {
		myListView = new ListView<Node>();
		TitledPane view = GUIFactory.buildTitledPane("Information", myListView);
		view.setMaxWidth(Integer.MAX_VALUE);
		return view;
	}
	
	private void populateListView(JSONObject object){
		clearList();
		try {
			while (object.keys().hasNext()) {
				String key = (String) object.keys().next();
				String value = object.get(key).toString();
				Node listElement = makeListElement(key, value);
				object.remove(key);
				addElementToList(listElement);
			}
		} catch (JSONException e) {
			AlertBoxFactory.createObject("This item might contain corrupt data!");
		}
	}
	
	private Node makeListElement(String key, String value) {
		Node keyNode = GUIFactory.buildTitleNode(ResourceManager.getString(key));
		TextFlow valueNode = new TextFlow(new Text(value));
		valueNode.setMaxWidth(150);
		valueNode.setTextAlignment(TextAlignment.RIGHT);
		Node element = GUIFactory.buildAnchorPane(keyNode, valueNode);
		return element;
	}
	
	private void addElementToList(Node element){
		myListView.getItems().add(element);
	}
	
	private void clearList(){
		myListView.getItems().clear();
	}

	@Override
	public void update(Observable o, Object arg) {
		populateListView(WebConnector.getXMLData(((int) arg)));
	}

	@Override
	public Node getView() {
		return myView;
	}
	
}
