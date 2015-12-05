package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import com.syntacticsugar.vooga.authoring.icon.IconPane;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.xml.XMLFileFilter;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ObjectLibrary extends Observable {

	private GameObjectType myType;
	private IconPane myIconPane;
	private final File myXMLDirectory;
	// private Map<Icon, ObjectData> myData;
	private Map<ImageView, ObjectData> myData;
	private ObjectData mySelected;

	public ObjectLibrary(GameObjectType objectType) {
		myType = objectType;
		// myTab.setText(objectType.toString());
		myIconPane = new IconPane();
		myData = new HashMap<ImageView, ObjectData>();
		// myTab.setContent(buildTitledPane(myIconPane, myType));
		myXMLDirectory = new File(
				ResourceManager.getString(String.format("%s_%s", objectType.toString().toLowerCase(), "data")));
		populatePaneFromXMLFiles(myXMLDirectory);
		myIconPane.addPreviewListener((o, s1, s2) -> editItem());
	}

	// private Node buildTitledPane(IconPane myIconPane2, GameObjectType
	// myType2) {
	// VBox box = new VBox();
	// box.getChildren().add(myIconPane2.getIconPane());
	// return box;
	// }

	private Node buildTitledPane(IconPane myIconPane2, GameObjectType myType2) {
		VBox box = new VBox();
		box.getChildren().add(myIconPane2.getView());
		return box;
	}

	public void refresh() {
		populatePaneFromXMLFiles(myXMLDirectory);
	}

	private void populatePaneFromXMLFiles(File XMLFolder) {

		myData = myIconPane.showDirectoryContentsMap(XMLFolder, e -> getImagePathsFromXML(XMLFolder));
	}

	private Collection<String> getImagePathsFromXML(File directory) {
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<ObjectData> xml = new XMLHandler<>();
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			ObjectData obj = xml.read(files[i]);
			imagePaths.add(obj.getImagePath());
		}
		return imagePaths;
	}

	public IconPane getContent() {
		return myIconPane;
	}

	// public ObjectData getItemToEdit() {
	// return myData.get(myIconPane.getSelectedIcon());
	// }

	private void editItem() {
		mySelected = myData.get(myIconPane.getSelectedIcon());
		setChanged();
		notifyObservers(mySelected);
	}

}
