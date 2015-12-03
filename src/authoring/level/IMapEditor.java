package authoring.level;

import xml.data.TileImplementation;

public interface IMapEditor {

	public void selectAllTiles();
	
	public void clearAllTiles();
	
	public void setAsDestination(boolean isDestination);
	
	public void setImplementation(TileImplementation impl);
	
	public void setImagePath(String imagePath);
	
}
