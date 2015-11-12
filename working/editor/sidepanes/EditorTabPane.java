package editor.sidepanes;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class EditorTabPane {
	private TabPane editorPane;

	public EditorTabPane() {
		editorPane = new TabPane();
		Tab level = new Tab();
		level.setText("Level Settings");
		
		Tab enemies = new Tab();
		enemies.setText("Enemies");
		Tab towers = new Tab();
		towers.setText("Towers");
		Tab items = new Tab();
		items.setText("Items");
		editorPane.getTabs().addAll(level,enemies,towers,items);
	}
	
	public TabPane getPaneNode() {
		return editorPane;
	}
}
