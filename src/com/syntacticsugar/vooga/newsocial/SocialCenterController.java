package com.syntacticsugar.vooga.newsocial;

import com.syntacticsugar.vooga.menu.IVoogaApp;
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
	private IWebConnector myWebInterface;

	public SocialCenterController() {
		initializeWebConnector();
		initializeComponents();
		myStage = new Stage();
		Scene scene = new Scene(makeSceneNode(), 800, 500);
		myStage.setScene(scene);
		myStage.show();
	}

	private void initializeWebConnector() {
		myWebInterface = new IWebConnector() {

			@Override
			public void downloadItem(int id) {
				downloadItemByID(id);
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
		initializeXMLViewer();
		initializeObjectDataViewer();
		initializeCommentsSection();
		addAllObservers();
	}

	private void initializeXMLViewer() {
		myXMLViewer = new XMLViewer(myWebInterface);
		myXMLModel = new XMLModel();
	}

	private void initializeObjectDataViewer() {
		myObjectDataViewer = new ObjectDataViewer();
	}

	private void initializeCommentsSection() {
		myCommentBox = new CommentBox(myWebInterface);
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
			FileChooserUtil.saveFile("Choose a save location.", ".xml", null, selected -> {
				XMLHandler.writeXMLToFile(JSONHelper.extractXML(WebConnector.getXML(id)), selected.toPath().toString());
			});
		}
	}

	private void makeUploadFileChooser() {
		ExtensionFilter filter = new ExtensionFilter("XML files", "*.xml", "*.XML");
		FileChooserUtil.loadFile("Choose an XML game file", filter, null, selected -> {
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
