package tiles.implementations;

import java.awt.Point;

import tiles.IGameTile;

public class PathTile implements IGameTile {
		
	private Point myPoint;
	
	public PathTile(Point p) {
		this.myPoint = p;
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

	@Override
	public Point getPoint() {
		return myPoint;
	}

}
