// This entire file is part of my masterpiece.
// Jiawei Zhang

package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Concrete implementation of random pathfinding which find an adjacent point at random
 * @author jiawei
 *
 */
public class RepeatingRandomPathFinder extends AbstractRandomPathFinder {

	public RepeatingRandomPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
	}

	@Override
	public Point getNext() {
		List<Point> validPoints = getValidPoints(getStart());
		Collections.shuffle(validPoints, getSeed());
		return validPoints.get(0);
	}

	@Override
	public List<Point> getPath() {
		Point nextPoint = getNext();
		List<Point> secondPath = getValidPoints(nextPoint);
		List<Point> path = new ArrayList<Point>();
		path.add(nextPoint);
		path.add(secondPath.get(0));
		return path;
	}

}
