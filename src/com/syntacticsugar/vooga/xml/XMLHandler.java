package com.syntacticsugar.vooga.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XMLHandler<T> implements IXML<T> {

	private XStream myXStream;

	public XMLHandler () {
		this.myXStream = new XStream(new StaxDriver());
	}
	
	private String generateXML(T obj) {
		try {
			String xml = myXStream.toXML(obj);
			return xml;
		} catch (Exception e) {
			System.out.println("Game XML Write Error");
			return "";
		}
	}
	
	private String fileToString(File f) {
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
		return "";
	}
	
	private void writeXMLToFile(String xml, String path) {
		try {
			PrintWriter out = new PrintWriter(path);
			out.println(xml);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Writing to File failed");
		}
	}

	@Override
	public void write(T object, File f) {
		writeXMLToFile(generateXML(object), f.getPath());
	}
	
	@Override
	public T read(File f) {
		String xml = fileToString(f);
		try {
			T object = (T) myXStream.fromXML(xml);
			return object;
		} catch (Exception e) {
			System.out.println("Game XML Read Error");
			return null;
		}
	}
	
}
