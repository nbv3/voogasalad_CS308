package com.syntacticsugar.vooga.authoring.objectediting;

import javafx.scene.Node;

/**
 * Simple interface that guarantees a JavaFX-compatible view 
 * component.
 * 
 * @author Brody Kellish
 *
 */
public interface IVisualElement {

	/**
	 * Return the JavaFX Node used to display this UI element.
	 * 
	 * @return Node : The JavaFX node containing this UI element.
	 */
	public Node getView();
	
}
