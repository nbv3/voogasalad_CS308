package engine;

import environment.GameEnvironment;
import environment.IEnvironment;
import javafx.scene.input.KeyEvent;
import objects.IGameObject;

public class GameEngine implements IGameEngine{
	
	private IEnvironment myGameEnvironment;
	
	private ICollisionManager myCollisionManager;
	
	public GameEngine(int numCellsWide, int numCellsHigh, double size){
		myGameEnvironment = new GameEnvironment(numCellsWide, numCellsHigh, size);
		myCollisionManager = new CollisionManager(this);
	}
	
	public void update() {
		myGameEnvironment.updateObjects();
		myCollisionManager.update();
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

	@Override
	public IEnvironment getEnvironment() {
		return myGameEnvironment;
	}

}
