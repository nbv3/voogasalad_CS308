package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations;

import java.awt.Point;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

import javafx.geometry.Point2D;

public abstract class AbstractTile implements IGameTile {

	private Point myPoint;
	
	public AbstractTile(Point point) {
		this.myPoint = point;
	}
	
	@Override
	public abstract boolean isWalkable();

	@Override
	public abstract boolean isPlaceable();

	@Override
	public Point getPoint() {
		return this.myPoint;
	}

}
