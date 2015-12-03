package authoring.level;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class WaveController {

	private VBox myView;
	private Button myAddButton;
	private Button myClearButton;
	private Button myRemoveButton;

	public WaveController(EnemyQueueTabManager tabs) {
		myView = new VBox();
		myAddButton = GUIFactory.buildButton("Create wave", e -> tabs.addNewWave(), 100.0, 50.0);
		// myAddButton.setOnMouseClicked(e->);
		myClearButton = GUIFactory.buildButton("Clear wave", e -> tabs.clearWave(), 100.0, 50.0);
		// myClearButton.setOnMouseClicked(e-> tabs.clearWave());
		myRemoveButton = GUIFactory.buildButton("Remove Selected", e -> tabs.removeSelected(), 100.0, 50.0);
		myView.getChildren().addAll(myAddButton, myClearButton, myRemoveButton);
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(20);
	}

	public Node getView() {
		return myView;
	}
}
