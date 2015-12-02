package xml;

import java.io.File;

import xml.data.GameData;

public class GameDataXML extends AbstractXML {
	@Override
	public String generateXML(Object o) {
		GameData g = (GameData) o;
		try {
			String xml = xstream.toXML(g);
			return xml;
		} catch (Exception e) {
			System.out.println("Game XML Write Error");
			return "";
		}
	}

	@Override
	public GameData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			GameData g = (GameData) xstream.fromXML(xml);
			return g;
		} catch (Exception e) {
			System.out.println("Game XML Read Error");
			return null;
		}
	}

}
