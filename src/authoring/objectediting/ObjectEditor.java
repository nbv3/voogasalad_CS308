package authoring.objectediting;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import authoring.data.ObjectData;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;

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
	private ObjectData myData;
	//private Map<GameObjectType,Collection<IGameEvent>> myCollisions;
	//private ListView myAttributes;
	//private ListView myColliders;
	//private ListView myCollisionEvents;
	
	private final String SELECT_FILE = "Select File";

	public ObjectEditor(ObjectData dataObject){
		myData = dataObject;
		myData.setType(GameObjectType.PLAYER);
		myView = new VBox();
		makeEditors();
		myView.getChildren().addAll(myAttributeViewer.getView(),
				myCollisionViewer.getView());
		//myFileSelectButton = new Button(SELECT_FILE);
			
	}
	
	private void makeEditors(){
		myAttributeViewer = new AttributeViewer(myData);
		myCollisionViewer = new CollisionViewer(myData);
	}
	
	public ObjectData getObjectData(){
		return myData;
	}
	
	public Node getView(){
		return myView;
	}
	
	
}
