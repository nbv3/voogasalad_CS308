package com.syntacticsugar.vooga.social;

import org.json.JSONObject;

public interface IComments {

	public String getSerializedComments(String gameName);
	
	public void postComment(String author, String comment);
	
}
