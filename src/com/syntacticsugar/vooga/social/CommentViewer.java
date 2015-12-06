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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

public class CommentViewer {

	private VBox myView;
	private ListView<Node> myListView;
	private List<JSONObject> myCommentList;
	private String myGameName;
	private IComments myCommentInterface;
	private Stage myStage;

	public CommentViewer(IComments commentInterface) {
		myView = new VBox();
		myListView = new ListView<Node>();
		myView.getChildren().add(myListView);
		
		myCommentInterface = commentInterface;
		myCommentList = new ArrayList<JSONObject>();
		//myGameName = commentInterface.getGameName();	
		
		myStage = new Stage();
		Scene scene = new Scene(myView,500,500); 
		myStage.setScene(scene);
		myStage.show();
	}

	private void pullCurrentGameComments() throws JSONException {
		JSONArray commentArray = WebConnector.getComments(myCommentInterface.getGameID());
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
		JSONHelper.createCommentJSON(myCommentInterface.getGameID(), author, content);
		update();
		populateList();
	}
	
	private void populateList() throws JSONException {
		clearListview();
		for (JSONObject obj: myCommentList){
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
	
	public void update() throws JSONException {
		myCommentInterface.updateData();
		pullCurrentGameComments();
		System.out.println("Here!");
	}

/*	public static void main(String[] args) throws Exception {
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		list.add(pair);
		
		//deserializeString(serializeList(list));

	}*/
}
