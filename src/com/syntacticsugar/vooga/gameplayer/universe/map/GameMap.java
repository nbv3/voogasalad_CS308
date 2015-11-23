package com.syntacticsugar.vooga.gameplayer.universe.map;

import java.awt.Point;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public class GameMap implements IGameMap {
	private IGameTile[][] myTiles;
	private int mapHeight;// actual pixels
	private int mapWidth;// actual pixels
	private int xDimension;
	private int yDimension;

	// TO IMPLEMENT: xDIMENSION, yDIMENSION
	public GameMap(int height, int width, int xDim, int yDim) {
		mapHeight = height;
		mapWidth = width;
		xDimension = xDim;
		yDimension = yDim;
		myTiles = new DecoratorTile[xDimension][yDimension];
		for (int row = 0; row < xDimension; row++) {
			for (int col = 0; col < yDimension; col++) {
				Point point = new Point(row,col);
				 myTiles[row][col] = new DecoratorTile(point, mapWidth/xDimension, mapHeight/yDimension);
			}
		}

	}

	public IGameTile[][] getTiles() {
		return myTiles;
	}

	public boolean[][] isWalkable() {
		boolean[][] walk = new boolean[xDimension][yDimension];
		for (int row = 0; row < xDimension; row++) {
			for (int col = 0; col < yDimension; col++) {
				walk[row][col] = myTiles[row][col].isWalkable();
			}
		}
		return walk;
	}

	public boolean[][] isPlaceable() {
		boolean[][] place = new boolean[xDimension][yDimension];
		for (int row = 0; row < xDimension; row++) {
			for (int col = 0; col < yDimension; col++) {
				place[row][col] = myTiles[row][col].isPlaceable();
			}
		}
		return place;
	}

	public IGameTile getTile(Point p) {
		return myTiles[(int) p.getX()][(int) p.getY()];
	}

}
