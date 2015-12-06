package com.syntacticsugar.vooga.social;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UploaderInfoBox {

	private TextField myAuthor, myDescription, myGameName;
	private VBox myView;
	private IUploader myUploadInterface;
	private Stage myStage;
	
	public UploaderInfoBox(IUploader uploadInterface) {
		myUploadInterface = uploadInterface;
		initializeVariables();
		myView.getChildren().addAll(
		GUIFactory.buildTitledPane("Author Name", myAuthor),
		GUIFactory.buildTitledPane("Game Name", myGameName),
		GUIFactory.buildTitledPane("Game Description", myDescription),
		GUIFactory.buildButton("OK", e-> postDataObject(), myView.getPrefWidth(), null));
		
		Scene scene = new Scene(myView,250,250);
		myStage = new Stage();
		myStage.setScene(scene);
		myStage.initModality(Modality.WINDOW_MODAL);
		myStage.showAndWait();
	}
	
	private void initializeVariables(){
		myAuthor = new TextField();
		myDescription = new TextField();
		myGameName = new TextField();
		myView = new VBox();
	}
	
	private void postDataObject(){
		if (myAuthor.getText().length() == 0 || 
				myDescription.getText().length() == 0 ||
				myGameName.getText().length() == 0){
			AlertBoxFactory.createObject(ResourceManager.getString("fill_all_fields"));
			return;
		}
		myUploadInterface.postXML(myAuthor.getText(), 
				myGameName.getText(), myDescription.getText());
		myStage.close();
	}
	
}
