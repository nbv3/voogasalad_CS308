package engine;

import javafx.scene.input.KeyEvent;

public interface IGameEngine {
	
	public void checkForCollisions();
	
	public void update();
	
	public void handleKeyPressed(KeyEvent e);
	
	public void handleKeyReleased(KeyEvent e);
	
	public void handleMouseInput(double x, double y);

}
