package engine;

import environment.GameEnvironment;
import environment.IEnvironment;
import javafx.scene.input.KeyEvent;
import objects.IGameObject;

public class GameEngine implements IGameEngine{
	
	private IEnvironment myGameEnvironment;
	
	public GameEngine(IEnvironment myEnvironment){
		myGameEnvironment = myEnvironment;
	}

	@Override
	public void checkForCollisions() {
		for (IGameObject obj : myGameEnvironment.getEnvironmentObjects()){
			
		}
		
	}
	
	public void update() {
		myGameEnvironment.updateObjects();
	}

	@Override
	public void handleKeyPressed(KeyEvent e) {
		myGameEnvironment.handleKeyPressed(e);
		
	}

	@Override
	public void handleKeyReleased(KeyEvent e) {
		myGameEnvironment.handleKeyReleased(e);
		
	}

	@Override
	public void handleMouseInput(double x, double y) {
		myGameEnvironment.handleMouseInput(x, y);
		
	}

}
