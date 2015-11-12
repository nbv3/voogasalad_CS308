package environment;

import java.awt.Point;
import java.util.List;
import java.util.Map;

import tiles.IGameTile;
import tiles.implementations.DecoratorTile;

public interface IGameMap {

	public DecoratorTile getTile(Point p);
	
	public void setTile(Point p, DecoratorTile gt);
	
	public Map<Point, DecoratorTile> getTileMap();
	
	public List<DecoratorTile> getNeighborTiles(Point p);
	
	public List<DecoratorTile> getNeighborTiles(DecoratorTile gt);
	
	public IGameTile getTileFromCoordinate(Point p);
	
}
