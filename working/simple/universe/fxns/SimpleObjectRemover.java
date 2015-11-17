package simple.universe.fxns;

import simple.obj.ISimpleObject;
import simple.universe.ISimpleObjectRemover;

public class SimpleObjectRemover {

	private ISimpleObjectRemover myRemover;
	
	public SimpleObjectRemover(ISimpleObjectRemover remover) {
		myRemover = remover;
	}
	
	public void removeFromEnvironment(ISimpleObject toRemove) {
		myRemover.removeGameObject(toRemove);
	}
	
}
