package tiles.implementations;

import java.awt.Point;

import tiles.AbstractGameTile;
import tiles.IGameTile;

public class PathTile extends AbstractGameTile {
		
	public PathTile(Point p) {
		super(p);
	}
	
	public PathTile(IGameTile gt) {
		this(gt.getPoint());
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
