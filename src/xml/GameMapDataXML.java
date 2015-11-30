package xml;

import java.io.File;

import com.syntacticsugar.vooga.gameplayer.manager.IGameManager;
import com.syntacticsugar.vooga.gameplayer.universe.map.GameMap;
import com.syntacticsugar.vooga.util.xml.LoadingException;

public class GameMapDataXML extends AbstractXML {

	@Override
	public String generateXML(Object o) {
		GameMapData gmd = (GameMapData) o;
		try {
			String xml = xstream.toXML(gmd);
			return xml;
		} catch (Exception e) {
			System.out.println("GameMapData XML Write Error");
			return "";
		}
	}

	@Override
	public GameMapData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			GameMapData gmd = (GameMapData) xstream.fromXML(xml);
			return gmd;
		} catch (Exception e) {
			System.out.println("GameMapData XML Read Error");
			return null;
		}
	}

}
