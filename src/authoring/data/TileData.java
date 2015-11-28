package authoring.data;

import com.syntacticsugar.vooga.util.ResourceManager;

public class TileData {

	private static final String PATH = ResourceManager.getString("Path_name");
	private static final String SCENERY = ResourceManager.getString("Scenery_name");
	
	private String myImagePath;
	private String myImplementation;
	
	public TileData(String imagePath) {
		setImagePath(imagePath);
		setImplementation(PATH);
	}
	
	public void setImagePath(String path) {
		this.myImagePath = path;
	}
	
	public void setImplementation(String impl) {
		this.myImplementation = (impl.equals("Path")) ? PATH : SCENERY;
	}
	
	public String getImagePath() {
		return this.myImagePath;
	}

	public String getImplementation() {
		return this.myImplementation;
	}
}
