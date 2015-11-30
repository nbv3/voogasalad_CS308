package xml;

import java.io.File;

public interface IXML<T> {
	
	public String generateXML(T o);
	
	public T loadFromFile(File f);
}
