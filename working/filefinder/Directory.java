package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Directory {
	private List<Directory> directories;
	private List<File> files;
	private List<String> fileNames;
	private String currentPath;
	private File currentFolder;

	public Directory(String path) throws IOException {
		currentPath = path;
		currentFolder = new File(currentPath);
		directories = new ArrayList<Directory>();
		files = new ArrayList<File>();
		fileNames = new ArrayList<String>();
		File[] listOfFiles = currentFolder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// String aPath = listOfFiles[i].getAbsolutePath();
				// String cPath = listOfFiles[i].getCanonicalPath();
				String nPath = listOfFiles[i].getPath();
				// TODO decide between canonical, normal, and absolute paths
				fileNames.add(nPath);
				files.add(listOfFiles[i]);
				// System.out.println("File: " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				Directory cDir = new Directory(listOfFiles[i].getCanonicalPath());
				directories.add(cDir);
				// System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}
	}

	/**
	 * 
	 * @param ext
	 * @return all Directories in current Directory
	 */
	public List<Directory> getDirectories() {
		return directories;
	}

	/**
	 * 
	 * @param ext
	 * @return all files in the current directory Slow
	 */
	public List<File> getFiles() {
		return files;
	}

	/**
	 * 
	 * @param ext
	 * @return all filenames in the current directory Slow
	 */
	public List<String> getFileNames() {
		return fileNames;
	}


	/**
	 * 
	 * @param ext
	 * @return all files with extension in the current directory Slow
	 */
	public List<File> getFilesByExtension(String ext) {
		return null;
	}

	/**
	 * 
	 * @param ext
	 * @return all filepathnames with extension in the current directory
	 * 
	 */
	public List<String> getFileNamesByExtension(String ext) {
		return null;
	}

}
