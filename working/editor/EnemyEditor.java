package editor;

import editor.sidepanes.HealthBox;
import javafx.scene.layout.VBox;

public class EnemyEditor {
	private VBox enemyPane;

	public EnemyEditor() {
		enemyPane = new VBox();
		VBox h = new HealthBox().getNode();
		enemyPane.getChildren().addAll(h);
		
		
	}

	public VBox getNode() {
		return enemyPane;
	}

}
