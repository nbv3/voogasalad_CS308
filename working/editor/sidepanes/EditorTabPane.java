package editor.sidepanes;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class EditorTabPane {
	private TabPane editorPane;
	private Tab level;
	private Tab tiles;
	private Tab spawners;
	private Tab players;
	private Tab towers;

	public EditorTabPane(VBox t, VBox e) {
		editorPane = new TabPane();
		level = new Tab();
		level.setText("Level Settings");
		level.setClosable(false);
		tiles = new Tab();
		tiles.setText("Tile Settings");
		tiles.setClosable(false);
		tiles.setContent(t);
		spawners = new Tab();
		spawners.setText("Spawners");
		spawners.setContent(e);
		spawners.setClosable(false);
		players = new Tab();
		players.setText("Players");
		players.setClosable(false);
		towers = new Tab();
		towers.setText("Towers");
		towers.setClosable(false);
		editorPane.getTabs().addAll(tiles, spawners, players, towers);
	}

	public TabPane getPaneNode() {
		return editorPane;
	}
}
