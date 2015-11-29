package com.syntacticsugar.vooga.gameplayer.universe.map;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Collection;

import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.DecoratorTile;
import com.syntacticsugar.vooga.gameplayer.universe.map.tiles.IGameTile;

public class GameMap implements IGameMap {
	
	private static final double MAP_DIMENSIONS = 1000.0;
	
	private DecoratorTile[][] myTiles;
	private double maxWidth;
	private double maxHeight;
	private int xDimension;
	private int yDimension;

	// TO IMPLEMENT: xDIMENSION, yDIMENSION
	public GameMap(int dim) {
		maxWidth = MAP_DIMENSIONS;
		maxHeight = MAP_DIMENSIONS;
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
