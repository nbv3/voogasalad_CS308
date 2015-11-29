package authoring.library;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;

import authoring.data.ObjectData;
import authoring.icons.panes.ObjectIconPane;
import javafx.scene.control.Tab;

public class ObjectLibrary {

	private Tab myView;
	protected ObjectIconPane myIconPane;
	
	public ObjectLibrary(File XMLDirectory){
		myIconPane = new ObjectIconPane();
		populateOptionIcons(XMLDirectory);
	}
	
	public Tab getView(){
		return myView;
	}
	
	private void populateOptionIcons(File XMLDirectory){
		//Parse xml directory to get list of ObjectData instances
		Collection<ObjectData> xmlData = null;
		myIconPane.showIcons(xmlData);
	}
	
}
