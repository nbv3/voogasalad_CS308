package simple.universe;

import simple.universe.map.ISimpleGameMap;

public interface ISimpleUniverse extends ISimpleObjectContainer, ISimpleGameMap {

	/**
	 * A SimpleUniverse (anything that implements this interface) must contain a 
	 * Collection of GameObjects, add/remove methods, and contain a GameMap.
	 */

}
