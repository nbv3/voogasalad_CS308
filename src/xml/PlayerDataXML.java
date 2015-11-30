package xml;

import java.io.File;

public class PlayerDataXML extends AbstractXML {
	@Override
	public String generateXML(Object o) {
		PlayerData pd = (PlayerData) o;
		try {
			String xml = xstream.toXML(pd);
			return xml;
		} catch (Exception e) {
			System.out.println("PlayerData XML Write Error");
			return "";
		}
	}

	@Override
	public PlayerData loadFromFile(File f) {
		String xml = fileToString(f);
		try {
			PlayerData pd = (PlayerData) xstream.fromXML(xml);
			return pd;
		} catch (Exception e) {
			System.out.println("PlayerData XML Read Error");
			return null;
		}
	}
}
