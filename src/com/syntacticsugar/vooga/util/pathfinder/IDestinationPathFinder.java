package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.List;

public interface IDestinationPathFinder {
	public void shortestPaths();

	public List<List<Point>> getPaths();
}
