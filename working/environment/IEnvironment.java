package environment;

import java.util.List;

import javafx.scene.input.KeyEvent;
import objects.IGameObject;
import objects.events.IEvent;
import view.GameView;

public interface IEnvironment {
	
	public void addToEnvironment(IGameObject g, String path);
	
	public void removeFromEnvironment(IGameObject g);	

	public void updateObjects();

	List<IGameObject> getEnvironmentObjects();

	public List<String> validate();
	
	public void handleKeyPressed(KeyEvent e);
	
	public void handleKeyReleased(KeyEvent e);
	
	public void handleMouseInput(double x, double y);

}
