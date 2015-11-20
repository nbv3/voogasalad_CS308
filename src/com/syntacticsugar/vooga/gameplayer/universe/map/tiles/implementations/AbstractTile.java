package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

import javafx.geometry.Point2D;

public abstract class AbstractTile implements IGameTile {

	private Point2D myPoint;
	
	public AbstractTile(Point2D point) {
		this.myPoint = point;
	}
	
	@Override
	public abstract boolean isWalkable();

	@Override
	public abstract boolean isPlaceable();

	@Override
	public Point2D getPoint() {
		return this.myPoint;
	}

}
