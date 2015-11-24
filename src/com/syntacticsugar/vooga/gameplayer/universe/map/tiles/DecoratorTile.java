package com.syntacticsugar.vooga.gameplayer.universe.map.tiles;

import javafx.geometry.Point2D;

import com.syntacticsugar.vooga.gameplayer.objects.AbstractViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.PathTile;

public class DecoratorTile extends AbstractViewableObject implements IGameTile {

	private IGameTile myImplementation;
	
	public DecoratorTile(Point2D point, double width, double height, String path) {
		super(point, width, height, path);
		this.myImplementation = new PathTile(point);
	}
	
	public IGameTile getImplementation() {
		return myImplementation;
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
