package xml;

import java.io.File;

import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;

public class GameXML extends AbstractXML {
	@Override
	public String generateXML(Object o) {
		Game g = (Game) o;
		try {
			String xml = xstream.toXML(g);
			return xml;
		} catch (Exception e) {
			System.out.println("Game XML Write Error");
			return "";
		}
	}

	@Override
	public Game loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			Game g = (Game) xstream.fromXML(xml);
			return g;
		} catch (Exception e) {
			System.out.println("Game XML Read Error");
			return null;
		}
	}

}
