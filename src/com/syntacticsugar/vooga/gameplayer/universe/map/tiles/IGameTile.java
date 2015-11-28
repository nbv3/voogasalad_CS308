package com.syntacticsugar.vooga.gameplayer.universe.map.tiles;

import com.syntacticsugar.vooga.gameplayer.objects.IViewableObject;

import javafx.geometry.Point2D;

public interface IGameTile extends IViewableObject {

	public boolean isWalkable();
	
	public boolean isPlaceable();
	
	public Point2D getPoint();
	
}
