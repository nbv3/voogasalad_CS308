package simple.universe;

import simple.obj.ISimpleObject;

public interface ISimpleSpawner {
	
	public void addToSpawnYard(ISimpleObject toAdd);
	
	public void clearSpawnYard();

}
