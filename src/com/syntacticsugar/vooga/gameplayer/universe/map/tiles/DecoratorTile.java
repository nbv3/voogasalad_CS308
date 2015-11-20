package com.syntacticsugar.vooga.gameplayer.universe.map.tiles;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.PathTile;

import javafx.geometry.Point2D;

public class DecoratorTile implements IGameTile {

	private IGameTile myImplementation;
	
	public DecoratorTile(Point2D point, double width, double height) {
		this.myImplementation = new PathTile(point);
	}
	
	public void setImplementation(IGameTile implementation) {
		this.myImplementation = implementation;
	}
	
	@Override
	public boolean isWalkable() {
		return this.myImplementation.isWalkable();
	}

	@Override
	public boolean isPlaceable() {
		return this.myImplementation.isPlaceable();
	}

	@Override
	public Point2D getPoint() {
		return this.myImplementation.getPoint();
	}

}