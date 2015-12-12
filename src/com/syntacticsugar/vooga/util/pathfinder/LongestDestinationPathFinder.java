package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestDestinationPathFinder extends AbstractDestinationPathFinder {

	public LongestDestinationPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
	}

	public Point getNext() {
		List<Point> longestPath = longestPath();
		if (longestPath.size() <= 1) {
			return getStart();
		}
		return longestPath.get(1);
	}

	public List<Point> getPath() {
		return longestPath();
	}

	private List<Point> longestPath() {
		List<Point> longest = new ArrayList<Point>();
		List<List<Point>> tempPaths = getPaths();
		Collections.shuffle(tempPaths);
		int longestSize = Integer.MIN_VALUE;
		for (int i = 0; i < tempPaths.size(); i++) {
			if (tempPaths.get(i).size() > longestSize) {
				longest = tempPaths.get(i);
				longestSize = tempPaths.get(i).size();
			}
		}
		return longest;
	}
}
