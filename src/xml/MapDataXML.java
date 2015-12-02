package xml;

import java.io.File;

import xml.data.MapData;

public class MapDataXML extends AbstractXML<MapData> {

	@Override
	public String generateXML(MapData o) {
		MapData gmd = (MapData) o;
		try {
			String xml = xstream.toXML(gmd);
			return xml;
		} catch (Exception e) {
			System.out.println("GameMapData XML Write Error");
			return "";
		}
	}

	@Override
	public MapData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			MapData gmd = (MapData) xstream.fromXML(xml);
			return gmd;
		} catch (Exception e) {
			System.out.println("GameMapData XML Read Error");
			return null;
		}
	}

}
