package engine;

import environment.GameEnvironment;
import objects.AbstractGameObject;
import objects.IGameObject;

public class GameEngine implements IGameEngine{
	
	private GameEnvironment myGameEnvironment;
	
	public GameEngine(GameEnvironment g){
		myGameEnvironment = g;
	}

	@Override
	public void checkForCollisions() {
		for (IGameObject obj : myGameEnvironment.getEnvironmentObjects()){
			
		}
		
	}
	
	public void step() {
		myGameEnvironment.updateObjects();
	}

}
