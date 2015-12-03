package com.syntacticsugar.vooga.util.webconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebConnector {

	private final static String CHARSET = "UTF-8";
	private final static String GET_GAMES_URL = "http://easywebapi.com/api/xml";
	private final static String GET_GAME_URL = "http://easywebapi.com/api/xml/";
	private final static String POST_GAME_URL = "http://easywebapi.com/api/newxml";

	public static void main(String args[]) {
		//getXMLsTest();
		//getXMLTest();
		//postXMLTest();
	}

	public static void getXMLsTest() {
		JSONObject jsonOutput = getXMLs();
		try {
			JSONArray fields = jsonOutput.getJSONArray("xmls");
			System.out.println(fields.toString());
			printArray(fields);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getXMLTest() {
		int gameindex = 1;
		JSONObject jsonOutput = getXML(gameindex);
		System.out.println("Output: "+jsonOutput);
	}

	public static void postXMLTest() {
		String author = "Author anme";
		String gamename = "Mario ";
		String description = "game descritppion goes here";
		String xml = "the xml or any blob goes here";
		JSONObject request = createJSON(author, gamename, description, xml);
		System.out.println("Sending Request: " + request.toString());
		String output = postXML(request);
		System.out.println("Output: " + output);
	}

	public static JSONObject createJSON(String author, String gamename, String description, String xml) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("xml", xml);
		map.put("author", author);
		map.put("gamename", gamename);
		map.put("description", description);

		return new JSONObject(map);
	}

	public static String postXML(JSONObject json) {
		String query = json.toString();

		URLConnection connection;
		try {
			connection = new URL(POST_GAME_URL).openConnection();
			connection.setDoOutput(true); // Triggers POST.
			connection.setRequestProperty("Accept-Charset", CHARSET);
			connection.setRequestProperty("Content-Type", "application/json;charset=" + CHARSET);

			try (OutputStream output = connection.getOutputStream()) {
				output.write(query.getBytes(CHARSET));
			}

			InputStream response = connection.getInputStream();

			BufferedReader streamReader = new BufferedReader(new InputStreamReader(response, CHARSET));
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);

			return responseStrBuilder.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static JSONObject getXMLs() {
		try {
			InputStream response = new URL(GET_GAMES_URL).openStream();
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(response, CHARSET));
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			try {
				JSONObject json = new JSONObject(responseStrBuilder.toString());
				return json;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static JSONObject getXML(int gameindex) {
		try {
			InputStream response = new URL(GET_GAME_URL + gameindex).openStream();
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(response, CHARSET));
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
				responseStrBuilder.append(inputStr);
			try {
				JSONObject json = new JSONObject(responseStrBuilder.toString());
				return json;
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void printArray(JSONArray arr) {
		for (int i = 0; i < arr.length(); i++) {
			try {
				JSONObject entry = (JSONObject) arr.get(i);
				System.out.println(entry.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
