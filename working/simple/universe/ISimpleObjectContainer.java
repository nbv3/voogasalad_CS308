package simple.universe;

import java.util.Collection;

import simple.obj.ISimpleObject;

public interface ISimpleObjectContainer extends ISimpleObjectAdder, ISimpleObjectRemover {

	/**
	 * Returns all game objects within this container.
	 * @return
	 */
	public Collection<ISimpleObject> getGameObjects();
		
}