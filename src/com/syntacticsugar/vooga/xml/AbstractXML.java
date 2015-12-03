package com.syntacticsugar.vooga.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public abstract class AbstractXML<T> implements IXML<T> {

	XStream xstream;

	public AbstractXML () {
		xstream = new XStream(new StaxDriver());
	}
	
	@Override
	public abstract String generateXML(T o);
	
	@Override
	public abstract T loadFromFile(File f);
		
	protected String fileToString(File f) {
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
	
	public void writeXMLToFile(String xml, String path) {
		try {
			PrintWriter out = new PrintWriter(path);
			out.println(xml);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Writing to File failed");
		}
	}
	
	public void writeXMLToFile(String xml, File f) {
		try {
			PrintWriter out = new PrintWriter(f.getPath());
			out.println(xml);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Writing to File failed");
		}
	}
}
