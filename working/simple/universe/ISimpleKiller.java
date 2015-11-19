package simple.universe;

import simple.obj.ISimpleObject;

public interface ISimpleKiller {

	public void addToGraveYard(ISimpleObject toRemove);
	
	public void clearGraveYard();

}
