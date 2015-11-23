package com.syntacticsugar.vooga.util.xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;

import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.syntacticsugar.vooga.gameplayer.manager.IGameManager;
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
	public IGameManager loadFromXML(String xml) throws LoadingException {
		System.out.println("Loading the following XML:");
		System.out.println(formatXml(xml));
		try {
			IGameManager env = (IGameManager) xstream.fromXML(xml);
			//validateEnv(env);
			return env;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Validation Error");
			throw new LoadingException();
		}
	}
	
	public IGameManager loadFromFile(File f) throws LoadingException {
		String xml = fileToXML(f);
		return  loadFromXML(xml);
	}

	/**
	 * Takes IEnvironment and creates XML
	 * 
	 * @throws LoadingException
	 */
	public String makeXML(IGameManager gm) throws LoadingException {
		try {
			//validateEnv(level);
			String xml = xstream.toXML(gm);
			System.out.println("Saving the following XML:");
			System.out.println(formatXml(xml));
			return xml;
		} catch (Exception e) {
			System.out.println("Validation Error");
			throw new LoadingException();
		}
	}

	private List<String> validateEnv(IGameManager env) throws LoadingException {
//		try {
//			List<String> loadErrors = env.validate();
//			if (loadErrors.isEmpty()) {
//				System.out.println("No Errors");
//				return loadErrors;
//			} else {
//				System.out.println("Known Errors Here:");
//				for (int i = 0; i < loadErrors.size(); i++) {
//					System.out.printf("Error %d: %s\n", i + 1, loadErrors.get(i));
//				}
//			}
//			return loadErrors;
//		} catch (Exception e) {
//			System.out.println("Unknown Error");
//			throw new LoadingException();
//		}
		return null;
	}
	
	private String fileToXML(File f) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			StringBuilder sb = new StringBuilder();

			while((line=br.readLine())!= null){
			    sb.append(line.trim());
			}
			br.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; // TODO
	}

	public String formatXml(String xml) {

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
