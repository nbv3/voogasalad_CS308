package com.syntacticsugar.vooga.gameplayer.universe.map;

import java.awt.Point;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public interface IGameMap {

	/**
	 * Returns a 2D boolean array representing the walkable vs. non-walkable
	 * tiles in this Universe.
	 * 
	 * @return
	 */

	public IGameTile[][] getTiles();

	public boolean[][] isWalkable();

	public boolean[][] isPlaceable();

	public IGameTile getTile(Point p);
}
