package objects;

import environment.GameEnvironment;

public class Spawner extends AbstractGameObject {

	private AbstractGameObject myObjectToSpawn;
	private GameEnvironment myGameEnvironment;

	public Spawner(GameEnvironment g, AbstractGameObject o) {
		myObjectToSpawn = o;
		myGameEnvironment = g;

	}

	public void spawn() {
		myGameEnvironment.addToEnvironment(myObjectToSpawn);
	}

	@Override
	public void update() {
		
		// If time to spawn, spawn etc. 
		
	}

}
