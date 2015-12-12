package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public abstract class AbstractRandomPathFinder extends AbstractPathFinder implements IRandomPathFinder {
	public AbstractRandomPathFinder(boolean[][] map, Point startPoint, List<Point> destinationPoints) {
		super(map, startPoint, destinationPoints);		
	}
	
	public Random getSeed() {
		return new Random();
	}

}
