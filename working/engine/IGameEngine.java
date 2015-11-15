package engine;

import environment.IEnvironment;
import javafx.scene.input.KeyEvent;

public interface IGameEngine {
	
	/**
	 * Returns the environment specific to the game engine
	 * @return
	 */
	
	public IEnvironment getEnvironment();
	
	/**
	 * Updates the objects in the game environment
	 */
	
	public void update();
	
	/**
	 * Handles a KeyEvent when it is pressed
	 * @param e
	 */
	
	public void handleKeyPressed(KeyEvent e);
	
	public void handleKeyReleased(KeyEvent e);
	
	public void handleMouseInput(double x, double y);

}
