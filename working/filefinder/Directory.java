package filefinder;

import java.io.File;
import java.util.List;

public class Directory {
	private List<Directory> directories;
	private List<File> files;
	private List<String> fileNames;
	private String currentDirectory;
	
	public Directory () {
		
	}
	
	/**
	 * 
	 * @param ext
	 * @return all files with extension in the current directory
	 * Slow
	 */
	public List<File> getFilesByExtension(String ext) {
		return null;
	}
	
	/**
	 * 
	 * @param ext
	 * @return all files with extension in the current directory and its children's directories recursively
	 * Slow
	 */
	public List<File> getFilesByExtensionRecursive(String ext) {
		return null;
	}
	
	/**
	 * 
	 * @param ext
	 * @return all filepathnames with extension in the current directory
	 * 
	 */
	public List<File> getFileNamesByExtension(String ext) {
		return null;
	}
	
	/**
	 * 
	 * @param ext
	 * @return all files with extension in the current directory and its children's directories recursively
	 * 
	 */
	public List<File> getFileNamesByExtensionRecursive(String ext) {
		return null;
	}
}
