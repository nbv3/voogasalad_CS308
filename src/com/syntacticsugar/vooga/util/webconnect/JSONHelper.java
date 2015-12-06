package com.syntacticsugar.vooga.util.webconnect;

import java.util.HashMap;
import java.util.Map;
import org.json.*;

import com.syntacticsugar.vooga.util.compress.Compressor;

public class JSONHelper {
	public static String extractXML(JSONObject json) {
		try {
			String xml = json.getString("xml");
			xml = Compressor.decompress16(xml);
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

	public static JSONObject createXMLJSON(String author, String gamename, String description, String xml) {
		Map<String, String> map = new HashMap<String, String>();

		xml = Compressor.compress16(xml);
		map.put("xml", xml);
		map.put("author", author);
		map.put("gamename", gamename);
		map.put("description", description);

		return new JSONObject(map);
	}

	public static JSONObject createCommentJSON(int id, String author, String comment) {
		Map<String, String> map = new HashMap<String, String>();

		map.put("id", Integer.toString(id));
		map.put("author", author);
		map.put("comment", comment);

		return new JSONObject(map);
	}

}
