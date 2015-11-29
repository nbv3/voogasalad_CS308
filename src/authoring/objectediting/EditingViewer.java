package authoring.objectediting;

import com.syntacticsugar.vooga.gameplayer.event.IGameEvent;
import com.syntacticsugar.vooga.gameplayer.objects.GameObjectType;
import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EditingViewer {

	protected VBox myView;
	protected HBox myContent;
	protected Button myAddButton;
	protected Button myRemoveButton;
	protected ListView<HBox> myListView;
	
	public EditingViewer(String viewerTitle){
		myView = new VBox();
		myView.getChildren().add(makeViewerTitle(viewerTitle));
		myView.getChildren().add(makeContentBox());
	}
	
	private HBox makeContentBox(){ 
		// makes the HBox that contains the ListView and the buttons.
		myContent = new HBox();
		myListView = new ListView<HBox>();
		myContent.getChildren().add(myListView);
		myContent.getChildren().add(makeAddRemoveStrip());
		return myContent;
	}
	
	private VBox makeAddRemoveStrip(){
		VBox addRemoveStrip = new VBox();
		addRemoveStrip.getChildren().add(makeAddButton());
		addRemoveStrip.getChildren().add(makeRemoveButton());
		return addRemoveStrip;
	}
	
	private Button makeAddButton(){
		myAddButton = new Button(ResourceManager.getString("add"));
		return myAddButton;
	}
	
	private Button makeRemoveButton(){
		myRemoveButton = new Button(ResourceManager.getString("remove"));
		return myRemoveButton;
	}
	
	protected Text makeViewerTitle(String text){
		return new Text(text);
	}
	
	protected void addElementToList(HBox item){
		myListView.getItems().add(item);
	}
	
	public VBox getView(){
		return myView;
	}

}
