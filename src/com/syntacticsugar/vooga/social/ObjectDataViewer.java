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
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
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

	public ObjectDataViewer() {
		super();
		myView = makeMyViewer("Information:");
		myView.prefHeight(250);
		myProperties = new HashMap<String, String>();
	}

	private Node makeMyViewer(String viewerTitle) {
		VBox view = GUIFactory.buildTitledPane(makeContentBox(), viewerTitle);
		view.setPrefWidth(350);
		VBox buttons = new VBox();
		buttons.getChildren().addAll(GUIFactory.buildButton("Download", e -> {
		} , 100.0, null), GUIFactory.buildButton("Upload", e -> {
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

	private void downloadSelectedItem() {
		int id = mySelectedItemID;
		if (id == Integer.MIN_VALUE) {
			return;
		}
	}

	private void makePopupFileChooser() {
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Choose an XML file.");
		chooser.getExtensionFilters().add(new ExtensionFilter("Image Files", "*.xml", "*.XML"));
		File selectedFile = chooser.showOpenDialog(new Stage());
		/*if (selectedFile != null) {
			try {
				String path = ResourceManager.getString(String.format("%s%s", mySelectedType, "_images"));
				Files.copy(selectedFile.toPath(),
						(new File(path + "/" + mySelectedType.toString().toLowerCase() + "_" + selectedFile.getName()))
								.toPath(),
						StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				AlertBoxFactory.createObject("Image already exists. Please select another.");
			}
			
		}*/
	}
	

	public void update(int id) {
		populateList(getJSONObject(id));
		mySelectedItemID = id;
	}

}
