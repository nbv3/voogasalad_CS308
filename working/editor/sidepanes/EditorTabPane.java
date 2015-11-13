package editor.sidepanes;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class EditorTabPane {
	private TabPane editorPane;
	private Tab level;
	private Tab tiles;
	private Tab enemies;
	private Tab towers;
	private Tab items;

	public EditorTabPane(VBox t, VBox e) {
		editorPane = new TabPane();
		level = new Tab();
		level.setText("Level Settings");
		tiles = new Tab();
		tiles.setText("Tile Settings");
		tiles.setContent(t);
		enemies = new Tab();
		enemies.setText("Enemies");
		enemies.setContent(e);
		towers = new Tab();
		towers.setText("Towers");
		items = new Tab();
		items.setText("Items");
		editorPane.getTabs().addAll(tiles,level, enemies, towers, items);

	}


	public TabPane getPaneNode() {
		return editorPane;
	}
}
