package environment;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tiles.AbstractGameTile;
import tiles.IGameTile;
import tiles.PathTile;
import tiles.SceneryTile;

public class GameMap implements IGameMap {

	private int mySize;
	private Map<Point, AbstractGameTile> myTiles;
	
	public GameMap() {
		this(18);
	}
	
	public GameMap(int size) {
		mySize = size;
		myTiles = new HashMap<Point, AbstractGameTile>();
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				Point p = new Point(i, j);
				myTiles.put(p, new SceneryTile(p));
			}
		}
	}
	
	@Override
	public Map<Point, AbstractGameTile> getTileMap() {
		return myTiles;
	}

	@Override
	public List<AbstractGameTile> getNeighborTiles(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractGameTile> getNeighborTiles(IGameTile gt) {
		return getNeighborTiles(gt.getPoint());
	}

	@Override
	public AbstractGameTile getTile(Point p) {
		// TODO Auto-generated method stub
		return myTiles.get(p);
	}

	@Override
	public void setTile(Point p, AbstractGameTile gt) {
		myTiles.put(p, gt);
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
