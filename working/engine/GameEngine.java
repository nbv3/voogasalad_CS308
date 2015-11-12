package engine;

import environment.GameEnvironment;
import objects.AbstractGameObject;

public class GameEngine implements IGameEngine{
	
	private GameEnvironment myGameEnvironment;
	
	public GameEngine(GameEnvironment g){
		myGameEnvironment = g;
	}

	@Override
	public void checkForCollisions() {
		for (AbstractGameObject obj : myGameEnvironment.getEnvironmentObjects()){
			
		}
		
	}
	
	

}
