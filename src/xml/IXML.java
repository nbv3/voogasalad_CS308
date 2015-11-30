package xml;

import java.io.File;

public interface IXML {
	
	public String generateXML(Object o);
	
	public Object loadFromFile(File f);
}
