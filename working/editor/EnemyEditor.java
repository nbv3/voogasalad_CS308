package editor;

import editor.sidepanes.HealthBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnemyEditor {
	private VBox enemyPane;

	public EnemyEditor() {
		enemyPane = new VBox();
		VBox h = new HealthBox().getNode();
		HBox image = new ImageSelector().getNode();
		enemyPane.getChildren().addAll(image,h);
		
	}

	public VBox getNode() {
		return enemyPane;
	}

}
