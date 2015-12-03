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
	private ObjectData selectedItem;

	public WaveController(EnemyQueueTabManager tabs) {
		myView = new VBox();
		myAddButton = GUIFactory.buildButton("Create wave", null, 100.0, 50.0);
		myAddButton.setOnMouseClicked(e->tabs.addNewWave());
		myView.getChildren().addAll(myAddButton, GUIFactory.buildButton("Clear wave", null, 100.0, 50.0), GUIFactory.buildButton("Edit Item", e->editItem(tabs), 100.0, 50.0), GUIFactory.buildButton("Remove Item", e->tabs.removeItem(), 100.0, 50.0));
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
