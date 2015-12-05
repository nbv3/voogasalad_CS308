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
		
			FileOutputStream fileOut = new FileOutputStream("/tmp/comments.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(commentList);
			String string = new String();
			
			System.out.println(out.toString());
			fileOut.close();
			return string;
			
	}

	private static List<Pair<String, String>> deserializeList() throws Exception {

		InputStream file = new FileInputStream("/tmp/comments.ser");
		InputStream buffer = new BufferedInputStream(file);
		ObjectInput input = new ObjectInputStream(buffer);

		List<Pair<String, String>> deserialized = (List<Pair<String, String>>) input.readObject();
		for (Pair<String, String> pair : deserialized) {
			System.out.println("name: " + pair.getKey() + ", " + "comment: " + pair.getValue());
		}
		return deserialized;

	}

	public static void main(String[] args) throws Exception {
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		list.add(pair);

		serializeList(list);
		deserializeList();

	}
}
