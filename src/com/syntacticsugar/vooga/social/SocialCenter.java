package com.syntacticsugar.vooga.social;

import com.syntacticsugar.vooga.menu.IVoogaApp;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SocialCenter implements IVoogaApp{

	private XMLViewer myXMLViewer;
	private ObjectDataViewer myObjectDataViewer;
	private Stage myStage;
	private VBox myView;
	
	public SocialCenter(){
		myStage = new Stage();
		myView = new VBox();
		myObjectDataViewer = new ObjectDataViewer();
		myXMLViewer = new XMLViewer(id -> myObjectDataViewer.update(id));
		myView.getChildren().add(myXMLViewer.getView());
		myView.getChildren().add(myObjectDataViewer.getView());
		Scene scene = new Scene(myView, 500, 500);
		myStage.setScene(scene);
		myStage.show();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
		
	}
	
	
	
}
