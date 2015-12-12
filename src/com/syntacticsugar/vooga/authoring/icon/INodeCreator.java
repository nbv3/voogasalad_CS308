package com.syntacticsugar.vooga.authoring.icon;

import javafx.scene.Node;

/**
 * Interface used to build custom JavaFX display Nodes
 * from arbitrary data types.
 * 
 * @author Brody Kellish
 *
 * @param <T> : The type of data used to generate a JavaFX Node
 */

@FunctionalInterface
public interface INodeCreator<T> {

	/**
	 * Method used to convert arbitrary data objects into visual JavaFX Nodes.
	 * 
	 * @param dataToDisplay : The data to represent visually
	 * @return node : The visual representation of the specified data
	 */
	public Node createNode(T dataToDisplay);
	
}
