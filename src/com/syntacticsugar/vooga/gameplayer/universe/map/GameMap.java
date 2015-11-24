package com.syntacticsugar.vooga.gameplayer.universe.map;

import javafx.geometry.Point2D;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public class GameMap implements IGameMap {
	
	private DecoratorTile[][] myTiles;
	private double maxWidth;
	private double maxHeight;
	private int xDimension;
	private int yDimension;

	// TO IMPLEMENT: xDIMENSION, yDIMENSION
	public GameMap(double size, int dim) {
		maxWidth = size;
		maxHeight = size;
		xDimension = dim;
		yDimension = dim;
		myTiles = new DecoratorTile[xDimension][yDimension];
		for (int row = 0; row < xDimension; row++) {
			for (int col = 0; col < yDimension; col++) {
				Point2D point = new Point2D(row * maxHeight/yDimension,col * maxWidth/xDimension);
				String path = "scenery_grass_1.png";
				myTiles[row][col] = new DecoratorTile(point,maxWidth/xDimension,maxHeight/yDimension,path);
			}
		}
	}

	@Override
	public IGameTile[][] getTiles() {
		return myTiles;
	}

	@Override
	public boolean[][] isWalkable() {
		boolean[][] walk = new boolean[xDimension][yDimension];
		for (int row = 0; row < xDimension; row++) {
			for (int col = 0; col < yDimension; col++) {
				walk[row][col] = myTiles[row][col].isWalkable();
			}
		}
		return walk;
	}

	@Override
	public boolean[][] isPlaceable() {
		boolean[][] place = new boolean[xDimension][yDimension];
		for (int row = 0; row < xDimension; row++) {
			for (int col = 0; col < yDimension; col++) {
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
