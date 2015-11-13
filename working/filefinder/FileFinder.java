package filefinder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class FileFinder {
	private final String DEFAULT_RESOURCE_PACKAGE = "resources.strings/";
	private Set<String> tileDirectory;
	private Set<String> enemyDirectory;
	private Set<String> towerDirectory;
	private Set<String> obstacleDirectory;
	private Set<String> projectileDirectory;
	private Set<String> playerDirectory;
	private Set<String> itemDirectory;

	private Set<String> imgFormats;

	public FileFinder() {
		ResourceBundle fileFormatResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "FileFormats");
		ResourceBundle directoriesResource = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + "Directories");
		imgFormats = new HashSet<String>(Arrays.asList(fileFormatResource.getString("img").split("\\s+")));
		tileDirectory = new HashSet<String>(Arrays.asList(directoriesResource.getString("tiles").split("\\s+")));
		enemyDirectory = new HashSet<String>(Arrays.asList(directoriesResource.getString("enemies").split("\\s+")));
		towerDirectory = new HashSet<String>(Arrays.asList(directoriesResource.getString("towers").split("\\s+")));
		obstacleDirectory = new HashSet<String>(
				Arrays.asList(directoriesResource.getString("obstacles").split("\\s+")));
		projectileDirectory = new HashSet<String>(
				Arrays.asList(directoriesResource.getString("projectiles").split("\\s+")));
		playerDirectory = new HashSet<String>(Arrays.asList(directoriesResource.getString("players").split("\\s+")));
		itemDirectory = new HashSet<String>(Arrays.asList(directoriesResource.getString("items").split("\\s+")));

	}

	public List<File> getImages(String path) {
		try {
			Directory d = new Directory(path);
			return d.getFilesByExtensions(imgFormats);
		} catch (IOException e) {
			e.printStackTrace(); // TODO
		}
		return new ArrayList<File>();
	}

	public List<File> getTileImages() {
		return getBySet(tileDirectory);
	}
	
	public List<File> getEnemyImages() {
		return getBySet(enemyDirectory);
	}
	
	public List<File> getTowerImages() {
		return getBySet(towerDirectory);
	}
	
	public List<File> getObstacleImages() {
		return getBySet(obstacleDirectory);
	}
	
	public List<File> getProjectileImages() {
		return getBySet(projectileDirectory);
	}
	
	public List<File> getPlayerImages() {
		return getBySet(playerDirectory);
	}
	
	public List<File> getItemImages() {
		return getBySet(itemDirectory);
	}

	private List<File> getBySet(Set<String> set) {
		List<File> fs = new ArrayList<File>();
		for (String s : set) {
			fs.addAll(getImages(s));
		}
		return fs;
	}
}
