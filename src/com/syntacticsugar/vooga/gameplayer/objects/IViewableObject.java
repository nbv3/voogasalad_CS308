package com.syntacticsugar.vooga.gameplayer.objects;

import javafx.geometry.Point2D;

public interface IViewableObject {
	
	/**
	 * Returns the BoundingBox associated with this ViewableObject.
	 * @return
	 */
	public BoundingBox getBoundingBox();

	/**
	 * Returns the path for the image used to display this ViewableObject.
	 * @return
	 */
	public String getPath();
	
	/**
	 * Return the raw centerpoint coordinate of this ViewableObject.
	 * @return
	 */
	public Point2D getCenterPoint();

	/**
	 * Explicitly move this ViewableObject to the desired point.
	 * @param point
	 */
	void setPoint(Point2D point);

	

}
