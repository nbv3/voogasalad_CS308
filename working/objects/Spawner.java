package objects;

import engine.EventPoster;
import engine.environment.GameEnvironment;
import javafx.geometry.Point2D;
import view.ObjectView;

public class Spawner extends AbstractGameObject {

	private IGameObject myObjectToSpawn;

	public Spawner(Point2D p, double w, double h, EventPoster poster, IGameObject o) {
		super(p, w, h, poster);
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
	public void registerObserver(ObjectView o) {
		// TODO Auto-generated method stub
		
	}

}
