package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.syntacticsugar.vooga.authoring.icons.implementations.Icon;
import com.syntacticsugar.vooga.authoring.icons.panes.ObjectIconPane;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ObjectLibrary {

	private VBox myView;
	private GameObjectType myType;
	protected ObjectIconPane myIconPane;
	protected List<ObjectData> myObjectDataList;
	protected File myXMLDirectory;
	
	public ObjectLibrary(GameObjectType objectType){
		// unsure at this point whether a saved game is loaded in one xml,
		// or in different directories.
		myType = objectType;
		myObjectDataList = new ArrayList<ObjectData>();
		myIconPane = new ObjectIconPane();
		myView = buildTitledPane(myIconPane, myType);
		//populateOptionIcons(directory);
	}
	
	public Node getContent(){
		return myView;
	}
	
	private VBox buildTitledPane(ObjectIconPane pane, GameObjectType type){
		return GUIFactory.buildTitledPane(pane.getIconPane(),
				ResourceManager.getString(type.toString()) + " Objects Available");
	}
	
	public void addIconToPane(ObjectData dataObject){
		myIconPane.addIconToPane(new Icon(dataObject.getImagePath()), dataObject.getImagePath());
	}
	
	public void addDataObjectToLibrary(ObjectData dataObject){
		myObjectDataList.add(dataObject);
		addIconToPane(dataObject);
		// now we need to actually write out the XML to the right XML directory (???) 
		// need to figure out how data works.
	}
	
	private void makeDataObject(){
		ObjectData dataObject = new ObjectData();
	}
	
}
