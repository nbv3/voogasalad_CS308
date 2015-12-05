package com.syntacticsugar.vooga.util.webconnect;

import java.util.HashMap;
import java.util.Map;
import org.json.*;


public class JSONHelper {
	public static String extractXML(JSONObject json) {
		try {
			String xml = json.getString("xml");
			return xml;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
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
	
	public static JSONObject createJSON(String author, String gamename, String description, String xml, String comments) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("xml", xml);
		map.put("author", author);
		map.put("gamename", gamename);
		map.put("description", description);

		return new JSONObject(map);
	}
}
