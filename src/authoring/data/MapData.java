package authoring.data;

public class MapData {

	private TileData[][] myTileData;
	
	public MapData(int numTiles, String tileImage) {
		myTileData = new TileData[numTiles][numTiles];
		initializeTileData(numTiles, tileImage);
	}
	
	private void initializeTileData(int numTiles, String tileImage) {
		for (int i=0; i<numTiles; i++) {
			for (int j=0; j<numTiles; j++) {
				myTileData[i][j] = new TileData(tileImage);
			}
		}
	}
	
	public TileData getTileData(int i, int j) {
		if (i<myTileData.length && j<myTileData.length) 
			return myTileData[i][j];
		throw new IndexOutOfBoundsException("Specified tile is out of map bounds.");
	}
	
}
