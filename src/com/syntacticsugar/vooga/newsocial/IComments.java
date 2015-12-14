// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;

public interface IComments {
	
	/**
	 * 
	 * @param author the author of the comment.
	 * @param comment the content of the comment.
	 * @param id the ID of the game to which this comment corresponds.
	 */
	public void postComment(String author, String comment, int id);
	
}
