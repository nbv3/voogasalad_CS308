package com.syntacticsugar.vooga.util.filechooser;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;

public class FileChooserUtil {

	public static boolean saveFile(String dialogLabel, String presetFill, IOnFileChooserAction onSave){
		boolean success = false;
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(dialogLabel);
		fileChooser.setInitialFileName(presetFill);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		File selectedFile = fileChooser.showSaveDialog(stage);
		if (selectedFile != null) {
			success = true;
			onSave.action(selectedFile);
		}
		return success;
	}
	
	public static boolean loadFile(String dialogLabel, ExtensionFilter extensions, IOnFileChooserAction onLoad){
		boolean success = false;
		FileChooser chooser = new FileChooser();
		chooser.setTitle(dialogLabel);
		chooser.getExtensionFilters().add(extensions);
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		File selectedFile = chooser.showOpenDialog(stage);
		if (selectedFile != null) {
			success = true;
			onLoad.action(selectedFile);
		}	
		return success;
	}
	

}
