package editor;

import javafx.scene.layout.VBox;

public class TowerEditor {
	private VBox towerEditor;

	public TowerEditor() {
		towerEditor = new VBox();
		//VBox h = new SpawnerPropertyBox().getNode();
		VBox d = new DamageBox().getNode();
		VBox w = new WeaponBox().getNode();
		towerEditor.getChildren().addAll(d, w);
	}

	public VBox getNode() {
		return towerEditor;
	}
}
