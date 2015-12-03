package com.syntacticsugar.vooga.authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.authoring.icon.Icon;
import com.syntacticsugar.vooga.authoring.icon.IconPane;
import com.syntacticsugar.vooga.authoring.icon.ImageFileFilter;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.xml.XMLFileFilter;
import com.syntacticsugar.vooga.xml.XMLHandler;
import com.syntacticsugar.vooga.xml.data.ObjectData;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ObjectLibrary {

	private VBox myView;
	private GameObjectType myType;
	private IconPane myIconPane;
	private List<ObjectData> myObjectDataList;
	private File myXMLDirectory;
	private XMLHandler<ObjectData> myXMLHandler; 
	
	public ObjectLibrary(GameObjectType objectType){
		myType = objectType;
		myObjectDataList = new ArrayList<ObjectData>();
		myIconPane = new IconPane();
		myView = buildTitledPane(myIconPane, myType);
		myXMLHandler = new XMLHandler<ObjectData>();
		//ResourceManager.getString(objectType.toString() + "_xml");
		myXMLDirectory = new File(ResourceManager.getString(String.format("%s%s", objectType, "_data")));
		populatePaneFromXMLFiles(myXMLDirectory);
	}
	
	private void populatePaneFromXMLFiles(File XMLFolder){
		myIconPane.showIcons(XMLFolder, e -> makeDataAndReturnPathsFromXMLs(XMLFolder));
	}
	
	private Collection<String> makeDataAndReturnPathsFromXMLs(File XMLFolder){
		makeObjectDataFromXMLs(XMLFolder);
		return makeImagePathsFromObjectData();
	}
	
	private Collection<String> makeImagePathsFromObjectData(){
		ArrayList<String> imagePaths = new ArrayList<String>();
		for (ObjectData data: myObjectDataList)
			imagePaths.add(data.getImagePath());
		return imagePaths;
	}
	
	private void makeObjectDataFromXMLs(File XMLFolder){
		for (File f: XMLFolder.listFiles(new XMLFileFilter()))
			myObjectDataList.add(makeObjectDataFromXML(f));
	}
	
	private ObjectData makeObjectDataFromXML(File XMLFile){
		return myXMLHandler.read(XMLFile);
	}
	
	public Node getContent(){
		return myView;
	}
	
	private VBox buildTitledPane(IconPane pane, GameObjectType type){
		return GUIFactory.buildTitledPane(pane.getIconPane(),
				ResourceManager.getString(type.toString()) + " Objects Available");
	}
	
//	public void addIconToPane(ObjectData dataObject){
//		myIconPane.addIconToPane(new Icon(dataObject.getImagePath()), dataObject.getImagePath());
//	}
	
}
