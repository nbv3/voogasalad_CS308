// This entire file is part of my masterpiece.
// Jiawei Zhang

package com.syntacticsugar.vooga.util.pathfinder;

import java.awt.Point;
import java.util.List;

/**
 * Interface for all pathfinders
 * @author jiawei
 *
 */
public interface IPathFinder {
	/**
	 * Public method used to get the next point for a pathfinder
	 * @return next Point to navigate to
	 */
	public Point getNext();

	/**
	 * Public method used to get the full path for a pathfinder
	 * @return a List of Point objects representing the full path to its destination
	 */
	public List<Point> getPath();
}
