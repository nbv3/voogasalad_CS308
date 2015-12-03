package authoring.level;

import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class WaveEditor {
	
	private HBox myView;
	private EnemyQueuePane emenyQueue;
	
	public WaveEditor() {
		myView = new HBox();
		
	}

	public Node getView() {
		return myView;
	}
	
}
