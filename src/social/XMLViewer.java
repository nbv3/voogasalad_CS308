package social;

import java.util.ArrayList;
import java.util.Collection;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class XMLViewer {

	private VBox myView;
	private ListView<HBox> myListView;
	private Insets myPadding = new Insets(10,10,10,10);
	
	public XMLViewer(String viewerTitle){
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
		Collection<Node> buttons = new ArrayList<Node>(); 
		AnchorPane titleStrip = (AnchorPane) GUIFactory.buildTitleNodeWithButtons(title, buttons);
		titleStrip.setPadding(myPadding);
		return titleStrip;
	}
	

	
	protected void addElementToList(HBox item){
		myListView.getItems().add(item);
	}
	
	public VBox getView(){
		return myView;
	}

}
