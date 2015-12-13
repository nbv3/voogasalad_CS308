// This entire file is part of my masterpiece.
// Jiawei Zhang

package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Abstract class which all concrete pathfinders have to extend
 * 
 * @author jiawei
 *
 */
public abstract class AbstractPathFinder implements IPathFinder {
	private boolean[][] map;

	private Point startPoint;
	private List<Point> destinationPoints;

	/**
	 * All pathfinders take a map, startPoint, and destinationPoints to
	 * instantiate them
	 * 
	 * @param map
	 * @param startPoint
	 * @param destinationPoints
	 */
	public AbstractPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		this.map = map;
		this.startPoint = startPoint;
		this.destinationPoints = destinationPoints;
	}

	/**
	 * Alternate constructor that allows the use of a single destination point instead of a list of destination points
	 * Use java streams to collect point into list
	 * @param map
	 * @param startPoint
	 * @param destinationPoint
	 */
	public AbstractPathFinder(boolean[][] map, Point startPoint, Point destinationPoint) {
		this(map, startPoint, Stream.of(destinationPoint).collect(Collectors.toList()));
	}

	/**
	 * Abstract method which all pathfinders need to implement
	 */
	public abstract Point getNext();

	/**
	 * Abstract method which all pathfinders need to implement
	 */
	public abstract List<Point> getPath();

	/**
	 * Method which allows all pathfinders to find a list of valid surrounding
	 * points given the current location
	 * 
	 * @param p:
	 *            current point
	 * 
	 * @return the list of valid points surrounding the current point
	 */
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

	/**
	 * protected getter used to retrieve the destination points
	 * 
	 * @return destination points in a list
	 */
	protected List<Point> getDestinations() {
		return destinationPoints;
	}

	/**
	 * protected getter used to retrieve the start point
	 * 
	 * @return start point
	 */
	protected Point getStart() {
		return startPoint;
	}
}
