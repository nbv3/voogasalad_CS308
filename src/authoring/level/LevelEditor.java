package authoring.level;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class LevelEditor {

	private Tab myLevelTab;
	private GridPane myTabContents;
	private MapEditor myMapEditor;
//	private SpawnEditor mySpawnEditor;
	
	public LevelEditor() throws NumberFormatException {
		myLevelTab = new Tab();
		myTabContents = buildTabContents();
		myMapEditor = new MapEditor();
		myTabContents.add(myMapEditor.getMapGrid(), 1, 0, 1, 2);
		myTabContents.add(myMapEditor.getTileControls(), 0, 0, 1, 1);
		myLevelTab.setContent(myTabContents);
	}
	
	public Tab getTab() {
		return this.myLevelTab;
	}
	
	private GridPane buildTabContents() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		addColumnConstraints(grid);
		addRowConstraints(grid);
		grid.setGridLinesVisible(true);
		return grid;
	}
	
	private void addColumnConstraints(GridPane grid) {
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(20);
		ColumnConstraints c2 = new ColumnConstraints();
		c2.setPercentWidth(40);
		ColumnConstraints c3 = new ColumnConstraints();
		c3.setPercentWidth(40);
		grid.getColumnConstraints().addAll(c1, c2, c3);
	}
	
	private void addRowConstraints(GridPane grid) {
		RowConstraints r1 = new RowConstraints();
		r1.setPercentHeight(40);
		RowConstraints r2 = new RowConstraints();
		r2.setPercentHeight(40);
		RowConstraints r3 = new RowConstraints();
		r3.setPercentHeight(20);
		grid.getRowConstraints().addAll(r1, r2, r3);
	}
	
}
