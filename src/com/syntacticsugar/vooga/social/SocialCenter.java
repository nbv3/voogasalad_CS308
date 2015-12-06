package com.syntacticsugar.vooga.social;

import org.json.JSONException;

import com.syntacticsugar.vooga.menu.IVoogaApp;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SocialCenter implements IVoogaApp{

	private XMLViewer myXMLViewer;
	private ObjectDataViewer myObjectDataViewer;
	private Stage myStage;
	private VBox myLeft;
	private HBox myView;
	private CommentViewer myCommentViewer;
	
	public SocialCenter(){
		myStage = new Stage();
		myLeft = new VBox();
		myView = new HBox();
		myObjectDataViewer = new ObjectDataViewer();
		myXMLViewer = new XMLViewer(new IDataViewUpdater(){

			@Override
			public void update(int selected) throws JSONException {
				myObjectDataViewer.update(selected);
			}

			@Override
			public void updateID(int selected) {
				myObjectDataViewer.updateID(selected);
			}
			
		});
		
		
		myLeft.getChildren().add(myXMLViewer.getView());
		myLeft.getChildren().add(myObjectDataViewer.getView());
		myLeft.setPrefWidth(700);
		myView.getChildren().add(myLeft);
		VBox myRight = (VBox) myObjectDataViewer.getCommentBox();
		myRight.setMaxWidth(Integer.MAX_VALUE);
		myView.getChildren().add(myRight);
		Scene scene = new Scene(myView, 800, 500);
		myStage.setScene(scene);
		myStage.show();
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
		
	}
	
	
	
}
