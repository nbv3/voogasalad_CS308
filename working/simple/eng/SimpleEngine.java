package simple.eng;

import simple.eng.collisions.ISimpleCollisionManager;
import simple.eng.collisions.SimpleCollisionManager;
import simple.obj.ISimpleObject;
import simple.universe.ISimpleUniverse;

public class SimpleEngine implements ISimpleEngine {

	private ISimpleUniverse myUniverse;
	private ISimpleCollisionManager myCollisionManager;
	
	public SimpleEngine() {
		this(null);
	}
	
	public SimpleEngine(ISimpleUniverse universe) {
		this.myUniverse = universe;
		myCollisionManager = new SimpleCollisionManager();
	}
	
	@Override
	public void frameUpdate() {
		for (ISimpleObject object : myUniverse.getGameObjects()) {
			object.updateSelf(myUniverse);
		}
		myCollisionManager.checkCollisions(myUniverse.getGameObjects());
	}

	@Override
	public void setUniverse(ISimpleUniverse universe) {
		this.myUniverse = universe;
	}

}
