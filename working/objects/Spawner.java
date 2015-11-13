package objects;

import java.awt.Point;

import environment.GameEnvironment;

public class Spawner extends AbstractGameObject {

	private IGameObject myObjectToSpawn;

	public Spawner(Point p, GameEnvironment g, IGameObject o) {
		super(p, g);
		myObjectToSpawn = o;

	}

	public void spawn() {
	//	myGameEnvironment.addToEnvironment(myObjectToSpawn);
	}

	@Override
	public void update() {

		// If time to spawn, spawn etc.

	}

	@Override
	public Point getLocation() {
		return myLocation;
	}

}
