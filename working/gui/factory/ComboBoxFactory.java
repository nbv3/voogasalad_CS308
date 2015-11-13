package gui.factory;

import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resources.ResourceRetriever;

public class ComboBoxFactory {
	public ComboBoxFactory(){
	}
	
	private ComboBox imageComboBox(){
		return null;
	}

	private ComboBox<String> createImageComboBox() {
		ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPromptText(ResourceRetriever.getLabel("TileSelectPrompt"));
        comboBox.getItems().add(ResourceRetriever.getLabel("SceneryTile"));
        comboBox.getItems().add(ResourceRetriever.getLabel("PathTile"));
        //comboBox.valueProperty().addListener((o, s1, s2) -> showImageOptions(s2));
		return comboBox;
	}



}



