// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;

public interface IUploader {

	/**
	 * Method used to post an XML to the server after it has been
	 * selected in the file chooser.
	 * @param author the author of the game being posted.
	 * @param gameName the name of the game being posted.
	 * @param description a string for the description of the game.
	 */
	
	public void postXML(String author, String gameName, String description);
	
}
