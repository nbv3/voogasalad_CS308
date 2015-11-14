package engine;

import environment.IEnvironment;
import javafx.scene.input.KeyEvent;

public interface IGameEngine {
	
	public IEnvironment getEnvironment();
	
	public void update();
	
	public void handleKeyPressed(KeyEvent e);
	
	public void handleKeyReleased(KeyEvent e);
	
	public void handleMouseInput(double x, double y);

}
