package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Directory {
	private List<Directory> directories;
	private List<File> files;
	private List<String> filePaths;
	private String currentPath;
	private File currentFolder;

	public Directory(String path) throws IOException {
		this(path, 3);
	}

	/**
	 * 
	 * @param path - directory path
	 * @param sort
	 *            (1: lastModified - recent first) <br/>
	 *            (-1: lastModified - old first) <br/>
	 *            (3: alphabetical)
	 * @throws IOException
	 */
	public Directory(String path, int sort) throws IOException {
		currentPath = path;
		currentFolder = new File(currentPath);
		directories = new ArrayList<Directory>();
		files = new ArrayList<File>();
		filePaths = new ArrayList<String>();
		File[] listOfFiles = currentFolder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files.add(listOfFiles[i]);
				// System.out.println("File: " + listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				Directory cDir = new Directory(listOfFiles[i].getCanonicalPath());
				directories.add(cDir);
				// System.out.println("Directory: " + listOfFiles[i].getName());
			}
		}

		if (Math.abs(sort) == 1) {
			Collections.sort(files, new Comparator<File>() {
				public int compare(File f1, File f2) {
					return Long.compare(f1.lastModified(), f2.lastModified());
				}
			});
		} else if (Math.abs(sort) == 3) {
			Collections.sort(files, null);
		} else {
			Collections.sort(files, null);
		}
		
		if (sort < 0) {
			Collections.reverse(files);
		}
		
		for (int i = 0; i < files.size(); i++) {
			// String aPath = listOfFiles[i].getAbsolutePath();
			// String cPath = listOfFiles[i].getCanonicalPath();
			// String nPath = listOfFiles[i].getPath();
			// TODO decide between canonical, normal, and absolute paths
			filePaths.add(files.get(i).getPath());
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
	 * @return all files in the current directory
	 */
	public List<File> getFiles() {
		return files;
	}

	/**
	 * 
	 * @param ext
	 * @return all filenames in the current directory
	 */
	public List<String> getFilePaths() {
		return filePaths;
	}

	/**
	 * 
	 * @param ext
	 * @return all files with extension in the current directory
	 */
	public List<File> getFilesByExtension(String ext) {
		List<File> filesWithExtension = new ArrayList<File>();
		String[] validExt = extValidate(ext);
		for (int i = 0; i < files.size(); i++) {
			String filename = files.get(i).getName();
			if (filename.endsWith(validExt[0]) || filename.endsWith(validExt[1])) {
				filesWithExtension.add(files.get(i));
			}
		}
		return filesWithExtension;
	}

	/**
	 * 
	 * @param ext
	 * @return all filepathnames with extension in the current directory
	 * 
	 */
	public List<String> getFilePathsByExtension(String ext) {
		List<String> filePathsWithExtension = new ArrayList<String>();
		String[] validExt = extValidate(ext);
		for (int i = 0; i < files.size(); i++) {
			String filename = files.get(i).getName();
			if (filename.endsWith(validExt[0]) || filename.endsWith(validExt[1])) {
				filePathsWithExtension.add(files.get(i).getPath());
			}
		}
		return filePathsWithExtension;
	}

	/**
	 * 
	 * @param ext
	 * @return all files with string in name in the current directory
	 */
	public List<File> getFilesByContains(String str) {
		List<File> filesWithStr = new ArrayList<File>();
		for (int i = 0; i < files.size(); i++) {
			String filename = files.get(i).getName();
			if (filename.contains(str)) {
				filesWithStr.add(files.get(i));
			}
		}
		return filesWithStr;
	}

	/**
	 * 
	 * @param ext
	 * @return all file paths with string in name in the current directory
	 */
	public List<String> getFilePathsByContains(String str) {
		List<String> filesWithStr = new ArrayList<String>();
		for (int i = 0; i < files.size(); i++) {
			String filename = files.get(i).getName();
			if (filename.contains(str)) {
				filesWithStr.add(files.get(i).getPath());
			}
		}
		return filesWithStr;
	}

	public boolean hasDirectories() {
		return !directories.isEmpty();
	}

	/**
	 * adds a . to the extension if no dot is added makes ext lower case
	 */
	private String[] extValidate(String ext) {
		String[] validExt = new String[2];
		ext = ext.toLowerCase();
		if (ext.charAt(0) == '.') {
			validExt[0] = ext;
			validExt[1] = ext.toUpperCase();
			return validExt;
		}
		validExt[0] = "." + ext;
		validExt[1] = "." + ext.toUpperCase();
		return validExt;
	}
}
