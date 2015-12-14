// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

public class CommentModel extends Observable implements Observer {

	private int myCurrentlySelectedID;
	private List<JSONObject> myCommentList;
	
	public CommentModel(){
		myCommentList = new ArrayList<JSONObject>();
	}
	
	private void pullAndNotify() {
		try {
			JSONArray comments = WebConnector.getComments(myCurrentlySelectedID);
			myCommentList = convertJSONToList(comments);
			triggerUpdate();
		} catch (JSONException e) {
			AlertBoxFactory.createObject("No comments to pull");
		}
	}
	
	private List<JSONObject> convertJSONToList(JSONArray commentArray) throws JSONException {
		List<JSONObject> list = new ArrayList<JSONObject>();
		for (int i = 0; i<commentArray.length(); i++){
			list.add(commentArray.getJSONObject(i));
		}		
		return list;
	}
	
	private void triggerUpdate() {
		setChanged();
		notifyObservers();
	}
	
	public void refresh() {
		pullAndNotify();
	}
	
	public List<JSONObject> getCommentList(){
		return myCommentList;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		myCurrentlySelectedID = (int) arg;
		pullAndNotify();
	}
	
}
