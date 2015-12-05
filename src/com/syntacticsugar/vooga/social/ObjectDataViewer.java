package com.syntacticsugar.vooga.social;

import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ObjectDataViewer extends ListViewer {

	private int mySelectedItemID = Integer.MIN_VALUE;

	public ObjectDataViewer() {
		super();
		myView = makeMyViewer("Information:");
		myView.prefHeight(250);
	}

	private Node makeMyViewer(String viewerTitle) {
		VBox view = GUIFactory.buildTitledVBox(makeContentBox(), viewerTitle);
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
				Node listElement = makeListElement(key, object.get(key).toString());
				object.remove(key);
				addElementToList(listElement);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private JSONObject getJSONObject(int id) {

		JSONObject XMLs = WebConnector.getXMLs();
		JSONArray array;
		try {
			array = XMLs.getJSONArray("xmls");
			System.out.println(array.toString());
			for (int i = 0; i < array.length(); i++) {
				JSONObject current = (JSONObject) array.get(i);
				if ((int) current.get("id") == id) {
					System.out.println(current.toString());
					return current;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return new JSONObject();
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
