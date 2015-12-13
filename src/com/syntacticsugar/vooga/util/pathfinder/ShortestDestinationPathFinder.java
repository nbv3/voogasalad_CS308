// This entire file is part of my masterpiece.
// Jiawei Zhang

package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Finds the shortest path to any destination
 * @author jiawei
 *
 */
public class ShortestDestinationPathFinder extends AbstractDestinationPathFinder {

	public ShortestDestinationPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
	}

	/**
	 * Concrete implementation getting the next point
	 */
	public Point getNext() {
		List<Point> shortestPath = shortestPath();
		if (shortestPath.size() <= 1) {
			return getStart();
		}
		return shortestPath.get(1);
	}

	/**
	 * Concrete implementation getting the full path
	 */
	public List<Point> getPath() {
		return shortestPath();
	}

	/**
	 * O(n) algorithm for finding the shortest path out of all paths to the destinations
	 * @return the shortest path to any destination
	 */
	private List<Point> shortestPath() {
		List<Point> shortest = new ArrayList<Point>();
		List<List<Point>> tempPaths = getPaths();
		Collections.shuffle(tempPaths);
		int shortSize = Integer.MAX_VALUE;
		for (int i = 0; i < tempPaths.size(); i++) {
			if (tempPaths.get(i).size() < shortSize) {
				shortest = tempPaths.get(i);
				shortSize = tempPaths.get(i).size();
			}
		}
		return shortest;
	}
}
