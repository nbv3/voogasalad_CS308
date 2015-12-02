package authoring.level;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class WaveController {

	private VBox myView;
	
	public WaveController() {
		myView = new VBox();
		myView.getChildren().addAll(GUIFactory.buildButton("Create wave", null, 100.0, 50.0),
				GUIFactory.buildButton("Clear wave", null, 100.0, 50.0));
		myView.setAlignment(Pos.CENTER);
		myView.setSpacing(20);
	}
	
	public Node getView() {
		return myView;
	}
}
