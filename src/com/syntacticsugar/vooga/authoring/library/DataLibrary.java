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
import com.syntacticsugar.vooga.xml.data.IData;
import com.syntacticsugar.vooga.xml.data.ObjectData;
import com.syntacticsugar.vooga.xml.data.TowerData;

import javafx.scene.image.ImageView;

public class DataLibrary extends Observable {

	private IconPane myIconPane;
	private final File myXMLDirectory;
	private Map<ImageView, IData> myData;
	private IData mySelected;

	public DataLibrary(GameObjectType objectType) {
		myIconPane = new IconPane();
		myData = new HashMap<>();
		myXMLDirectory = new File(
				ResourceManager.getString(String.format("%s_%s", objectType.toString().toLowerCase(), "data")));
		populatePaneFromXMLFiles(myXMLDirectory);
		myIconPane.addPreviewListener((o, s1, s2) -> editItem());
		System.out.println();
	}

	public void refresh() {
		populatePaneFromXMLFiles(myXMLDirectory);
	}

	private void populatePaneFromXMLFiles(File XMLFolder) {

		myData = myIconPane.showDirectoryContentsMap(XMLFolder, e -> getImagePathsFromXML(XMLFolder));
	}

	private Collection<String> getImagePathsFromXML(File directory) {
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<IData> xml = new XMLHandler<>();
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			IData obj = xml.read(files[i]);
			imagePaths.add(obj.getImagePath());
		}
		return imagePaths;
	}

	public IconPane getContent() {
		return myIconPane;
	}

	private void editItem() {
		mySelected = myData.get(myIconPane.getSelectedIcon());
		setChanged();
		notifyObservers(mySelected);
	}

	public IData getCurrentData()

	{
		return myData.get(myIconPane.getSelectedIcon());
	}


}
