package environment;

import java.awt.Point;
import java.util.List;
import java.util.Map;

import tiles.AbstractGameTile;
import tiles.IGameTile;

public interface IGameMap {

	public AbstractGameTile getTile(Point p);
	
	public void setTile(Point p, AbstractGameTile gt);
	
	public Map<Point, AbstractGameTile> getTileMap();
	
	public List<AbstractGameTile> getNeighborTiles(Point p);
	
	public List<AbstractGameTile> getNeighborTiles(IGameTile gt);
	
	public IGameTile getTileFromCoordinate(Point p);
	
}
