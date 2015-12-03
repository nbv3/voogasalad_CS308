package com.syntacticsugar.vooga.util.webconnect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


public class WebConnector {
	public static void main(String args[]) {
		System.out.println(getXML());
	}
	
	
	public static void postXML() {
		
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
