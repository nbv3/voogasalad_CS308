// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;

import com.syntacticsugar.vooga.menu.IVoogaApp;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.filechooser.FileChooserUtil;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;
import com.syntacticsugar.vooga.xml.XMLHandler;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser.ExtensionFilter;

public class SocialCenterController implements IVoogaApp {

	private Stage myStage;
	private XMLViewer myXMLViewer;
	private XMLModel myXMLModel;
	private CommentViewer myCommentViewer;
	private CommentModel myCommentModel;
	private CommentBox myCommentBox;
	private ObjectDataViewer myObjectDataViewer;
	private IWebFileExhange myExchangeInterface;
	private IWebConnector myWebConnector;
	private IComments myCommentInterface;
	private IRefresher myXMLRefresher;

	public SocialCenterController() {
		initializeInterfaces();
		initializeComponents();
		myStage = new Stage();
		Scene scene = new Scene(makeSceneNode(), 800, 500);
		myStage.setScene(scene);
		myStage.show();
	}

	private void initializeInterfaces() {
		initializeWebFileExchanger();
		initializeXMLRefresher();
		initializeCommentInterface();
		initializeWebConnector();
	}

	private void initializeWebFileExchanger() {
		myExchangeInterface = new IWebFileExhange() {
			@Override
			public void downloadItem(int id) {
				downloadItemByID(id);
			}

			@Override
			public void uploadItem() {
				makeUploadFileChooser();
			}
		};
	}

	private void initializeCommentInterface() {
		myCommentInterface = new IComments() {
			@Override
			public void postComment(String author, String comment, int id) {
				WebConnector.postComment(JSONHelper.createCommentJSON(id, author, comment));
				myCommentModel.refresh();
			}
		};
	}

	private void initializeXMLRefresher() {
		myXMLRefresher = new IRefresher() {
			@Override
			public void refresh() {
				myXMLModel.refreshData();
			}
		};
	}
	
	private void initializeWebConnector() {
		myWebConnector = new IWebConnector(){
			@Override
			public void getXMLData(int id) {
				WebConnector.getXMLData(id);				
			}
		};
	}

	private void initializeComponents() {
		initializeXMLViewer();
		initializeObjectDataViewer();
		initializeCommentsSection();
		addAllObservers();
	}

	private void initializeXMLViewer() {
		myXMLViewer = new XMLViewer(myXMLRefresher, myExchangeInterface);
		myXMLModel = new XMLModel();
	}

	private void initializeObjectDataViewer() {
		myObjectDataViewer = new ObjectDataViewer(myWebConnector);
	}

	private void initializeCommentsSection() {
		myCommentBox = new CommentBox(myCommentInterface);
		myCommentModel = new CommentModel();
		myCommentViewer = new CommentViewer();
	}

	private void addAllObservers() {
		myCommentModel.addObserver(myCommentViewer);
		myXMLViewer.addObserver(myObjectDataViewer);
		myXMLViewer.addObserver(myCommentBox);
		myXMLViewer.addObserver(myCommentModel);
	}

	private HBox makeSceneNode() {
		HBox fullView = new HBox();
		fullView.getChildren().addAll(makeDataSectionView(), makeCommentsSectionView());
		return fullView;
	}

	private Node makeDataSectionView() {
		VBox left = new VBox();
		left.getChildren().add(myXMLViewer.getView());
		left.getChildren().add(myObjectDataViewer.getView());
		left.setPrefWidth(700);
		return left;
	}

	private Node makeCommentsSectionView() {
		VBox right = new VBox();
		right.getChildren().addAll(myCommentViewer.getView(), myCommentBox.getView());
		return right;
	}

	private void downloadItemByID(int id) {
		if (id == Integer.MIN_VALUE)
			return;
		else {
			FileChooserUtil.saveFile(ResourceManager.getString("filechooser_saving"), ".xml", null, selected -> {
				XMLHandler.writeXMLToFile(JSONHelper.extractXML(WebConnector.getXML(id)), selected.toPath().toString());
			});
		}
	}

	private void makeUploadFileChooser() {
		ExtensionFilter filter = new ExtensionFilter("XML files", "*.xml", "*.XML");
		FileChooserUtil.loadFile(ResourceManager.getString("xml_filechooser"), filter, null, selected -> {
			new UploaderInfoBox((author, gamename, description) -> {
				WebConnector.postXML(
						JSONHelper.createXMLJSON(author, gamename, description, XMLHandler.fileToString(selected)));
			});
		});
	}

	@Override
	public void assignCloseHandler(EventHandler<WindowEvent> onclose) {
		myStage.setOnCloseRequest(onclose);
	}

}
