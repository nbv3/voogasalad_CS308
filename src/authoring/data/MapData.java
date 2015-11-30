package authoring.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MapData {

	private TileData[][] myTileData;
	private int myMapSize;
	
	public MapData(int numTiles, String tileImage) {
		myMapSize = numTiles;
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
	
	public Collection<TileData> getTiles() {
		Collection<TileData> tiles = new ArrayList<>();
		for (int i=0; i<myTileData.length; i++) {
			for (int j=0; j<myTileData[0].length; j++) {
				tiles.add(getTileData(i, j));
			}
		}
		return Collections.unmodifiableCollection(tiles);
	}
	
	public int getMapSize() {
		return myMapSize;
	}
	
}
