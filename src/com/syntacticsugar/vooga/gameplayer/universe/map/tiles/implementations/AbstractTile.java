package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations;

import javafx.geometry.Point2D;

public abstract class AbstractTile{

	@SuppressWarnings("unused")
	private Point2D myPoint;
	
	public AbstractTile(Point2D point) {
		this.myPoint = point;
	}
	
	public abstract boolean isWalkable();

	public abstract boolean isPlaceable();

}
