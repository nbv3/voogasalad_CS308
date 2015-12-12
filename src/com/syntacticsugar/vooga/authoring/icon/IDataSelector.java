package com.syntacticsugar.vooga.authoring.icon;

import java.util.Collection;

import com.syntacticsugar.vooga.authoring.objectediting.IVisualElement;

import javafx.beans.value.ChangeListener;
import javafx.scene.Node;

/**
 * Interface that allows a user to bind arbitrary data objects to 
 * visual JavaFX Nodes. User may define the type of data used to back
 * this Display and the JavaFX Nodes used to visually display the data.
 * 
 * @author Brody Kellish
 *
 * @param <T> : The type of data being stored/selected.
 */
public interface IDataSelector<T> extends IVisualElement {

	/**
	 * Add a listener that updates whenever the current selected Node in this pane changes.
	 * Allows the programmer to bind custom events to selection changes.
	 * 
	 * @param listener : the function to call whenever a selection change occurs on this pane.
	 */
	public void addSelectionListener(ChangeListener<Node> listener);
	
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
	 * Add a new data element and corresponding JavaFX Node to visualize said data.
	 * 
	 * @param dataToAdd : The data element to add to this DataSelector.
	 * @param dataView : The Node used to visually represent the data to be added.
	 */
	public void addData(T dataToAdd, Node dataView);
	
	/**
	 * Clear all existing data.
	 */
	public void clearData();
	
	
}
