package com.syntacticsugar.vooga.util.dirview;

import java.io.File;
import java.util.Collection;

/**
 * The purpose of this interface is to create data structures that can be
 * easily converted to visual representations (strings, images, etc), instead
 * of trying to process and represent entire arbitrary File objects.

 * @author Brody Kellish
 *
 * @param <T> : The type to which each File should be converted
 */
public interface IConverter<T> {

	/**
	 * This method can be overwritten to only grab Files of a certain extension, 
	 * and returns arbitrary data representations of each File according to the
	 * application's needs.
	 * 
	 * @param directory : the directory containing the target files
	 * @return dataCollection : Collection containing the converted files
	 */
	public Collection<T> convertFiles(File directory);
	
}
