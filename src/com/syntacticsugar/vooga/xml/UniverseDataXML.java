package com.syntacticsugar.vooga.xml;

import java.io.File;

import com.syntacticsugar.vooga.xml.data.UniverseData;

public class UniverseDataXML extends AbstractXML<UniverseData> {

	@Override
	public String generateXML(UniverseData o) {
		UniverseData gmd = (UniverseData) o;
		try {
			String xml = xstream.toXML(gmd);
			return xml;
		} catch (Exception e) {
			System.out.println("GameMapData XML Write Error");
			return "";
		}
	}

	@Override
	public UniverseData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			UniverseData gmd = (UniverseData) xstream.fromXML(xml);
			return gmd;
		} catch (Exception e) {
			System.out.println("GameMapData XML Read Error");
			return null;
		}
	}

}
