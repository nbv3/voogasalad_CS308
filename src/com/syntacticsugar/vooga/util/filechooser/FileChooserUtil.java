package com.syntacticsugar.vooga.util.filechooser;

import java.io.File;

import com.syntacticsugar.vooga.util.ResourceManager;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;

public class FileChooserUtil {

	public static File saveFile(String data/*,String dialogLabel, String presetFill, File initialDirectory, IOnFileChooserAction onSave*/){
		boolean success = false;
		FileChooser fileChooser = new FileChooser();
		//fileChooser.setTitle(dialogLabel);
		//fileChooser.setInitialFileName(presetFill);
		//if (initialDirectory!=null){
		//	fileChooser.setInitialDirectory(initialDirectory);
		//}
		//Stage stage = new Stage();
		//stage.initModality(Modality.APPLICATION_MODAL);
		File selectedFile = fileChooser.showSaveDialog(new Stage());
		return selectedFile;
		/*if (selectedFile != null) {
			success = true;
			onSave.action(selectedFile);
			return sele;
		}
		return success;*/
	}
	
	public static boolean loadFile(String dialogLabel, ExtensionFilter extensions, File initialDirectory, IOnFileChooserAction onLoad){
		boolean success = false;
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(dialogLabel);
		fileChooser.getExtensionFilters().add(extensions);
		if (initialDirectory!=null){
			fileChooser.setInitialDirectory(initialDirectory);
		}
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		File selectedFile = fileChooser.showOpenDialog(stage);
		if (selectedFile != null) {
			success = true;
			onLoad.action(selectedFile);
		}	
		return success;
	}
	

}
