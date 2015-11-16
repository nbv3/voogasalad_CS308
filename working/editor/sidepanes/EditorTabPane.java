package editor.sidepanes;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class EditorTabPane {
	private TabPane editorPane;
	
	public EditorTabPane(EditorTab... tabs) {
		editorPane = new TabPane();
		for(EditorTab e:tabs){
			Tab newTab = new Tab();
			newTab.setText(e.getTabDescription());
			newTab.setContent(e.getContent());
			editorPane.getTabs().add(newTab);
		}
	}

	public TabPane getPaneNode() {
		return editorPane;
	}
}
