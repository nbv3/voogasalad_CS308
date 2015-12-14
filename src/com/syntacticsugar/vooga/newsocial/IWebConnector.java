// This entire file is part of my masterpiece.
// MICHAEL DAOU

package com.syntacticsugar.vooga.newsocial;

public interface IWebConnector {

	/**
	 * Method used to pull game data from the server,
	 * but not the actual game itself.
	 * @param id the ID of the game data being pulled.
	 */
	public void getXMLData(int id);
	
}
