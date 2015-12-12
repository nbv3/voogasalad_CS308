package com.syntacticsugar.vooga.authoring.icon;

import java.util.Collection;

/**
 * Interface that provides several utility methods for
 * choosing between individual data elements in a larger
 * data collection. Allows the user to add new data, remove 
 * the currently selected data, or get/clear the entire 
 * backing data Collection.
 * 
 * @author Brody Kellish
 *
 * @param <T> : The type of data being stored/selected.
 */
public interface IDataSelector<T> {

	/**
	 * Return a Collection containing all current data.
	 * 
	 * @return dataset : The Collection of data currently backing this DataSelector
	 */
	public Collection<T> getAllData();
	
	/**
	 * Returns the currently selected data.
	 * 
	 * @return data : The currently selected data
	 */
	public T getSelectedData();
	
	/**
	 * Remove the currently selected data.
	 */
	public void removeSelectedData();
	
	/**
	 * Add a new data element.
	 * 
	 * @param toAdd : The single data element to add to this DataSelector.
	 */
	public void addData(T toAdd);
	
	/**
	 * Clear all existing data.
	 */
	public void clearData();
	
	
}
