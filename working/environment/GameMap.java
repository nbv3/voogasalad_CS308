package environment;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tiles.DecoratorTile;
import tiles.IGameTile;

public class GameMap implements IGameMap {

	private int mySize;
	private Map<Point, DecoratorTile> myTiles;
	
	public GameMap() {
		this(20);
	}
	
	public GameMap(int size) {
		mySize = size;
		myTiles = new HashMap<Point, DecoratorTile>();
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				Point p = new Point(i, j);
				myTiles.put(p, new DecoratorTile(p));
			}
		}
	}
	
	@Override
	public Map<Point, DecoratorTile> getTileMap() {
		return myTiles;
	}

	@Override
	public List<DecoratorTile> getNeighborTiles(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DecoratorTile> getNeighborTiles(DecoratorTile tile) {
		return getNeighborTiles(tile.getPoint());
	}

	@Override
	public DecoratorTile getTile(Point p) {
		// TODO Auto-generated method stub
		return myTiles.get(p);
	}

	@Override
	public void setTile(Point p, DecoratorTile tile) {
		myTiles.put(p, tile);
	}

	public int getMapSize() {
		return mySize;
	}

	@Override
	public IGameTile getTileFromCoordinate(Point p) {
		double x = p.getX();
		double y = p.getY();
		
		int i = (int) (x / 1000.0) * mySize;
		int j = (int) (y / 1000.0) * mySize;
		
		return myTiles.get(new Point(i, j));
	}
	
}
