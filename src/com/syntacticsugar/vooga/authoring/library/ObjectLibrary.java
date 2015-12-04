package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.syntacticsugar.vooga.authoring.icon.Icon;
import com.syntacticsugar.vooga.authoring.icon.IconPane;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.XMLFileFilter;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class ObjectLibrary extends Tab {

	private GameObjectType myType;
	private IconPane myIconPane;
	private final File myXMLDirectory;
	private Button removeButton;
	private Map<Icon, ObjectData> myData;
	private Map<ObjectData, String> myXMLPaths;

	public ObjectLibrary(GameObjectType objectType) {
		myType = objectType;
		this.setText(objectType.toString());
		myIconPane = new IconPane();
		myXMLPaths = new HashMap<ObjectData, String>();
		myData = new HashMap<Icon, ObjectData>();
		setContent(buildTitledPane(myIconPane, myType));
		myXMLDirectory = new File(
				ResourceManager.getString(String.format("%s_%s", objectType.toString().toLowerCase(), "data")));
		populatePaneFromXMLFiles(myXMLDirectory);
	}

	public void refresh() {
		populatePaneFromXMLFiles(myXMLDirectory);
	}

	private void populatePaneFromXMLFiles(File XMLFolder) {
		// myIconPane.showIcons(XMLFolder, e ->
		// getImagePathsFromXML(XMLFolder));
		myIconPane.showIcons(XMLFolder, getImagePathsFromXML(XMLFolder));
	}

	// private Collection<String> getImagePathsFromXML(File directory) {
	// myData.clear();
	// File[] files = directory.listFiles(new XMLFileFilter());
	// XMLHandler<ObjectData> xml = new XMLHandler<>();
	// Collection<String> imagePaths = new ArrayList<String>();
	// for (int i = 0; i < files.length; i++) {
	// ObjectData obj = xml.read(files[i]);
	// imagePaths.add(obj.getImagePath());
	// Icon icon = new Icon(obj.getImagePath());
	// myData.put(icon, obj);
	// }
	// return imagePaths;
	// }

	private Map<Icon, ObjectData> getImagePathsFromXML(File directory) {
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<ObjectData> xml = new XMLHandler<>();
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			ObjectData obj = xml.read(files[i]);
			imagePaths.add(obj.getImagePath());
			Icon icon = new Icon(obj.getImagePath());
			myData.put(icon, obj);
			myXMLPaths.put(obj, files[i].getPath());
		}
		return myData;
	}

	private void refreshAfterRemove() {
		myIconPane.showIcons(myXMLDirectory, getImagePathsFromXML(myXMLDirectory));
	}

	private VBox buildTitledPane(IconPane pane, GameObjectType type) {
		Collection<Node> buttonList = new ArrayList<Node>();
		removeButton = GUIFactory.buildButton("Remove Object", e -> {
		} , 150.0, 30.0);
		removeButton.setOnMouseClicked(e -> removeSelected());
		buttonList.add(removeButton);
		return GUIFactory.buildTitledPaneWithButtons(pane.getIconPane(), (type.toString() + " Objects Available"),
				buttonList);
	}

	private void removeSelected() {

		System.out.println("remove");
		ObjectData current = myIconPane.getCurrentData();
		String path = myXMLPaths.get(current);
		File[] files = myXMLDirectory.listFiles(new XMLFileFilter());

		for (int i = 0; i < files.length; i++) {
			if (files[i].getPath().equals(path)) {
				files[i].delete();
				myXMLPaths.remove(current);

				for (Icon icon : myData.keySet()) {
					if (myData.get(icon).equals(current)) {
						myData.remove(icon);
					}
				}
			}
		}
		
		System.out.println(myData.size());
		System.out.println(myXMLPaths.size());

		myIconPane.showIcons(myXMLDirectory, myData);
	}

}
