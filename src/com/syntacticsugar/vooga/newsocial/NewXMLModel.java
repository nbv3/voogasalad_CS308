package com.syntacticsugar.vooga.newsocial;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.syntacticsugar.vooga.util.gui.factory.AlertBoxFactory;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

public class NewXMLModel extends Observable {

	private List<JSONObject> myXMLItems;
	
	public NewXMLModel(){
		myXMLItems = new ArrayList<JSONObject>();
		refreshData();
	}
	
	private void pullAndNotify() {
		JSONObject XMLs = WebConnector.getXMLs();
		JSONArray array;
		try {
			array = XMLs.getJSONArray("xmls");
			for (int i = 0; i < array.length(); i++) {
				addItemToList((JSONObject) array.get(i));
			}
			triggerUpdate();
		} catch (JSONException e) {
			AlertBoxFactory.createObject("Could not find any games online!");
		}
	}
	
	private void addItemToList(JSONObject item) {
		myXMLItems.add(item);
	}
	
	private void triggerUpdate() {
		setChanged();
		notifyObservers();
	}

	public void refreshData(){
		myXMLItems.clear();
		pullAndNotify();
	}
	
	public List<JSONObject> getItemList(){
		return myXMLItems;
	}
	
}
