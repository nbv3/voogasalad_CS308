package authoring.level;

import java.util.Observable;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import xml.data.ObjectData;

public class WaveController extends Observable{

	private VBox myView;
	private Button myAddButton;
	private Button myRemoveButton;
	private Button myClearButton;
	private Button myEditButton;
	private ObjectData selectedItem;


	public WaveController(EnemyQueueTabManager tabs) {
		myView = new VBox();
		myAddButton = GUIFactory.buildButton("Create wave", e -> tabs.addNewWave(), 100.0, 50.0);
		// myAddButton.setOnMouseClicked(e->);
		myClearButton = GUIFactory.buildButton("Clear wave", e -> tabs.clearWave(), 100.0, 50.0);
		// myClearButton.setOnMouseClicked(e-> tabs.clearWave());
		myRemoveButton = GUIFactory.buildButton("Remove Item", e -> tabs.removeSelected(), 100.0, 50.0);
		myEditButton = GUIFactory.buildButton("Edit Selected", e -> editItem(tabs), 100.0, 50.0);
		myView.getChildren().addAll(myAddButton, myClearButton, myEditButton, myRemoveButton);
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(20);
	}
	
	private void editItem(EnemyQueueTabManager tabs)
	{
		selectedItem = tabs.getSelectedItem();
		if(selectedItem != null)
		{
			setChanged();
			notifyObservers(selectedItem);
		}

	}
	
	public ObjectData getItemToEdit()
	{
		return selectedItem;
	}

	public Node getView() {
		return myView;
	}
	
}
