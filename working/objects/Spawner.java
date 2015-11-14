package objects;

import environment.GameEnvironment;
import javafx.geometry.Point2D;

public class Spawner extends AbstractGameObject {

	private IGameObject myObjectToSpawn;

	public Spawner(Point2D p, GameEnvironment g, IGameObject o) {
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
	public Point2D getLocation() {
		return myLocation;
	}

}
