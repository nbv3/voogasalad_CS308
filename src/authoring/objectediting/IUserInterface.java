package authoring.objectediting;

import javafx.scene.Node;

public interface IUserInterface {

	/**
	 * Return the JavaFX Node that stores this UI element.
	 * @return
	 */
	public Node getView();
	
}
