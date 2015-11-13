package gui.factory;

import java.util.ResourceBundle;

import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ComboBoxFactory {
	private final String DEFAULT_RESOURCE_PACKAGE = "resources/";
	public ComboBoxFactory(){
	}
	
	private ComboBox imageComboBox(){
		return null;
	}

	private ComboBox<String> createImageComboBox() {
		ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPromptText("Select a category");
        comboBox.getItems().add("Scenery");
        comboBox.getItems().add("Path");
        //comboBox.valueProperty().addListener((o, s1, s2) -> showImageOptions(s2));
		return comboBox;
	}



}



