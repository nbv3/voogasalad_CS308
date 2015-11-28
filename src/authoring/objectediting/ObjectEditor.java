package authoring.objectediting;

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
