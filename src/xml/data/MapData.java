package xml.data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.syntacticsugar.vooga.gameplayer.universe.map.IGameMap;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public class MapData {

	private TileData[][] myTileData;
	private int myMapSize;
	
	public MapData(IGameMap map) {
		for (int i = 0; i < map.getSize(); i++) {
			for (int j = 0; j < map.getSize(); j++) {
				IGameTile tile = map.getPathFindingMap().get(new Point(i,j));
				myTileData[i][j] = new TileData(tile);
			}
		}
		myMapSize = map.getSize();
	}
	
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
