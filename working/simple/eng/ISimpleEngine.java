package simple.eng;

import simple.universe.ISimpleUniverse;

public interface ISimpleEngine {

	/**
	 * Method that updates the internal state of the game in each frame.
	 */
	public void frameUpdate(ISimpleUniverse universe);

	
}
