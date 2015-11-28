package com.syntacticsugar.vooga.gameplayer.objects;

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

	

}
