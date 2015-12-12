package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
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
		
	public List<Point> getValidPoints(Point p) {
		List<Point> validPoints = new ArrayList<Point>();
		int x = p.x;
		int y = p.y;
		if (x - 1 >= 0) {
			Point n = new Point(x - 1, y);
			if (map[x][y]) {
				validPoints.add(n);
			}
		}
		if (x + 1 < map.length) {
			Point n = new Point(x + 1, y);
			if (map[x][y]) {
				validPoints.add(n);
			}
		}

		if (y - 1 >= 0) {
			Point n = new Point(x, y - 1);
			if (map[x][y]) {
				validPoints.add(n);
			}

		}
		if (y + 1 < map[0].length) {
			Point n = new Point(x, y + 1);
			if (map[x][y]) {
				validPoints.add(n);
			}
		}
		return validPoints;
	}
		
	public List<Point> getDestinations() {
		return destinationPoints;
	}
	
	public Point getStart() {
		return startPoint;
	}
}
