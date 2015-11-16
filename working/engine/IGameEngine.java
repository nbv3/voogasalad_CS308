package engine;

import environment.IEnvironment;
import javafx.scene.input.KeyEvent;
import objects.GameEventListener;
import view.ViewController;

public interface IGameEngine extends EventPoster{
	
	/**
	 * Returns the environment specific to the game engine
	 * @return
	 */
	
	public IEnvironment getEnvironment();
	
	public ViewController getViewController();
	
	/**
	 * Updates the objects in the game environment
	 */
	
	public void update();
	
	public void addListener(GameEventListener obj);
	
	public void removeListener(GameEventListener obj);
	
	/**
	 * Handles a KeyEvent when it is pressed
	 * @param e
	 */
	
	public void handleKeyPressed(KeyEvent e);
	
	public void handleKeyReleased(KeyEvent e);
	
	public void handleMouseInput(double x, double y);

}
