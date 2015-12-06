package com.syntacticsugar.vooga.newsocial;

import org.json.JSONException;

import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SocialCenterController implements IVoogaApp {

	private XMLViewer myXMLViewer;
	private DataViewer myDataViewer;
	private CommentBox myCommentBox;
	private CommentViewer myCommentViewer;
	private Stage myStage;
	
	public SocialCenterController()  {
		
		myDataViewer = new DataViewer();
		myXMLViewer = new XMLViewer( id -> myDataViewer.update(id));
		myCommentViewer = new CommentViewer(new ICommentViewer(){

			@Override
			public void populateCommentsList() {				
			}
			@Override
			public void refreshCommentList() {				
			}

			@Override
			public int getSelectedItemID() {
				return myDataViewer.getSelectedItemID();
			}
			
		});
		
		myCommentBox = new CommentBox(new ICommentSender(){
			@Override
			public boolean sendComment(String author, String comment) {
				if (author.length() > 0 && comment.length() >  0){
					WebConnector.postComment(JSONHelper.createCommentJSON(
							myDataViewer.getSelectedItemID(), author, comment));
					return true;
				}
				return false;
			}
			
			@Override
			public void refreshComments() {
				myCommentViewer.refresh();
			}	
		});
		
		myStage = new Stage();
		VBox myView = new VBox();
		myView.getChildren().addAll(myXMLViewer.getView(), myDataViewer.getView(),
				myCommentViewer.getView(), myCommentBox.getView());
		Scene scene = new Scene(myView);
		myStage.setScene(scene);
		myStage.show();
								
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
		
	}


}
