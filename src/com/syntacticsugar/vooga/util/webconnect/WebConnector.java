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

import org.json.JSONException;
import org.json.JSONObject;


public class WebConnector {
	public static void main(String args[]) {
		//System.out.println(getXML());
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("xml","<something here again>");
		map.put("author", "Michael");
		map.put("gamename", "marioch");
		map.put("description", "some desc");
				

		
		JSONObject request = new JSONObject(map);
		System.out.println(request.toString());
		postXML(request);
	}
	
	
	public static void postXML(JSONObject json) {
		String query = json.toString();
		String url = "http://easywebapi.com/api/newxml";
		String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
		URLConnection connection;
		try {
			connection = new URL(url).openConnection();
			connection.setDoOutput(true); // Triggers POST.
			connection.setRequestProperty("Accept-Charset", charset);
			connection.setRequestProperty("Content-Type", "application/json;charset=" + charset);

			try (OutputStream output = connection.getOutputStream()) {
			    output.write(query.getBytes(charset));
			}

			InputStream response = connection.getInputStream();
			
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(response, charset)); 
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
			    responseStrBuilder.append(inputStr);
			
			System.out.println(responseStrBuilder.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static String getXML() {
		String url = "http://easywebapi.com/api/xml";
		String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()
	
		try {
			InputStream response = new URL(url).openStream();
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(response, charset)); 
			StringBuilder responseStrBuilder = new StringBuilder();

			String inputStr;
			while ((inputStr = streamReader.readLine()) != null)
			    responseStrBuilder.append(inputStr);
			try {
				JSONObject json = new JSONObject(responseStrBuilder.toString());
				return json.toString();
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
		return "";

	}
}
