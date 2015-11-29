package authoring.data;

public class TileData {

	private String myImagePath;
	private TileImplementation myImplementation;
	private boolean isDestination;
	
	public TileData(String imagePath) {
		setImagePath(imagePath);
		setImplementation(TileImplementation.Scenery);
		setDestination(false);
	}
	
	public void setImagePath(String path) {
		this.myImagePath = path;
	}
	
	public void setImplementation(TileImplementation impl) {
		this.myImplementation = impl;
	}
	
	public void setDestination(boolean isDestination) {
		this.isDestination = isDestination;
	}
	
	public String getImagePath() {
		return this.myImagePath;
	}

	public TileImplementation getImplementation() {
		return this.myImplementation;
	}
	
	public Boolean isDestination() {
		return this.isDestination;
	}
}
