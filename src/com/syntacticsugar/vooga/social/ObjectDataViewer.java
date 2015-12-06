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
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.gui.factory.MsgInputBoxFactory;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import com.syntacticsugar.vooga.xml.XMLHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ObjectDataViewer extends ListViewer {

	private int mySelectedItemID = Integer.MIN_VALUE;
	private JSONObject myData;
	private CommentViewer myCommentBox;
	private IComments myCommentInterface;

	public ObjectDataViewer() {
		super();
		myView = makeMyViewer("Information:");
		myView.prefHeight(250);
		myCommentInterface = new IComments(){
			
//			@Override
//			public String getGameName() {
//				return getSelectedGameName();
//			}
			@Override
			public int getGameID() {
				return getSelectedID();
			}
			@Override
			public void updateData() {
				update(mySelectedItemID);
			}
			@Override
			public void updateComments() {
				try {
					myCommentBox.update();
				} catch (JSONException e) {
				}	
			}
		};	
		
	}

	private Node makeMyViewer(String viewerTitle) {
		VBox view = GUIFactory.buildTitledVBox(makeContentBox(), viewerTitle);
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
				addElementToList(listElement);
			}
			myCommentBox = new CommentViewer(myCommentInterface);
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
		//	launchPropertiesBox();
			WebConnector.postXML(JSONHelper.createXMLJSON("Michael", "Tetris", "tetris", XMLHandler.fileToString(selectedFile)));
		}
	}
	
	private void launchPropertiesBox(){
		MsgInputBoxFactory inputFactory = new MsgInputBoxFactory("Fill in author name, game name, and description");
		
	}

	public void update(int id) {
		myData = getJSONObject(id);
		populateList(myData);
		mySelectedItemID = id;
	}
	
	private int getSelectedID(){
		return mySelectedItemID;
	}
	
//	private String getSelectedGameName() {
//		try {
//			return myData.getString("gamename");
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}

}
