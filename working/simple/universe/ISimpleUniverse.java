package simple.universe;

public interface ISimpleUniverse extends ISimpleObjectContainer {

	/**
	 * Update all of the game objects contained within this Universe.
	 * @param universe
	 */
	public void updateUniverse(ISimpleUniverse universe);

}
