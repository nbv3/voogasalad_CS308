package com.syntacticsugar.vooga.util.webconnect;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.syntacticsugar.vooga.social.CommentViewer;
import com.syntacticsugar.vooga.util.webconnect.WebConnector;

import javafx.util.Pair;

public class WebConnectorTest {
	public static void main(String args[]) throws Exception {

		//getXMLsTest();
		//getXMLTest(11);
		postXMLTest();
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

	public static void postXMLTest() throws Exception {
		String author = "the one with date";
		String gamename = "SS";
		String description = "game djlfakjdlkfjdlkfjdljflkdlfjdlfjk goes here";
		File f = new File("src/com/syntacticsugar/vooga/util/compress/Untitled.xml");
		//String xml = FileHelper.readFile(f);
		
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		list.add(pair);
		String comment = CommentViewer.serializeList(list);
		
		
		String xml = "<testxml>soem shittejjiejiefe</testxml>";
		JSONObject request = JSONHelper.createJSON(author, gamename, description, xml, comment);
		System.out.println("Sending Request: " + request.toString());
		String output = WebConnector.postXML(request);
		System.out.println("Output: " + output);
	}
	
	public static void deleteXMLTest(int gameindex) {
		String response = WebConnector.deleteXML(gameindex);
		System.out.println("Output: " + response);
	}
}
