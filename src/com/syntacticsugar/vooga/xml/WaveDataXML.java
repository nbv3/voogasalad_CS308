package com.syntacticsugar.vooga.xml;

import java.io.File;

import com.syntacticsugar.vooga.xml.data.WaveData;

public class WaveDataXML extends AbstractXML<WaveData> {

	@Override
	public String generateXML(WaveData o) {
		WaveData gmd = (WaveData) o;
		try {
			String xml = xstream.toXML(gmd);
			return xml;
		} catch (Exception e) {
			System.out.println("Wave XML Write Error");
			return "";
		}
	}

	@Override
	public WaveData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			WaveData gmd = (WaveData) xstream.fromXML(xml);
			return gmd;
		} catch (Exception e) {
			System.out.println("Wave XML Read Error");
			return null;
		}
	}

}
