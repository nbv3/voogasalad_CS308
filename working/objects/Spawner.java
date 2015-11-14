package objects;

import environment.GameEnvironment;
import javafx.geometry.Point2D;
import view.ObjectView;

public class Spawner extends AbstractGameObject {

	private IGameObject myObjectToSpawn;

	public Spawner(Point2D p, double w, double h, GameEnvironment g, IGameObject o) {
		super(p, w, h, g);
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
	public void setID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void registerObserver(ObjectView o) {
		// TODO Auto-generated method stub
		
	}

}
