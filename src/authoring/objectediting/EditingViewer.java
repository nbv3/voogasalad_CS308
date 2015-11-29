package authoring.objectediting;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EditingViewer {

	protected VBox myView;
	protected Button myAddButton;
	protected Button myRemoveButton;
	protected ListView<HBox> myListView;
	protected Insets myPadding = new Insets(10,10,10,10);
	
	public EditingViewer(String viewerTitle){
		myView = new VBox();
		myView.setPadding(myPadding);
		myView.getChildren().add(makeTitleStrip(viewerTitle));
		makeContentBox();
	}
	
	private void makeContentBox(){ 
		// makes the VBox that contains the ListView and the buttons.
		myListView = new ListView<HBox>();
		myView.getChildren().add(myListView);
	}
	
	private AnchorPane makeTitleStrip(String title){
		HBox addRemoveStrip = makeAddRemoveStrip();
		HBox viewerTitle = makeViewerTitle(title);
		AnchorPane titleStrip = GUIFactory.buildAnchorPane(viewerTitle, addRemoveStrip);
		titleStrip.setPadding(myPadding);
		return titleStrip;
	}
	
	private HBox makeAddRemoveStrip(){
		HBox addRemoveStrip = new HBox();
		addRemoveStrip.getChildren().add(makeAddButton());
		addRemoveStrip.getChildren().add(makeRemoveButton());
		return addRemoveStrip;
	}
	
	private Button makeAddButton(){
		myAddButton = GUIFactory.buildButton(ResourceManager.getString("add"), null, 100.0, null);
		return myAddButton;
	}
	
	private Button makeRemoveButton(){
		myRemoveButton = GUIFactory.buildButton(ResourceManager.getString("remove"), null, 100.0, null);
		return myRemoveButton;
	}
	
	protected HBox makeViewerTitle(String text){
		Text titleText = new Text(text);
		HBox title = new HBox(titleText);
		title.setPadding(new Insets(5, 0, 0, 0));
		return title;
	}
	
	protected void addElementToList(HBox item){
		myListView.getItems().add(item);
	}
	
	public VBox getView(){
		return myView;
	}

}
