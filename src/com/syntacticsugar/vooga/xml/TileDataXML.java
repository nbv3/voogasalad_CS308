package com.syntacticsugar.vooga.xml;

import java.io.File;

import com.syntacticsugar.vooga.xml.data.TileData;

public class TileDataXML extends AbstractXML<TileData> {

	@Override
	public String generateXML(TileData o) {
		TileData gmd = (TileData) o;
		try {
			String xml = xstream.toXML(gmd);
			return xml;
		} catch (Exception e) {
			System.out.println("TileData XML Write Error");
			return "";
		}
	}

	@Override
	public TileData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			TileData gmd = (TileData) xstream.fromXML(xml);
			return gmd;
		} catch (Exception e) {
			System.out.println("TileData XML Read Error");
			return null;
		}
	}

}
