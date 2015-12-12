package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomDestinationPathFinder extends AbstractDestinationPathFinder {

	public RandomDestinationPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
	}

	public Point getNext() {
		List<Point> shortestPath = shortestPath();
		if (shortestPath.size() <= 1) {
			return getStart();
		}
		return shortestPath.get(1);
	}

	public List<Point> getPath() {
		return shortestPath();
	}

	private List<Point> shortestPath() {
		List<List<Point>> tempPaths = getPaths();
		Collections.shuffle(tempPaths, new Random());
		return tempPaths.get(0);
	}
}
