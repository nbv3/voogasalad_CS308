package simple.universe;

import java.util.Collection;
import java.util.Collections;

import simple.obj.ISimpleObject;
import simple.universe.map.ISimpleGameMap;

public class SimpleUniverse implements ISimpleUniverse {

	private Collection<ISimpleObject> myGameObjects;
	private ISimpleGameMap myGameMap;

	
	@Override
	public Collection<ISimpleObject> getGameObjects() {
		return Collections.unmodifiableCollection(myGameObjects);
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
	public boolean[][] retrievePath() {
		return myGameMap.retrievePath();
	}

}
