package simple.universe.fxns;

import simple.obj.ISimpleObject;
import simple.universe.ISimpleObjectAdder;

public class SimpleObjectAdder {

	private ISimpleObjectAdder myAdder;
	
	public SimpleObjectAdder(ISimpleObjectAdder adder) {
		myAdder = adder;
	}
	
	public void addToEnvironment(ISimpleObject toAdd) {
		myAdder.addGameObject(toAdd);
	}
	
}
