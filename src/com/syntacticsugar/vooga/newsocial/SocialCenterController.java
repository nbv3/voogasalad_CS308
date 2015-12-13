package com.syntacticsugar.vooga.newsocial;

import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.social.IUploader;
import com.syntacticsugar.vooga.social.UploaderInfoBox;
import com.syntacticsugar.vooga.util.filechooser.FileChooserUtil;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import com.syntacticsugar.vooga.xml.XMLHandler;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser.ExtensionFilter;

public class SocialCenterController implements IVoogaApp {

	private Stage myStage;
	private NewXMLViewer myXMLViewer;
	private NewXMLModel myXMLModel;
	private NewCommentViewer myCommentViewer;
	private NewCommentModel myCommentModel;
	private CommentBox myCommentBox;
	private NewObjectDataViewer myObjectDataViewer;
	private IWebConnector myWebInterface;
	
	public SocialCenterController() {
		initializeWebConnector();
		initializeComponents();
		myStage = new Stage();
		Scene scene = new Scene(makeSceneNode(), 800, 500);
		myStage.setScene(scene);
		myStage.show();
	}
	
	private void initializeWebConnector(){
		myWebInterface = new IWebConnector(){

			@Override
			public void downloadSelectedItem(int id) {
				downloadItem(id);
			}
			@Override
			public void uploadItem() {
				makeUploadFileChooser();
			}
			@Override
			public void postComment(String author, String comment, int id) {
				WebConnector.postComment(JSONHelper.createCommentJSON(id, author, comment));
				myCommentModel.refresh();
			}
			@Override
			public void refreshXMLList() {	
				myXMLModel.refreshData();
			}
		};
	}
	
	private void initializeComponents() {
		
		myXMLViewer = new NewXMLViewer(myWebInterface);
		myXMLModel = new NewXMLModel();
		myCommentModel = new NewCommentModel();
		myCommentViewer = new NewCommentViewer();
		myObjectDataViewer = new NewObjectDataViewer();
		myCommentBox = new CommentBox(myWebInterface);
		
		myXMLModel.addObserver(myXMLViewer);
		myCommentModel.addObserver(myCommentViewer);
		
		myXMLViewer.addObserver(myObjectDataViewer);
		myXMLViewer.addObserver(myCommentBox);
		myXMLViewer.addObserver(myCommentModel);
		
	}
	
	private void downloadItem(int id) {
		if (id == Integer.MIN_VALUE)
			return;
		else {
			FileChooserUtil.saveFile("Choose a save location.", ".xml", null, selected -> {
					XMLHandler.writeXMLToFile(JSONHelper.extractXML(WebConnector.getXML(id)),
							selected.toPath().toString());					
			});
		}
	}

	private void makeUploadFileChooser() {// EventHandler<ActionEvent> action) {
		ExtensionFilter filter = new ExtensionFilter("XML files", "*.xml", "*.XML");
		FileChooserUtil.loadFile("Choose an XML game file", filter, null, selected -> {
			new UploaderInfoBox(new IUploader() {
				@Override
				public void postXML(String author, String gamename, String description) {
					WebConnector.postXML(
							JSONHelper.createXMLJSON(author, gamename, 
									description, XMLHandler.fileToString(selected)));
				}
			});
		});
	}

	private HBox makeSceneNode(){
		HBox fullView = new HBox();
		VBox myLeft = new VBox();
		myLeft.getChildren().add(myXMLViewer.getView());
		myLeft.getChildren().add(myObjectDataViewer.getView());
		myLeft.setPrefWidth(700);
		fullView.getChildren().add(myLeft);
		VBox myRight = new VBox();
		myRight.getChildren().addAll(myCommentViewer.getView(), myCommentBox.getView());
		fullView.getChildren().add(myRight);
		return fullView;
	}
	
	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
		
	}
	
	
	
}
