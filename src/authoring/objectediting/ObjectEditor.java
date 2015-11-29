package authoring.objectediting;

import javafx.scene.Node;

/* 
 * This is the part of the sidepane that goes below the ObjectLibrary.
 * Contains the table of attributes, with the ability to add and remove attributes.
 * Also contain  
 */

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ObjectEditor {

	private VBox myView;
	private Button myFileSelectButton;
	private AttributeViewer myAttributeViewer;
	private CollisionViewer myCollisionViewer;
	//private ListView myAttributes;
	//private ListView myColliders;
	//private ListView myCollisionEvents;
	
	private final String SELECT_FILE = "Select File";

	public ObjectEditor(){
		myView = new VBox();
		makeEditors();
		myView.getChildren().addAll(myAttributeViewer.getView(),
				myCollisionViewer.getView());
		//myFileSelectButton = new Button(SELECT_FILE);
			
	}
	
	private void makeEditors(){
		myAttributeViewer = new AttributeViewer();
		myCollisionViewer = new CollisionViewer();
	}
	
	public Node getView(){
		return myView;
	}
	
	
}
