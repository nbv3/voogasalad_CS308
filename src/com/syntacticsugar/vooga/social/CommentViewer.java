package com.syntacticsugar.vooga.social;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class CommentViewer extends ListViewer {

	private List<Pair<String, String>> myCommentList;
	private String myGameName;
	private IComments myCommentInterface;

	public CommentViewer(String gameName, IComments commentInterface) {
		myGameName = gameName;
		myCommentList = new ArrayList<Pair<String, String>>();
		myCommentInterface = commentInterface;

	}

	private String getCurrentGameComments() {
		String serializedComments = myCommentInterface.getSerializedComments(myGameName);
		return serializedComments;
	}

	private String serializeList(List<Pair<String, String>> commentList) throws Exception {
		String serializedObject;
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream outputStream = new ObjectOutputStream(byteStream);
		outputStream.writeObject(commentList);
		outputStream.flush();
		serializedObject = byteStream.toString("ISO-8859-1");

		return serializedObject;
	}

	private List<Pair<String, String>> deserializeString(String serialized) throws Exception {
		byte bytes[] = serialized.getBytes("ISO-8859-1");
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		ObjectInputStream inputStream = new ObjectInputStream(byteStream);
		List<Pair<String, String>> deserialized = (List<Pair<String, String>>) inputStream.readObject();
		return deserialized;

	}
	
	private void postComment(String author, String content) throws Exception{
		String oldComments = getCurrentGameComments();
		List<Pair<String, String>> commentList = deserializeString(oldComments);
		commentList.add(new Pair<String,String>(author, content));
		myCommentInterface.postComment(author, serializeList(commentList));
	}

	public static void main(String[] args) throws Exception {
		List<Pair<String, String>> list = new ArrayList<Pair<String, String>>();
		Pair<String, String> pair = new Pair<String, String>("michael", "hello");
		list.add(pair);
		
		//deserializeString(serializeList(list));

	}
}
