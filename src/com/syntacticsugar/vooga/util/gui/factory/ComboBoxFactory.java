package com.syntacticsugar.vooga.util.gui.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

import com.syntacticsugar.vooga.authoring.editor.ITileEditorComboBox;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ComboBoxFactory extends Factory{
	private ITileEditorComboBox iTileEditorInterface;
	public ComboBoxFactory(ITileEditorComboBox i){
		iTileEditorInterface=i;
	}
	
	@Override
	public Node createObject(String id) {
		try {
			Method method = createMethodObject("gui.factory.ComboBoxFactory", id, new Class[0]);
			return (Node) method.invoke(this);
		} catch (IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}	
	private ComboBox<String> TileImageComboBox() {
		ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPromptText("Select a category");
        comboBox.getItems().add("Scenery");
        comboBox.getItems().add("Path");
        comboBox.valueProperty().addListener((o, s1, s2) -> iTileEditorInterface.showTileImageOptions(s2));
		return comboBox;
	}



}



