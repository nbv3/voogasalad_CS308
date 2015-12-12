package com.syntacticsugar.vooga.authoring.library;

/**
 * Interface that defines a refresh() method. Generally implemented
 * by classes that rely on XML data generated in the authoring environment. 
 * Allows data displays to stay up-to-date with any data generated during
 * the application's runtime.
 * 
 * @author Brody Kellish
 *
 */
public interface IRefresher {

	/**
	 * Method to call when something about this object needs to be updated.
	 * Usually used when data files are added or removed from the project's data folders.
	 */
	public void refresh();
	
}
