package com.syntacticsugar.vooga.authoring.objectediting;

import javafx.scene.Node;

public interface IVisualElement {

	/**
	 * Return the JavaFX Node that stores this UI element.
	 * @return
	 */
	public Node getView();
	
}
