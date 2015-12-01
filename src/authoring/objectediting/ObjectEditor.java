package authoring.objectediting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import authoring.data.ObjectData;

import com.syntacticsugar.vooga.gameplayer.attribute.IAttribute;
import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObject;
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
	//private ObjectData myData;
	
	private GameObjectType typeChosen;
	private List<IAttribute> myAttributes;
	private Map<GameObjectType, Collection<IGameEvent>> myCollisions;
	//private Map<GameObjectType,Collection<IGameEvent>> myCollisions;
	//private ListView myAttributes;
	//private ListView myColliders;
	//private ListView myCollisionEvents;
	
	private final String SELECT_FILE = "Select File";

	public ObjectEditor(GameObjectType type){
		typeChosen = type;
		myAttributes = new ArrayList<IAttribute>();
		myCollisions  = new HashMap<GameObjectType, Collection<IGameEvent>>();
		myView = new VBox();
		makeEditors();
		myView.getChildren().addAll(myAttributeViewer.getView(), myCollisionViewer.getView());			
	}
	
	private void makeEditors(){
		myAttributeViewer = new AttributeViewer(typeChosen,myAttributes);
		myCollisionViewer = new CollisionViewer(typeChosen,myCollisions);
	}
	
	public Node getView(){
		return myView;
	}
	
	public List<IAttribute> getAttributes() {
		return myAttributes;
	}
	
	public Map<GameObjectType, Collection<IGameEvent>> getCollisions() {
		return myCollisions;
	}
	
	
}
