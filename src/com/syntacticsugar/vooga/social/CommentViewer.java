package com.syntacticsugar.vooga.social;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

public class CommentViewer {

	private VBox myView;
	private ListView<Node> myListView;
	private List<Pair<String, String>> myCommentList;
	private int mySelectedItemID = Integer.MIN_VALUE;
	private String myGameName;
	private IComments myCommentInterface;
	private Stage myStage;

	public CommentViewer(IComments commentInterface) {
		myView = new VBox();
		myListView = new ListView<Node>();
		myView.getChildren().add(myListView);
		
		myCommentInterface = commentInterface;
		myGameName = commentInterface.getGameName();	
		mySelectedItemID = commentInterface.getGameID();
		
		myCommentList = new ArrayList<Pair<String, String>>();
		
		if (mySelectedItemID != Integer.MIN_VALUE) getCurrentGameComments();
		myCommentList = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		myCommentList.add(pair);
	
		myStage = new Stage();
		Scene scene = new Scene((Parent) myView,500,500); 
		myStage.setScene(scene);
		myStage.show();
	}

	private String getCurrentGameComments() {
		String serializedComments = myCommentInterface.getSerializedComments(myGameName);
		try {
			myCommentList = deserializeString(serializedComments);
			populateList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serializedComments;
	}

	public static String serializeList(List<Pair<String, String>> commentList) throws Exception {
		String serialized;
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
		outputStream.writeObject(commentList);
		outputStream.flush();
		serialized = byteStream.toString("ISO-8859-1");

		return serialized;
	}

	private List<Pair<String, String>> deserializeString(String serialized) throws Exception {
		byte bytes[] = serialized.getBytes("ISO-8859-1");
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		ObjectInputStream inputStream = new ObjectInputStream(byteStream);
		List<Pair<String, String>> deserialized = (List<Pair<String, String>>) inputStream.readObject();
		return deserialized;

	}
	
	private void postComment(String author, String content) throws Exception{
		String oldComments = getCurrentGameComments();
		List<Pair<String, String>> commentList = deserializeString(oldComments);
		commentList.add(new Pair<String,String>(author, content));
		String serialized = serializeList(commentList);
		//myCommentInterface.postComment(author, serialized);
		//JSONHelper.modifyJSON(mySelectedItemID, "comment", serialized);
		
	}
	
	private void populateList() {
		clearList();
		for (Pair<String, String> comment: myCommentList){
			addElementToList(makeListElement(comment.getKey(),comment.getValue()));
			System.out.println(comment.getKey() + comment.getValue());
		}
	}
	
	private void clearList(){
		myListView.getItems().clear();
	}
	
	private void addElementToList(Node element) {
		myListView.getItems().add(element);
	}
	
	
	private Node makeListElement(String author, String content) {
		VBox comment = new VBox();
		comment.getChildren().add(GUIFactory.buildTitleNode(author));
		comment.getChildren().add(GUIFactory.buildTitleNode(content));
		return comment;
	}
	
	public void update() {
		myCommentInterface.updateData();
		getCurrentGameComments();
	}

/*	public static void main(String[] args) throws Exception {
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		list.add(pair);
		
		//deserializeString(serializeList(list));

	}*/
}
