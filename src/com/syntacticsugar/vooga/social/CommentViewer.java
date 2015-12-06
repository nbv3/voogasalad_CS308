package com.syntacticsugar.vooga.social;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.JSONHelper;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

public class CommentViewer {

	private TitledPane myView;
	private ListView<Node> myListView;
	private List<JSONObject> myCommentList;
	private String myGameName;
	private int mySelectedItemID;
	private Stage myStage;

	public CommentViewer() {
		myListView = new ListView<Node>();
		myView = GUIFactory.buildTitledPane("Comments", myListView);
		myCommentList = new ArrayList<JSONObject>();
	}

	private void pullCurrentGameComments() throws JSONException {
		JSONArray commentArray = WebConnector.getComments(mySelectedItemID);
		myCommentList = convertJSONToList(commentArray);
	}

	private List<JSONObject> convertJSONToList(JSONArray commentArray) throws JSONException {
		List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i<commentArray.length(); i++){
			list.add(commentArray.getJSONObject(i));
		}		
		return list;
	}
	
	private void postComment(String author, String content) throws Exception{
		JSONHelper.createCommentJSON(mySelectedItemID, author, content);
		update();
		populateList();
	}
	
	private void populateList() throws JSONException {
		clearListview();
		for (JSONObject obj: myCommentList){
			System.out.println(obj.get("comment"));
			System.out.println("HERE!!!!");
			addElementToList(makeListElement(obj.getString("author"), obj.getString("comment")));
		}
	}
	
	private void clearListview(){
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
	
	public void updateFromDataViewer(int id) throws JSONException{
		mySelectedItemID = id;
		update();
	}
	
	public void update() throws JSONException {
		//myCommentInterface.updateData();
		pullCurrentGameComments();
		populateList();
		System.out.println("Here!");
	}
	
	public Node getView(){
		return myView;
	}

}
