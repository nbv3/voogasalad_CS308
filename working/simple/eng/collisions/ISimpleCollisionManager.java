package simple.eng.collisions;

import java.util.Collection;

import simple.obj.ISimpleObject;

public interface ISimpleCollisionManager {

	/**
	 * Performs n^2 intersection comparison on all the objects in the game.
	 * TODO: Optimize for near-ishs neighbor calculations using Game Map
	 * @param objectsToCheck
	 */
	public void checkCollisions(Collection<ISimpleObject> objectsToCheck);
	
}
