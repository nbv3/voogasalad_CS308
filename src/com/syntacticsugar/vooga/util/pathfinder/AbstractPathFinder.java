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

	protected List<Point> getValidPoints(Point p) {
		List<Point> validPoints = new ArrayList<Point>();
		int x = p.x;
		int y = p.y;
		if (x - 1 >= 0) {
			if (map[x][y]) {
				validPoints.add(new Point(x - 1, y));
			}
		}
		if (x + 1 < map.length) {
			if (map[x][y]) {
				validPoints.add(new Point(x + 1, y));
			}
		}

		if (y - 1 >= 0) {
			if (map[x][y]) {
				validPoints.add(new Point(x, y - 1));
			}

		}
		if (y + 1 < map[0].length) {
			if (map[x][y]) {
				validPoints.add(new Point(x, y + 1));
			}
		}
		return validPoints;
	}

	protected List<Point> getDestinations() {
		return destinationPoints;
	}

	protected Point getStart() {
		return startPoint;
	}
}
