package editor.sidepanes;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import resources.LabelRetriever;
import tiles.implementations.DecoratorTile;

public class TileEditor extends AEditorPane {

	private DecoratorTile myTile;
	private String[] myTypes = {"Path", "Scenery"};
	
	public TileEditor(DecoratorTile tile) {
		myTile = tile;
		myEditorPane = new VBox();
		myEditorPane.getChildren().add(createTitleBar());
		myEditorPane.getChildren().add(makeImageChooser());

	}
	
	private Text createTypeLabel(){
		Text tileType = new Text();
		tileType.setText(
				LabelRetriever.getLabel(myTile.getImplementation().getClass().getSimpleName()));
		return tileType;
	}
	
	private HBox createTitleBar(){
		HBox titleBar = new HBox();
		titleBar.getChildren().add(createTypeLabel());
		titleBar.getChildren().add(createDropdown());
		return titleBar;	
	}
	
	private ComboBox<String> createDropdown(){
		ComboBox<String> typeDropdown = new ComboBox<String>();
		for (int i=0; i<myTypes.length; i++){
			typeDropdown.getItems().add(myTypes[i]);
		}
		typeDropdown.valueProperty().addListener((o,s1,s2) -> createGridPane(s2));
		return typeDropdown;
	}

	private GridPane createGridPane(String type) {
		GridPane selectionGrid = new GridPane();
		myEditorPane.getChildren().add(selectionGrid);

		File directory = new File(System.getProperty("user.dir") + "/images/" + type);
		for (File file : directory.listFiles()) {
			if (file.getName().endsWith("png"))
					System.out.println(file.getName());
		
		}

		return selectionGrid;
	}
	
	
}
