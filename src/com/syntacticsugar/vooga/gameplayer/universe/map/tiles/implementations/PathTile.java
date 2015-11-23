package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations;

import java.awt.Point;

import javafx.geometry.Point2D;

public class PathTile extends AbstractTile {

	public PathTile(Point point) {
		super(point);
	}
	
	@Override
	public boolean isWalkable() {
		return true;
	}

	@Override
	public boolean isPlaceable() {
		return false;
	}

}
