package com.syntacticsugar.vooga.newsocial;

public interface ICommentSender {

	public boolean sendComment(String author, String comment);
	
	public void refreshComments();
		
}
