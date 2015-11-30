package com.syntacticsugar.vooga.gameplayer.universe.map;

import javafx.geometry.Point2D;

import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public interface IGameMap {

	/**
	 * Returns a 2D boolean array representing the walkable vs. non-walkable
	 * tiles in this Universe.
	 * 
	 * @return
	 */

	public Collection<DecoratorTile> getTiles();

	public boolean[][] isWalkable();

	public boolean[][] isPlaceable();

	public IGameTile getTile(Point2D p);
	
	public Point2D getMapIndexFromCoordinate(Point2D coordinate);
}
