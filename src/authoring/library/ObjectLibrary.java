package authoring.library;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.syntacticsugar.vooga.util.ResourceManager;

import authoring.data.ObjectData;
import authoring.icons.ImageFileFilter;
import authoring.icons.panes.ImageIconPane;
import authoring.icons.panes.ObjectIconPane;
import authoring.objectediting.AttributeViewer;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class ObjectLibrary {

	private VBox myContent;
	protected ImageIconPane myIconPane;
	
	public ObjectLibrary(File directory){
		myContent = new VBox();
		myIconPane = new ImageIconPane();
		myContent.getChildren().add(myIconPane.getIconPane());
		populateOptionIcons(directory);
	}
	
	public Node getContent(){
		return myContent;
	}
	
	private void populateOptionIcons(File directory){
		//Parse xml directory to get list of ObjectData instances
		
		Collection<ObjectData> xmlData = null;
	/*	File imgDirectory = new File(ResourceManager.getString(String.format("%s%s", "Path", "_images")));
		File[] files = imgDirectory.listFiles(new ImageFileFilter());
		Collection<String> imagePaths = new ArrayList<String>();
		for (int i=0; i<files.length; i++) {
			imagePaths.add(files[i].getName());
		}
		myIconPane.showIcons(imagePaths);
		*/
	}
	
}
