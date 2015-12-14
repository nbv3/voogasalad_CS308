// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.newsocial.IRefresher;
import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class XMLViewer extends Observable implements IVisualElement, Observer {

	private VBox myView;
	private ListView<Node> myListView;
	private IRefresher myRefresher;
	private IWebFileExhange myWebConnector;
	private int mySelectedItemID;

	public XMLViewer(IRefresher refresher, IWebFileExhange webConnector) {
		mySelectedItemID = Integer.MIN_VALUE;
		myRefresher = refresher;
		myWebConnector = webConnector;
		myView = (VBox) makeView();
	}

	private Node makeView() {
		myListView = new ListView<Node>();
		myView = new VBox();
		myView.getChildren().addAll(makeTitleNode(makeButtonStrip()), myListView);
		return myView;
	}

	private Node makeTitleNode(Node buttons) {
		HBox title = GUIFactory.buildTitleNode("Game Name | Author Name");
		return GUIFactory.buildAnchorPane(title, buttons);
	}

	private Node makeButtonStrip() {
		Button download = GUIFactory.buildButton(ResourceManager.getString("download"),
				e -> myWebConnector.downloadItem(mySelectedItemID), 100.00, null);
		Button upload = GUIFactory.buildButton(ResourceManager.getString("upload"), e -> myWebConnector.uploadItem(),
				100.00, null);
		Button refresh = GUIFactory.buildButton(ResourceManager.getString("refresh"), e -> myRefresher.refresh(),
				100.0, null);
		HBox buttonStrip = new HBox();
		buttonStrip.getChildren().addAll(refresh, download, upload);
		return buttonStrip;
	}

	private void populateListView(List<JSONObject> itemList) {
		clearList();
		for (JSONObject object : itemList) {
			try {
				addElementToList(makeListElement(object.getString("gamename"), object.getString("author"),
						(int) object.get("id")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Node makeListElement(String itemName, String itemData, int itemID) {
		HBox listElement = new HBox();
		HBox game = GUIFactory.buildTitleNode(itemName);
		game.setPrefWidth(300);
		HBox author = GUIFactory.buildTitleNode(itemData);
		listElement.getChildren().addAll(game, author);
		listElement.setOnMouseClicked(e -> setSelectedItem(itemID));
		return listElement;
	}

	private void addElementToList(Node element) {
		myListView.getItems().add(element);
	}

	private void setSelectedItem(int id) {
		mySelectedItemID = id;
		setChanged();
		notifyObservers(id);
	}

	private void clearList() {
		myListView.getItems().clear();
	}

	@Override
	public void update(Observable o, Object arg) {
		XMLModel model = (XMLModel) o;
		populateListView(model.getItemList());
	}
	
	@Override
	public Node getView() {
		return myView;
	}

}
