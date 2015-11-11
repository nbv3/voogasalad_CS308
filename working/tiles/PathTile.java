package tiles;

import java.awt.Point;

public class PathTile extends AbstractGameTile {
		
	public PathTile(Point p) {
		super(p);
	}
	
	@Override
	public boolean isWalkable() {
		return true;
	}

	@Override
	public boolean isPlaceable() {
		return false;
	}
	
}
