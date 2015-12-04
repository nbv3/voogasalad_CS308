package com.syntacticsugar.vooga.util.webconnect;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.util.webconnect.WebConnector;

public class WebConnectorTest {
	public static void main(String args[]) {

		//getXMLsTest();
		//getXMLTest(11);
		// postXMLTest();
		// deleteXMLTest(2);
	}

	public static void getXMLsTest() {
		JSONObject jsonOutput = WebConnector.getXMLs();
		try {
			JSONArray fields = jsonOutput.getJSONArray("xmls");
			System.out.println(fields.toString());
			JSONHelper.printArray(fields);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getXMLTest(int gameindex) {
		JSONObject jsonOutput = WebConnector.getXML(gameindex);
		System.out.println("Output: " + jsonOutput);
		System.out.println("XML: " + JSONHelper.extractXML(jsonOutput));
	}

	public static void postXMLTest() {
		String author = "the one with date";
		String gamename = "SS";
		String description = "game djlfakjdlkfjdlkfjdljflkdlfjdlfjk goes here";
		String xml = "the {\"xml here\"\"}}{{{}}}'xml or blob goes herethe xml or any blob goes herethe xml or any blob goes here";
		JSONObject request = JSONHelper.createJSON(author, gamename, description, xml);
		System.out.println("Sending Request: " + request.toString());
		String output = WebConnector.postXML(request);
		System.out.println("Output: " + output);
	}
	
	public static void deleteXMLTest(int gameindex) {
		String response = WebConnector.deleteXML(gameindex);
		System.out.println("Output: " + response);
	}
}
