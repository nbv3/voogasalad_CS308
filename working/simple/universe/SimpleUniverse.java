package simple.universe;

import java.util.Collection;

import simple.obj.ISimpleObject;
import simple.universe.map.ISimpleGameMap;

public class SimpleUniverse implements ISimpleUniverse, ISimpleGameMap {

	private Collection<ISimpleObject> myGameObjects;
	private ISimpleGameMap myGameMap;
	
	@Override
	public Collection<ISimpleObject> getGameObjects() {
		return myGameObjects;
	}

	@Override
	public void addGameObject(ISimpleObject toAdd) {
		myGameObjects.add(toAdd);
	}

	@Override
	public void removeGameObject(ISimpleObject toRemove) {
		myGameObjects.remove(toRemove);
	}

	@Override
	public void updateUniverse(ISimpleUniverse universe) {
		for (ISimpleObject toUpdate : myGameObjects) {
			toUpdate.updateSelf(this);
		}
	}

	@Override
	public boolean[][] retrievePath() {
		return myGameMap.retrievePath();
	}

}
