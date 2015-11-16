package engine.environment;

import java.util.List;
import java.util.Map;

import javafx.geometry.Point2D;
import tiles.DecoratorTile;
import tiles.IGameTile;

public interface IGameMap {

	public DecoratorTile getTile(Point2D p);
	
	public void setTile(Point2D p, DecoratorTile gt);
	
	public Map<Point2D, DecoratorTile> getTileMap();
	
	public List<DecoratorTile> getNeighborTiles(Point2D p);
	
	public List<DecoratorTile> getNeighborTiles(DecoratorTile gt);
	
	public IGameTile getTileFromCoordinate(Point2D p);
	
}
