package com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations;

import java.awt.Point;

import javafx.geometry.Point2D;

public class SceneryTile extends AbstractTile {

	public SceneryTile(Point point) {
		super(point);
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

	@Override
	public boolean isPlaceable() {
		return true;
	}

}
