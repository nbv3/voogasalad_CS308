package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.List;

public interface IPathFinder {
	public Point getNext();

	public List<Point> getPath();
}
