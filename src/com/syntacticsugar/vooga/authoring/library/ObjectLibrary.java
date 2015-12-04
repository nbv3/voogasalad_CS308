package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.authoring.icon.IconPane;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.XMLFileFilter;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class ObjectLibrary extends Tab {

	private GameObjectType myType;
	private IconPane myIconPane;
	private final File myXMLDirectory;
	
	public ObjectLibrary(GameObjectType objectType) {
		myType = objectType;
		this.setText(objectType.toString());
		myIconPane = new IconPane();
		setContent(buildTitledPane(myIconPane, myType));
		myXMLDirectory = new File(ResourceManager.getString(String.format("%s_%s", objectType.toString().toLowerCase(), "data")));
		populatePaneFromXMLFiles(myXMLDirectory);
	}
	
	public void refresh() {
		populatePaneFromXMLFiles(myXMLDirectory);
	}
	
	private void populatePaneFromXMLFiles(File XMLFolder){
		myIconPane.showIcons(XMLFolder, e -> getImagePathsFromXML(XMLFolder));
	}
	
	private Collection<String> getImagePathsFromXML(File directory){
		File[] files = directory.listFiles(new XMLFileFilter());
		XMLHandler<ObjectData> xml = new XMLHandler<>();
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i=0; i<files.length; i++) {
			ObjectData obj = xml.read(files[i]);
			imagePaths.add(obj.getImagePath());
			System.out.println(obj.getImagePath());
		}
		return imagePaths;
	}
	
	
	private VBox buildTitledPane(IconPane pane, GameObjectType type){
		Collection<Node> buttonList = new ArrayList<Node>();
		buttonList.add(GUIFactory.buildButton("Remove Object", e->{}, 300.0, 30.0)); 
		return GUIFactory.buildTitledPaneWithButtons(pane.getIconPane(),
				(type.toString() + " Objects Available"), buttonList);
	}

}
