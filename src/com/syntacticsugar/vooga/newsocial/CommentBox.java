package com.syntacticsugar.vooga.newsocial;

import java.util.Observable;
import java.util.Observer;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CommentBox implements IVisualElement, Observer {

	private Node myView;
	private Button mySendButton;
	private TextArea myComment;
	private TextField myAuthorName;
	private int mySelectedItemID;
	private IWebConnector myWebInterface;
	private boolean firstTime;
	
	public CommentBox(IWebConnector webInterface){
		firstTime = true;
		myView = makeView();
		mySelectedItemID = Integer.MIN_VALUE;
		myWebInterface = webInterface;
	}
	
	private Node makeView(){
		return makeCommentBox();
	}
	
	private Node makeCommentBox(){
		VBox commentBox = new VBox();
		myAuthorName = new TextField();
		myComment = new TextArea(ResourceManager.getString("post_comment"));
		mySendButton = GUIFactory.buildButton(ResourceManager.getString("post_button"),
				e -> postComment(myAuthorName.getText(), myComment.getText()), 100.0, null);
		setFieldProperties();
		Node titledAuthorField = GUIFactory.buildTitledPane(ResourceManager.getString("author_name"),
				myAuthorName);
		HBox pane = new HBox();
		pane.getChildren().addAll(titledAuthorField, mySendButton);
		commentBox.getChildren().addAll(pane, myComment);
		return commentBox;
	}
	
	private void postComment(String author, String comment){
		if (author.length() == 0 || comment.length() == 0) return;
		if (mySelectedItemID == Integer.MIN_VALUE || firstTime) return;
		
		myWebInterface.postComment(author, comment, mySelectedItemID);
		//update();
		//populateList();  // need to put these methods in the postComment method;
		setFieldDefaults();
	}
	
	private void setFieldProperties(){
		myComment.setOnMouseClicked(e->
			myComment.clear());
		myComment.setWrapText(true);
		mySendButton.setMaxHeight(Integer.MAX_VALUE);
		mySendButton.setMaxWidth(Integer.MAX_VALUE);
		HBox.setHgrow(mySendButton, Priority.ALWAYS);

	}
	
	private void setFieldDefaults(){
		myComment.setText(ResourceManager.getString("post_comment"));
		myAuthorName.clear();
	}

	@Override
	public Node getView() {
		return myView;
	}

	@Override
	public void update(Observable o, Object arg) {
		mySelectedItemID = (int) arg;
		firstTime = false;
	}
	
	
	
}
