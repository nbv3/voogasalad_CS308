package com.syntacticsugar.vooga.gameplayer.universe.map.tiles;

import java.awt.Point;

import javafx.geometry.Point2D;

public interface IGameTile {

	public boolean isWalkable();
	
	public boolean isPlaceable();
	
	public Point getPoint();
	
}
