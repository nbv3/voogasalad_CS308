package authoring.library;

import java.io.File;
import java.util.HashMap;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class AbstractObjectLibrary {

	private VBox myView;
	protected IconPane myObjectIconPane;
	private HashMap<String, Node> myViewElements;
	
	public AbstractObjectLibrary(File XMLDirectory){
		populateOptionIcons(XMLDirectory);
		myViewElements = new HashMap<String, Node>();
	}
	
	public VBox getView(){
		return myView;
	}
	
	private void addToVBox(String name, Node element){
		myView.getChildren().add(element);
		myViewElements.put(name, element);
	}
	
	protected void populateOptionIcons(File XMLDirectory){
		myObjectIconPane.showImageOptionsFromXML(XMLDirectory);
		addToVBox("iconPane", myObjectIconPane.getIconPane());
	}
	
}
