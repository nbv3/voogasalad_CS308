// This entire file is part of my masterpiece.
// Jiawei Zhang

package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Abstract class that is the parent to all pathfinders that are looking for a destination
 * @author jiawei
 *
 */
public abstract class AbstractDestinationPathFinder extends AbstractPathFinder {
	private Map<Point, List<Point>> memo;
	private Map<Point, Integer> distanceMap;
	private Queue<Point> distanceQueue;

	private List<List<Point>> paths;

	public AbstractDestinationPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
		memo = new HashMap<Point, List<Point>>();

		distanceMap = new HashMap<Point, Integer>();
		distanceQueue = new LinkedList<Point>();

		paths = new ArrayList<List<Point>>();
		findDestinationPaths();
	}

	/**
	 * O(n) fill to find minimum distance to any point on a map from the start point
	 */
	private void fillDistances() {
		distanceMap.put(getStart(), 0);
		distanceQueue.addAll(getNeighbors(getStart()));
		while (distanceQueue.size() > 0) {
			Point front = distanceQueue.poll();
			List<Point> frontNeighbors = getNeighbors(front);
			// find the smallest distance of its neighbors and add one,
			int minDistance = Integer.MAX_VALUE - 1;
			for (Point nPoint : frontNeighbors) {
				if (distanceMap.containsKey(nPoint)) {
					if (distanceMap.get(nPoint) < minDistance) {
						minDistance = distanceMap.get(nPoint);
					}
				} else {
					if (!distanceQueue.contains(nPoint)) {
						distanceQueue.add(nPoint);
					}
				}
			}
			distanceMap.put(front, minDistance + 1);
		}
	}
	
	/**
	 * Iterates through all destinations and finds all the shortest paths that can navigate to the destination
	 */
	private void generateDestinationPaths() {
		for (Point endPoint : getDestinations()) {
			if (distanceMap.keySet().contains(endPoint)) {
				List<Point> sta = new ArrayList<Point>();
				Point currentPoint = new Point(endPoint);
				sta.add(new Point(currentPoint));
				int distance = distanceMap.get(currentPoint);
				while (distance > 0) {
					List<Point> neighbors = getNeighbors(currentPoint);
					for (Point n : neighbors) {
						if (distanceMap.containsKey(n)) {
							if (distanceMap.get(n) == distance - 1) {
								distance = distance - 1;
								currentPoint = n;
								sta.add(new Point(currentPoint));
								break;
							}
						}
					}
				}
				Collections.reverse(sta);
				paths.add(sta);
			}
		}
	}

	protected void findDestinationPaths() {
		fillDistances();
		generateDestinationPaths();
	}

	/**
	 * Getting neighbors using validPoints by memoizing for efficiency
	 * @param p
	 * @return valid neighboring points
	 */
	protected List<Point> getNeighbors(Point p) {
		if (memo.containsKey(p)) {
			List<Point> ret = memo.get(p);
			Collections.shuffle(ret);
			return ret;
		}
		List<Point> validPoints = getValidPoints(p);
		memo.put(p, validPoints);
		Collections.shuffle(validPoints);
		return validPoints;
	}

	/**
	 * Protected method that gets all the generated paths
	 * @return list of shortest paths
	 */
	protected List<List<Point>> getPaths() {
		return paths;
	}

}
