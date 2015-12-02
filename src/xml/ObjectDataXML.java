package xml;

import java.io.File;

import xml.data.ObjectData;

public class ObjectDataXML extends AbstractXML<ObjectData> {
	
	@Override
	public String generateXML(ObjectData o) {
		ObjectData pd = (ObjectData) o;
		try {
			String xml = xstream.toXML(pd);
			return xml;
		} catch (Exception e) {
			System.out.println("PlayerData XML Write Error");
			return "";
		}
	}

	@Override
	public ObjectData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			ObjectData pd = (ObjectData) xstream.fromXML(xml);
			return pd;
		} catch (Exception e) {
			System.out.println("PlayerData XML Read Error");
			return null;
		}
	}
}
