package com.syntacticsugar.vooga.gameplayer.universe.map;

import javafx.geometry.Point2D;

import java.awt.Point;
import java.util.Collection;
import java.util.List;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public interface IGameMap extends PathFindingMap{

	/**
	 * Returns a 2D boolean array representing the walkable vs. non-walkable
	 * tiles in this Universe.
	 * 
	 * @return
	 */

	public Collection<IGameTile> getTiles();

	public boolean[][] isWalkable();

	public boolean[][] isPlaceable();

	public IGameTile getTile(int i, int j);
	
	public Point getMapIndexFromCoordinate(Point2D coordinate) throws Exception;
	
	public Point2D getCoordinateFromMapIndex(Point index);
	
	/**
	 * Returns the size of the array (number of columns = number of rows)
	 * 
	 * @return size
	 */
	public int getSize();
	
	/**
	 * Returns the width/height of any given tile
	 * 
	 * @return size
	 */
	public double getTileSize();
	
	/**
	 * Returns a list of points that are destinations
	 * 
	 * @return destinations
	 */
	public List<Point> getDestinationPoints();
}
