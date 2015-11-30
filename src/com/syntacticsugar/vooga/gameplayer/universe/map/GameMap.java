package com.syntacticsugar.vooga.gameplayer.universe.map;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public class GameMap implements IGameMap {
	
	private static final double MAP_DIMENSIONS = 1000.0;
	
	private final DecoratorTile[][] myTiles;
	private int numCols;
	private int numRows;

	// TO IMPLEMENT: xDIMENSION, yDIMENSION
	public GameMap(int dim) {
		numCols = dim;
		numRows = dim;
		myTiles = new DecoratorTile[numCols][numRows];
		for (int row = 0; row < numCols; row++) {
			for (int col = 0; col < numRows; col++) {
				Point2D point = new Point2D(row*MAP_DIMENSIONS/numRows, col*MAP_DIMENSIONS/numCols);
				String path = "scenery_grass_1.png";
				myTiles[row][col] = new DecoratorTile(point,MAP_DIMENSIONS/numCols,MAP_DIMENSIONS/numRows,path);
			}
		}
	}

	@Override
	public Collection<DecoratorTile> getTiles() {
		Collection<DecoratorTile> tiles = new ArrayList<DecoratorTile>();
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

}
