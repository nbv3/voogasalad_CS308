package authoring.level;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class LevelEditor {

	private BorderPane myTabContents;
	private GridPane myContentGrid;
	private MapEditor myMapEditor;
	private TileEditor myTileEditor;
//	private SpawnEditor mySpawnEditor;
	
	public LevelEditor() throws Exception {
		myMapEditor = new MapEditor();
		myTileEditor = new TileEditor(myMapEditor);
		buildTabContents();
		
		// When you are ready to add the bottom Node on (for the Spawn Queue),
		// add it into the myLevelTab and the grid lines will automatically appear.
		
	}
	
	public BorderPane getContent() {
		return this.myTabContents;
	}
	
	private void buildTabContents() {
		myTabContents = new BorderPane();
		myContentGrid = new GridPane();
		myContentGrid.setPadding(new Insets(10, 10, 10, 10));
		addColumnConstraints(myContentGrid);
		addRowConstraints(myContentGrid);
		myContentGrid.add(myTileEditor.getControlBox(), 0, 0, 1, 1);
		myContentGrid.add(myMapEditor.getMapGrid(), 1, 0, 1, 2);
		myContentGrid.setGridLinesVisible(true);
		myTabContents.setCenter(myContentGrid);
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
		RowConstraints r0 = new RowConstraints(0.5*myMapEditor.getMapDisplayHeight());
		RowConstraints r1 = new RowConstraints(0.5*myMapEditor.getMapDisplayHeight());
		grid.getRowConstraints().addAll(r0, r1);
	}
	
}
