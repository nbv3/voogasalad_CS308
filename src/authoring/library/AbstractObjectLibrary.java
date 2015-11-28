package authoring.library;

import java.io.File;
import java.util.HashMap;

import authoring.icons.panes.ObjectIconPane;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class AbstractObjectLibrary {

	private VBox myView;
	protected ObjectIconPane myObjectIconPane;
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
		myObjectIconPane.showIcons(null);  // Fix later

		addToVBox("iconPane", myObjectIconPane.getIconPane());
	}
	
}
