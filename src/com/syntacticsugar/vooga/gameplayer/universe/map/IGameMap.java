package com.syntacticsugar.vooga.gameplayer.universe.map;

public interface IGameMap {

	
	/**
	 * Returns a 2D boolean array representing the walkable vs. non-walkable
	 * tiles in this Universe.
	 * @return
	 */
	public boolean[][] retrievePath();
	
}
