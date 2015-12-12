// This entire file is part of my masterpiece.
// Brody Kellish

package com.syntacticsugar.vooga.xml.data;

/**
 * Interface used to define any type of Data object that can be
 * displayed by an image in the project's data folder.
 * 
 * @author Brody Kellish
 *
 */
public interface IViewableData {

	/**
	 * Return the path to the image used to display this data visually.
	 * 
	 * @return imagePath : the String path to this data's image.
	 */
	public String getImagePath();
	
}
