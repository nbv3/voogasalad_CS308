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

	public WaveController(EnemyQueueTabManager tabs) {
		myView = new VBox();
		myAddButton = GUIFactory.buildButton("Create wave", null, 100.0, 50.0);
		myAddButton.setOnMouseClicked(e->tabs.addNewWave());
		myView.getChildren().addAll(myAddButton, GUIFactory.buildButton("Clear wave", null, 100.0, 50.0));
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(20);
	}

	public Node getView() {
		return myView;
	}
}
