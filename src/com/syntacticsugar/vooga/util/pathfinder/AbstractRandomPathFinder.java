package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Abstract class that is the parent to all pathfinders that have no destination but instead navigate randomly or pseudorandomly
 * @author jiawei
 *
 */
public abstract class AbstractRandomPathFinder extends AbstractPathFinder {
	
	public AbstractRandomPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);
	}
	
	/**
	 * Alternate constructor that allows the ommission of a list of destinationPoints because they are not required
	 * @param map
	 * @param startPoint
	 */
	public AbstractRandomPathFinder(boolean[][] map, Point startPoint) {
		this(map, startPoint, new ArrayList<Point>());
	}

	/**
	 * Seed generation in case pseudorandom points are desired
	 * @return
	 */
	protected Random getSeed() {
		return new Random();
	}

}
