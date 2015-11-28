package authoring.objectediting;

/* 
 * This is the part of the sidepane that goes below the ObjectLibrary.
 * Contains the table of attributes, with the ability to add and remove attributes.
 * Also contain  
 */

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class ObjectEditor {

	private GridPane myView;
	private Button myFileSelectButton;
	//private ListView myAttributes;
	//private ListView myColliders;
	//private ListView myCollisionEvents;
	
	private final String SELECT_FILE = "Select File";

	public ObjectEditor(){
		myView = new GridPane();
		myFileSelectButton = new Button(SELECT_FILE);
		
		
	}
	
}
