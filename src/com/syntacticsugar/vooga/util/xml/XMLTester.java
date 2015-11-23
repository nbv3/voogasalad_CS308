package com.syntacticsugar.vooga.util.xml;

import com.syntacticsugar.vooga.gameplayer.Level;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;

public class XMLTester {
	public static void main(String args[]) {
		IGameMap map = new GameMap(500, 500, 50, 50);
		Level level = new Level();
		level.setMap(map);
		LoaderSaver xmler = new LoaderSaver();
		String xml = "";
		try {
			xml = xmler.makeXML(level);
		} catch (LoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(xml);

	}
}
