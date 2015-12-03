package com.syntacticsugar.vooga.gameplayer.universe.map;

import javafx.geometry.Point2D;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;
import com.syntacticsugar.vooga.xml.data.MapData;
import com.syntacticsugar.vooga.xml.data.TileData;
import com.syntacticsugar.vooga.xml.data.TileImplementation;


public class GameMap implements IGameMap {
	
	private static final double MAP_DIMENSIONS = 1000.0;
	
	private final DecoratorTile[][] myTiles;
	private int numCols;
	private int numRows;
	
	private Point myDestination;

	public GameMap(MapData mapData) {
		numCols = mapData.getMapSize();
		numRows = mapData.getMapSize();
		myTiles = new DecoratorTile[numCols][numRows];
		for (int row = 0; row < numCols; row++) {
			for (int col = 0; col < numRows; col++) {
				Point2D point = new Point2D(row*MAP_DIMENSIONS/numRows, col*MAP_DIMENSIONS/numCols);
				myTiles[row][col] = new DecoratorTile(mapData.getTileData(row, col), point, 
						MAP_DIMENSIONS/numCols,MAP_DIMENSIONS/numRows);
			}
		}
	}
	
	// TO IMPLEMENT: xDIMENSION, yDIMENSION
	public GameMap(int dim) {
		numCols = dim;
		numRows = dim;
		myTiles = new DecoratorTile[numCols][numRows];
		for (int row = 0; row < numCols; row++) {
			for (int col = 0; col < numRows; col++) {
				Point2D point = new Point2D(row*MAP_DIMENSIONS/numRows, col*MAP_DIMENSIONS/numCols);
				String path = "scenery_grass_1.png";
				myTiles[row][col] = new DecoratorTile(point,TileImplementation.Path,MAP_DIMENSIONS/numCols,MAP_DIMENSIONS/numRows,path);
			}
		}
	}

	@Override
	public Collection<IGameTile> getTiles() {
		Collection<IGameTile> tiles = new ArrayList<>();
		for (int i=0; i<myTiles.length; i++) {
			for (int j=0; j<myTiles[0].length; j++) {
				tiles.add(myTiles[i][j]);
			}
		}
		return tiles;
	}

	@Override
	public boolean[][] isWalkable() {
		boolean[][] walk = new boolean[numCols][numRows];
		for (int row = 0; row < numCols; row++) {
			for (int col = 0; col < numRows; col++) {
				walk[row][col] = myTiles[row][col].isWalkable();
			}
		}
		return walk;
	}

	@Override
	public boolean[][] isPlaceable() {
		boolean[][] place = new boolean[numCols][numRows];
		for (int row = 0; row < numCols; row++) {
			for (int col = 0; col < numRows; col++) {
				place[row][col] = myTiles[row][col].isPlaceable();
			}
		}
		return place;
	}

	@Override
	public IGameTile getTile(Point2D p) {
		return myTiles[(int) p.getX()][(int) p.getY()];
	}
	
	@Override
	public Point getMapIndexFromCoordinate(Point2D coordinate) throws Exception {
		int r = (int) Math.floor((coordinate.getX() / MAP_DIMENSIONS) * numRows);
		int c = (int) Math.floor((coordinate.getY() / MAP_DIMENSIONS) * numCols);
		if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
			throw new Exception("Out of Map Bounds");
		}
		return new Point(r, c);
//		return coordinate;
	}
	
	@Override
	public int getSize() {
		if (numRows == numCols) {
			return numRows;
		}
		return -1;
	}

	@Override
	public Map<Point, IGameTile> getPathFindingMap() {
		Map<Point, IGameTile> map = new HashMap<>();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				map.put(new Point(i,j), myTiles[i][j]);
			}
		}
		return map;
	}

	@Override
	public double getTileSize() {
		return (MAP_DIMENSIONS / (double) (numRows));
	}

	@Override
	public List<Point> getDestinationPoints() {
		List<Point> destinations = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (myTiles[i][j].isDestination()) {
					destinations.add(new Point (i,j));
				}
			}
		}
		return destinations;
	}

	@Override
	public Point2D getCoordinateFromMapIndex(Point index) {
		double x = (index.x * MAP_DIMENSIONS / (double) (numRows));
		double y = (index.y * MAP_DIMENSIONS / (double) (numCols));
		return new Point2D(x,y);
	}

}
