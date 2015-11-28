package authoring.data;

public class MapData {

	private TileData[][] myTileData;
	
	public MapData(int numTiles, String defaultTileImage) {
		myTileData = new TileData[numTiles][numTiles];
		initializeTileData(numTiles, defaultTileImage);
	}
	
	private void initializeTileData(int numTiles, String defaultImage) {
		for (int i=0; i<numTiles; i++) {
			for (int j=0; j<numTiles; j++) {
				myTileData[i][j] = new TileData(defaultImage);
			}
		}
	}
	
	public TileData getTileData(int i, int j) {
		if (i<myTileData.length && j<myTileData.length) 
			return myTileData[i][j];
		throw new IndexOutOfBoundsException("Specified tile is out of map bounds.");
	}
	
}
