package com.syntacticsugar.vooga.social;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.util.Pair;

public class CommentViewer extends ListViewer {

	private List<Pair<String, String>> myCommentList;
	private String myGameName;
	private ICommentExchanger myCommentExchanger;

	public CommentViewer(String gameName, ICommentExchanger commentExchanger) {
		myGameName = gameName;
		myCommentList = new ArrayList<Pair<String, String>>();
		myCommentExchanger = commentExchanger;

	}

	private static InputStream getCurrentGameSerializedComments() {
		String serializedComments = "hellooooooo";// myCommentExchanger.getSerializedComments(myGameName);
		InputStream stream = new ByteArrayInputStream(serializedComments.getBytes(StandardCharsets.UTF_8));
		System.out.println(stream);
		return stream;
	}

	private static String serializeList(List<Pair<String, String>> commentList) throws Exception {
		 String serializedObject;
		 ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
	     ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
	     outputStream.writeObject(commentList);
	     outputStream.flush();
	     serializedObject = byteStream.toString("ISO-8859-1");
	   

	     
	     return serializedObject;
	}

	private static List<Pair<String, String>> deserializeList(String serialized) throws Exception {
		  byte b[] = serialized.getBytes("ISO-8859-1");
		  ByteArrayInputStream byteStream = new ByteArrayInputStream(b);
		  ObjectInputStream inputStream = new ObjectInputStream(byteStream);
		  List<Pair<String, String>> deserialized = (List<Pair<String, String>>) inputStream.readObject();

		for (Pair<String, String> pair : deserialized) {
			System.out.println("name: " + pair.getKey() + ", " + "comment: " + pair.getValue());
		}
		return deserialized;

	}

	public static void main(String[] args) throws Exception {
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		list.add(pair);

		
		deserializeList(serializeList(list));

	}
}
