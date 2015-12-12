package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestDestinationPathFinder extends AbstractDestinationPathFinder {

	public ShortestDestinationPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
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
