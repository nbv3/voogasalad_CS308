package com.syntacticsugar.vooga.gameplayer.universe.map.tiles;

import javafx.geometry.Point2D;

import com.syntacticsugar.vooga.gameplayer.objects.AbstractViewableObject;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.AbstractTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.PathTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.implementations.SceneryTile;

import authoring.data.TileData;
import authoring.data.TileImplementation;

public class DecoratorTile extends AbstractViewableObject implements IGameTile {

	private AbstractTile myImplementation;
	public boolean myDestination;
	
	public boolean placeable;
	
	public DecoratorTile(TileData tileData, Point2D point, double width, double height) {
		super(point, width, height, tileData.getImagePath());
		this.myImplementation = tileData.getImplementation().equals(TileImplementation.Path) ? 
				new PathTile(point) : new SceneryTile(point);
		this.myDestination = tileData.isDestination();
		this.placeable = true;
	}
	
	public DecoratorTile(Point2D point, TileImplementation type, double width, double height, String path) {
		super(point, width, height, path);
		this.myImplementation = type.equals(TileImplementation.Path) ? 
				new PathTile(point) : new SceneryTile(point);
		this.myDestination = false;
	}
	
	public AbstractTile getImplementation() {
		return myImplementation;
	}
	
	public void setImplementation(AbstractTile implementation) {
		this.myImplementation = implementation;
	}
	
	public void setDestination(boolean isDestination) {
		this.myDestination = isDestination;
	}
	
	@Override
	public boolean isWalkable() {
		return this.myImplementation.isWalkable();
	}

	@Override
	public boolean isPlaceable() {
		return this.myImplementation.isPlaceable() && placeable;
	}

	@Override
	public Point2D getPoint() {
		return this.getBoundingBox().getPoint();
	}

	@Override
	public boolean isDestination() {
		return this.isWalkable() && this.myDestination;
	}
	
	@Override
	public void setIsPlaceable(boolean state) {
		placeable = state;
	}
	
}
