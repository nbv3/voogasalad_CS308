package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.List;

public abstract class AbstractRandomPathFinder extends AbstractPathFinder implements IRandomPathFinder {

	public AbstractRandomPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
		// TODO Auto-generated constructor stub
	}

}
