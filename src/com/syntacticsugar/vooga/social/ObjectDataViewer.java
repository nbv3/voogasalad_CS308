package com.syntacticsugar.vooga.social;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import com.syntacticsugar.vooga.xml.XMLHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ObjectDataViewer extends ListViewer {

	private int mySelectedItemID = Integer.MIN_VALUE;
	private Map<String, String> myProperties;
	//private ICommentsUpdater myCommentUpdater;
	private CommentViewer myCommentBox;

	public ObjectDataViewer() {
		super();
		myView = makeMyViewer("Information:");
		myView.prefHeight(250);
		myProperties = new HashMap<String, String>();
	/*	myCommentBox = new CommentViewer(new IComments(){
			@Override
			public String getSerializedComments(String gameName) {
				return getComments();
			}
			@Override
			public String getGameName() {
				return getSelectedGameName();
			}
			@Override
			public int getGameID() {
				return getSelectedID();
			}
			@Override
			public void updateData() {
				update(mySelectedItemID);
			}
		});	*/
	}

	private Node makeMyViewer(String viewerTitle) {
		VBox view = GUIFactory.buildTitledPane(makeContentBox(), viewerTitle);
		view.setPrefWidth(350);
		VBox buttons = new VBox();
		buttons.getChildren().addAll(GUIFactory.buildButton("Upload", e -> {uploadItem();
		} , 100.0, null), GUIFactory.buildButton("Download", e -> {downloadSelectedItem();
		} , 100.0, null));
		HBox viewAndButtons = new HBox(view,buttons);
		return viewAndButtons;
	}

	private void populateList(JSONObject object) {
		clearList();
		try {
			
			while(object.keys().hasNext()){
				String key = (String) object.keys().next();
				String value = object.get(key).toString();
				Node listElement = makeListElement(key, value);
				object.remove(key);
				//if (!key.equals("comments")) 
					addElementToList(listElement);
				myProperties.put(key, value);
			}
			} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private JSONObject getJSONObject(int id) {
		return WebConnector.getJSONObject(id);	
	}

	private Node makeListElement(String key, String value) {
		Node keyNode = GUIFactory.buildTitleNode(key);
		Node valueNode = GUIFactory.buildTitleNode(value);
		return GUIFactory.buildAnchorPane(keyNode, valueNode);
	}

	private void uploadItem() {
		makeUploadFileChooser();
	}

	private void downloadSelectedItem() {
		if (mySelectedItemID == Integer.MIN_VALUE)
			return;

		else {
			FileChooser chooser = new FileChooser();
			chooser.setInitialFileName(".xml");
			File selectedFile = chooser.showSaveDialog(new Stage());
			if (selectedFile != null) {

				XMLHandler.writeXMLToFile(JSONHelper.extractXML(WebConnector.getXML(mySelectedItemID)),
						selectedFile.toPath().toString());

			}
		}
	}

	private void makeUploadFileChooser(){//EventHandler<ActionEvent> action) {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Choose an XML file.");
		chooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.xml", "*.XML"));
		File selectedFile = chooser.showOpenDialog(new Stage());
		if (selectedFile != null) {
			WebConnector.postXML(JSONHelper.createJSON("Michael", "Tetris", "tetris", XMLHandler.fileToString(selectedFile), ""));
		}
	}
	

	public void update(int id) {
		populateList(getJSONObject(id));
		mySelectedItemID = id;
	}
	
	private int getSelectedID(){
		return mySelectedItemID;
	}
	
	private String getSelectedGameName(){
		return myProperties.get("gamename");
	}
	
	private String getComments(){
		return myProperties.get("comments");
	}

}
