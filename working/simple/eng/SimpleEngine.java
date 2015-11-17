package simple.eng;

import simple.eng.collisions.SimpleCollisionManager;
import simple.universe.ISimpleUniverse;

public class SimpleEngine {
	
	public static void frameUpdate(ISimpleUniverse universe) {
		SimpleStateManager.updateState(universe);
		SimpleCollisionManager.checkCollisions(universe.getGameObjects());
	}


}
