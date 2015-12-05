package com.syntacticsugar.vooga.util.webconnect;

import org.json.JSONObject;

public class WebConnector {

	private final static String GET_GAMES_URL = "http://easywebapi.com/api/xml";
	private final static String GET_GAME_URL = "http://easywebapi.com/api/xml/";
	private final static String POST_GAME_URL = "http://easywebapi.com/api/newxml";
	private final static String DELETE_GAME_URL = "http://easywebapi.com/api/deletexml/";
	private final static String POST_COMMENT_URL = "http://easywebapi.com/api/newcomment";
	private final static String GET_COMMENTS_URL = "http://easywebapi.com/api/comment/";

	public static String postXML(JSONObject json) {
		return WebConnectorHelper.post(json, POST_GAME_URL);
	}

	public static JSONObject getXMLs() {
		return WebConnectorHelper.get(GET_GAMES_URL);
	}

	public static JSONObject getXML(int gameindex) {
		return WebConnectorHelper.get(GET_GAME_URL + gameindex);
	}

	public static String deleteXML(int gameindex) {
		return WebConnectorHelper.delete(DELETE_GAME_URL + gameindex);
	}

	public static String postComment(JSONObject json) {
		return WebConnectorHelper.post(json, POST_COMMENT_URL);
	}
	
	public static JSONObject getComments(int gameindex) {
		return WebConnectorHelper.get(GET_COMMENTS_URL+gameindex);
	}
}
