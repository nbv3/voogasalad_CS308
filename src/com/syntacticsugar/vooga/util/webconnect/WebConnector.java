package com.syntacticsugar.vooga.util.webconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class WebConnector {

	private final static String CHARSET = "UTF-8";
	private final static String GET_GAMES_URL = "http://easywebapi.com/api/xml";
	private final static String GET_GAME_URL = "http://easywebapi.com/api/xml/";
	private final static String POST_GAME_URL = "http://easywebapi.com/api/newxml";

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
			System.out.println("Invalid URL");
		} catch (IOException e) {
			System.out.println("Invalid IO");
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
				System.out.println("Failed reading JSON");
			}
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
		} catch (IOException e) {
			System.out.println("Invalid IO");
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
				System.out.println("Failed reading JSON");
			}
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL");
		} catch (IOException e) {
			System.out.println("Invalid IO");
		}
		return null;
	}
	
}
