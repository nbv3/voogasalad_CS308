package engine.environment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Point2D;
import tiles.DecoratorTile;
import tiles.IGameTile;

public class GameMap implements IGameMap {

	private int myWidth;
	private int myHeight;
	private Map<Point2D, DecoratorTile> myTiles;
	
	public GameMap() {
		this(20, 20);
	}
	
	public GameMap(int width, int height) {
		myWidth = width;
		myHeight = height;
		myTiles = new HashMap<Point2D, DecoratorTile>();
	}
	
	@Override
	public Map<Point2D, DecoratorTile> getTileMap() {
		return myTiles;
	}

	@Override
	public List<DecoratorTile> getNeighborTiles(Point2D p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DecoratorTile> getNeighborTiles(DecoratorTile tile) {
		return getNeighborTiles(tile.getPoint());
	}

	@Override
	public DecoratorTile getTile(Point2D p) {
		// TODO Auto-generated method stub
		return myTiles.get(p);
	}

	@Override
	public void setTile(Point2D p, DecoratorTile tile) {
		myTiles.put(p, tile);
	}

	public int getMapWidth() {
		return myWidth;
	}
	
	public int getMapHeight() {
		return myHeight;
	}

	@Override
	public IGameTile getTileFromCoordinate(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		
		int i = (int) (x / 1000.0) * myWidth;
		int j = (int) (y / 1000.0) * myHeight;
		
		return myTiles.get(new Point2D(i, j));
	}
	
}
