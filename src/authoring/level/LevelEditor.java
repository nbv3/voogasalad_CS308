package authoring.level;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import xml.data.MapData;

public class LevelEditor {

	private GridPane myContentGrid;
	private MapEditor myMapEditor;
	private MapEditorControls myTileEditor;
	private EnemyQueueTabManager myQueue;
	private WaveController myWaveControl;
	// private SpawnEditor mySpawnEditor;

	public LevelEditor() throws Exception {
		myMapEditor = new MapEditor();
		myTileEditor = new MapEditorControls(myMapEditor);
		myQueue = new EnemyQueueTabManager();
		myWaveControl = new WaveController();
		buildTabContents();

		// When you are ready to add the bottom Node on (for the Spawn Queue),
		// add it into the myLevelTab and the grid lines will automatically
		// appear.

	}

	public void loadMap(MapData loadedMap) {
		myMapEditor.loadMapData(loadedMap);
	}

	public Node getContent() {
		return this.myContentGrid;
	}

	private void buildTabContents() {
		myContentGrid = new GridPane();
		myContentGrid.setPadding(new Insets(10, 10, 10, 10));
		addColumnConstraints(myContentGrid);
		addRowConstraints(myContentGrid);
		myContentGrid.add(myTileEditor.getContent(), 0, 0, 1, 1);
		myContentGrid.add(myMapEditor.getContent(), 1, 0, 1, 2);
		myContentGrid.add(myWaveControl.getView(), 0, 2, 1, 1);
		myContentGrid.add(myQueue.getView(), 1, 2, 2, 1);
		myContentGrid.setGridLinesVisible(true);
	}

	private void addColumnConstraints(GridPane grid) {
		ColumnConstraints c1 = new ColumnConstraints();
		c1.setPercentWidth(25);
		ColumnConstraints c2 = new ColumnConstraints();
		c2.setPercentWidth(50);
		ColumnConstraints c3 = new ColumnConstraints();
		c3.setPercentWidth(25);
		grid.getColumnConstraints().addAll(c1, c2, c3);
	}

	private void addRowConstraints(GridPane grid) {
		RowConstraints r0 = new RowConstraints();
		r0.setPercentHeight(45);
		RowConstraints r1 = new RowConstraints();
		r1.setPercentHeight(30);
		RowConstraints r2 = new RowConstraints();
		r2.setPercentHeight(25);
		grid.getRowConstraints().addAll(r0, r1, r2);
	}

	public MapData getMapData() {
		return myMapEditor.getMapData();
	}

}
