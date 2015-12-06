package com.syntacticsugar.vooga.newsocial;


import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CommentBox implements IVisualElement {
	
	private Node myView;
	private TextField myAuthorName;
	private TextArea myComment;
	private Button mySendButton;
	private ICommentSender mySenderInterface;
	
	public CommentBox(ICommentSender senderInterface) {
		myView = makeView();
		mySenderInterface = senderInterface;
	}

	private Node makeView(){
		VBox commentBox = new VBox();
		myAuthorName = new TextField();
		myAuthorName.getStyleClass().add("textfield");
		myComment = new TextArea("Post a comment...");
		mySendButton = GUIFactory.buildButton("Post",
				e-> postComment(),
					  100.0, null);
		Node titledAuthorField = GUIFactory.buildTitledPane("Author Name:", myAuthorName);
		Node anchorPane = GUIFactory.buildAnchorPane(titledAuthorField, mySendButton);
		commentBox.getChildren().addAll(anchorPane, myComment);
		return commentBox;
	}

	
	private void postComment(){
		if (mySenderInterface.sendComment(myAuthorName.getText(), myComment.getText())){
			clearFields();
			mySenderInterface.refreshComments();
		}
	}
	
	private void clearFields(){
		myComment.clear();
		myAuthorName.clear();
	}
	
	@Override
	public Node getView() {
		return myView;
	}

}
