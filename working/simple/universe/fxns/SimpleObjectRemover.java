package simple.universe.fxns;

import simple.obj.ISimpleObject;
import simple.obj.SimpleObjectType;
import simple.universe.ISimpleKiller;
import simple.universe.ISimpleObjectRemover;

public class SimpleObjectRemover {

	private ISimpleKiller myRemover;
	
	public SimpleObjectRemover(ISimpleKiller remover) {
		myRemover = remover;
	}
	
	public void removeFromEnvironment(ISimpleObject toRemove) {
		myRemover.addToGraveYard(toRemove);
		if (toRemove.getType().equals(SimpleObjectType.ENEMY)) {
			// INCREMENT ENEMY DEATH GOAL
		}
	}
	
}
