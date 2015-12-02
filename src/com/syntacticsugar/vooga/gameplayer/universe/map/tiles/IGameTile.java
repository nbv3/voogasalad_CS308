package com.syntacticsugar.vooga.gameplayer.universe.map.tiles;

import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;

import javafx.geometry.Point2D;

public interface IGameTile extends IViewableObject{

	/**
	 * Returns whether or not this Tile can be walked on.
	 * @return
	 */
	public boolean isWalkable();
	
	/**
	 * Returns whether or not this Tile can have a Tower placed on it.
	 * @return
	 */
	public boolean isPlaceable();
	
	/**
	 * Returns whether or not this Tile is a global destination point on the map.
	 * @return
	 */
	public boolean isDestination();
	
	/**
	 * Returns the point corresponding to the centerpoint of this Tile.
	 * @return
	 */
	public Point2D getPoint();
	
}
