package com.syntacticsugar.vooga.newsocial;

import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.social.CommentViewer;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.filechooser.FileChooserUtil;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import com.syntacticsugar.vooga.xml.XMLHandler;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser.ExtensionFilter;

public class DataViewer implements IVisualElement {

	private Node myView;
	private ListView<Node> myListView;
	private int mySelectedItemID = Integer.MIN_VALUE;
	private JSONObject myData;

	public DataViewer() {
		
		myView = makeView();		

	}

	private Node makeView() {
		myListView = new ListView<Node>();
		TitledPane view = GUIFactory.buildTitledPane("Information", myListView);
		view.setPrefWidth(350);
		return view;
	}

	private void populateList(JSONObject object) {
		clearList();
		try {
			while(object.keys().hasNext()){
				String key = (String) object.keys().next();
				String value = object.get(key).toString();
				Node listElement = makeListElement(key, value);
				object.remove(key);
				addElementToList(listElement);
			}
		//	myCommentBox.updateFromDataViewer(mySelectedItemID);
			} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private JSONObject getJSONObject(int id) {
		mySelectedItemID = id;
		return WebConnector.getXMLData(id);	
	}

	private Node makeListElement(String key, String value) {
		Node keyNode = GUIFactory.buildTitleNode(ResourceManager.getString(key));
		Node valueNode = GUIFactory.buildTitleNode(value);
		Node element = GUIFactory.buildAnchorPane(keyNode, valueNode);
		return element;
	}

	public void uploadItem() {
		makeUploadFileChooser();
	}

	public void downloadSelectedItem() {
		if (mySelectedItemID == Integer.MIN_VALUE)
			return;
		else {
			FileChooserUtil.saveFile("Choose a save location.", ".xml", null, selected -> {
					XMLHandler.writeXMLToFile(JSONHelper.extractXML(WebConnector.getXML(mySelectedItemID)),
							selected.toPath().toString());					
			});
		}
	}

	private void makeUploadFileChooser(){//EventHandler<ActionEvent> action) {
		ExtensionFilter filter = new ExtensionFilter("XML files", "*.xml", "*.XML");
		FileChooserUtil.loadFile("Choose an XML game file", filter, null, selected -> {
				WebConnector.postXML(JSONHelper.createXMLJSON(
						"Michael", "Tetris", "tetris", XMLHandler.fileToString(selected)));	
			});
	}
	
	

	public void update(int id) {
		myData = getJSONObject(id);
		mySelectedItemID = id;
		populateList(myData);
	}
	
	public void updateID(int id){
		mySelectedItemID = id;
	}
	
	public int getSelectedItemID(){
		return mySelectedItemID;
	}
	
	private void clearList(){
		myListView.getItems().clear();
	}
	
	private void addElementToList(Node element){
		myListView.getItems().add(element);
	}
	
	@ Override
	public Node getView(){
		return myView;
	}

}
