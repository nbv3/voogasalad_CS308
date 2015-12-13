package com.syntacticsugar.vooga.newsocial;

public interface IWebConnector {

	public void downloadSelectedItem(int selectedItemID);
	
	public void uploadItem();
	
	public void postComment(String author, String comment, int id);
	
	public void refreshXMLList();
	
	
	
}
