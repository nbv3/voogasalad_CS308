package xml;

import environment.IEnvironment;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;

import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class LoaderSaver {
	XStream xstream;

	public LoaderSaver() {
		xstream = new XStream(new StaxDriver());
	}

	/**
	 * Takes XML and returns a valid GameEnvironment
	 * 
	 * @throws LoadingException
	 */
	public IEnvironment loadFromXML(String xml) throws LoadingException {
		System.out.println("Loading the following XML:");
		System.out.println(formatXml(xml));
		try {
			IEnvironment env = (IEnvironment) xstream.fromXML(xml);
			validateEnv(env);
			return env;
		} catch (Exception e) {
			System.out.println("Validation Error");
			throw new LoadingException();
		}
	}

	/**
	 * Takes IEnvironment and creates XML
	 * 
	 * @throws LoadingException
	 */
	public String makeXML(IEnvironment env) throws LoadingException {
		try {
			validateEnv(env);
			String xml = xstream.toXML(env);
			System.out.println("Saving the following XML:");
			System.out.println(formatXml(xml));
			return xml;
		} catch (Exception e) {
			System.out.println("Validation Error");
			throw new LoadingException();
		}
	}

	private List<String> validateEnv(IEnvironment env) throws LoadingException {
		try {
			List<String> loadErrors = env.validate();
			if (loadErrors.isEmpty()) {
				System.out.println("No Errors");
				return loadErrors;
			} else {
				System.out.println("Known Errors Here:");
				for (int i = 0; i < loadErrors.size(); i++) {
					System.out.printf("Error %d: %s\n", i + 1, loadErrors.get(i));
				}
			}
			return loadErrors;
		} catch (Exception e) {
			System.out.println("Unknown Error");
			throw new LoadingException();
		}
	}

	private static String formatXml(String xml) {

		try {
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();

			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
			StreamResult res = new StreamResult(new ByteArrayOutputStream());

			serializer.transform(xmlSource, res);

			return new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());

		} catch (Exception e) {
			return xml;
		}
	}
}
