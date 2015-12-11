package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.List;

public abstract class AbstractPathFinder implements IPathFinder {
	private boolean[][] map;
	
	private Point startPoint;
	private List<Point> destinationPoints;
	
	public AbstractPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		this.map = map;
		this.startPoint = startPoint;
		this.destinationPoints = destinationPoints;
	}

	public abstract Point getNext();

	public abstract List<Point> getPath();
	
	public List<Point> getDestinations() {
		return destinationPoints;
	}
	
	public Point getStart() {
		return startPoint;
	}
	
	public boolean[][] getMap() {
		return map;
	}
}
