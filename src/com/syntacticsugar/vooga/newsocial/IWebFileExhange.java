// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;

public interface IWebFileExhange {

	/**
	 * 
	 * @param selectedItemID the ID of the item that is selected in
	 * the XML list viewer.
	 */
	public void downloadItem(int selectedItemID);
	
	/**
	 * Method used to call a file selector dialog box.
	 */
	public void uploadItem();
	
}
