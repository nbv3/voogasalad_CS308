package com.syntacticsugar.vooga.xml;

import java.io.File;

import com.syntacticsugar.vooga.xml.data.TowerData;

public class TowerDataXML extends AbstractXML<TowerData> {

	@Override
	public String generateXML(TowerData o) {
		TowerData gmd = (TowerData) o;
		try {
			String xml = xstream.toXML(gmd);
			return xml;
		} catch (Exception e) {
			System.out.println("GameMapData XML Write Error");
			return "";
		}
	}

	@Override
	public TowerData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			TowerData gmd = (TowerData) xstream.fromXML(xml);
			return gmd;
		} catch (Exception e) {
			System.out.println("GameMapData XML Read Error");
			return null;
		}
	}

}
