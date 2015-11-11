package tiles;

import java.awt.Point;

public interface IGameTile {
	
	public boolean isWalkable();
	
	public boolean isPlaceable();
	
	public Point getPoint();

}
