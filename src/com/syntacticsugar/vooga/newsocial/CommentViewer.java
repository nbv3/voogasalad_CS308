package com.syntacticsugar.vooga.newsocial;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CommentViewer implements IVisualElement {

	private Node myView;
	private ListView<Node> myCommentList;
	private ICommentViewer myCommentInterface;
	
	public CommentViewer(ICommentViewer commentInterface) {
		myView = makeView();
		myCommentInterface = commentInterface;
	}
	
	private Node makeView(){
		myCommentList = new ListView<Node>();
		return GUIFactory.buildTitledPane("Comments", myCommentList);
	}
	
	private void populateList() throws JSONException{
	//	myCommentInterface.populateCommentsList();
		// need to pass in addElementToList() method
		// as the content of populateCommentsList in the class DataViewer
		
		JSONArray commentArray = WebConnector.getComments(myCommentInterface.getSelectedItemID());
		List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i<commentArray.length(); i++){
			list.add(commentArray.getJSONObject(i));
		}		
		clearList();
		for (JSONObject obj: list){
			System.out.println(obj.get("comment"));
			System.out.println("HERE!!!!");
			addElementToList(obj.getString("date"), obj.getString("time"),
					obj.getString("author"), obj.getString("comment"));
		}
		
	}
	
	public void addElementToList(String date, String time, String author, String comment){
		Node element = makeListElement(date, time, author, comment);
		myCommentList.getItems().add(element);
	}
	
	private Node makeListElement(String date, String time, String author, String comment){
		VBox commentElement = new VBox();
		VBox dateAndTime = new VBox();
		Text Date = new Text(date);
		Text Time = new Text(time);
		Text Comment = new Text(comment);
		HBox Author = GUIFactory.buildTitleNode(author);
		dateAndTime.getChildren().addAll(Date, Time);
		AnchorPane tag = GUIFactory.buildAnchorPane(Author, dateAndTime);		
		TextFlow content = new TextFlow(Comment);
		commentElement.getChildren().addAll(tag, content);
		return commentElement;		
	}
	

	public void refresh(){
		// pass this as the method of refreshComment
		clearList();
		try {
			populateList();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void clearList(){
		myCommentList.getItems().clear();
	}
		
	@Override
	public Node getView() {
		return null;
	}

}
