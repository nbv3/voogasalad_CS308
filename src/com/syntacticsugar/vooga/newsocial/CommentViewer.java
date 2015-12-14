package com.syntacticsugar.vooga.newsocial;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;
import com.syntacticsugar.vooga.util.ResourceManager;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.gui.factory.GUIFactory;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class CommentViewer implements Observer, IVisualElement {

	private Node myView;
	private ListView<Node> myListView;
	
	public CommentViewer(){
		myView = makeView();
	}
	
	private Node makeView(){
		myView = new VBox();
		myListView = new ListView<Node>();
		TitledPane pane = GUIFactory.buildTitledPane(ResourceManager.getString("comments"), myListView);
		((VBox) myView).getChildren().add(pane);
		return myView;
	}
	
	private void populateList(List<JSONObject> commentList) {
		clearList();
		for (JSONObject obj: commentList){
			try {
				addElementToList(makeListElement(obj.getString("date"), obj.getString("time"),
						obj.getString("author"), obj.getString("comment")));
			} catch (JSONException e) {
				AlertBoxFactory.createObject("Unknown error!");
			}
		}
	}
	
	private void clearList(){
		myListView.getItems().clear();
	}
	
	private void addElementToList(Node element) {
		myListView.getItems().add(element);
	}
	
	
	private Node makeListElement(String date, String time, String author, String comment){
		VBox commentElement = new VBox();
		VBox dateAndTime = new VBox();
		Text Date = new Text(date);
		Text Time = new Text(time);
		Text Author = new Text(author);
		applyTextStyle(Date, Time, Author);
		Text Comment = new Text(comment);
		dateAndTime.getChildren().addAll(Date, Time);
		AnchorPane tag = GUIFactory.buildAnchorPane(Author, dateAndTime);		
		TextFlow content = new TextFlow(Comment);
		content.setMaxWidth(250);
		commentElement.getChildren().addAll(tag, content);
		return commentElement;		
	}
		

	private void applyTextStyle(Text... text) {
		for (Text textElement : text) {
			textElement.setFill(Color.GREY);
			textElement.setStyle("-fx-font: 11 arial;");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		CommentModel commentData = (CommentModel) o;
		populateList(commentData.getCommentList());
	}

	@Override
	public Node getView() {
		return myView;
	}
	
	
}
