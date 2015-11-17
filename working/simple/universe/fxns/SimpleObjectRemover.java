package simple.universe.fxns;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;
import simple.universe.ISimpleObjectRemover;

public class SimpleObjectRemover {

	private ISimpleObjectRemover myRemover;
	
	public SimpleObjectRemover(ISimpleObjectRemover remover) {
		myRemover = remover;
	}
	
	public void removeFromEnvironment(ISimpleObject toRemove) {
		myRemover.removeGameObject(toRemove);
		if (toRemove.getType().equals(SimpleObjectType.ENEMY)) {
			// INCREMENT ENEMY DEATH GOAL
		}
	}
	
}
