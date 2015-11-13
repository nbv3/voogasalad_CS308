package tiles.implementations;

import java.awt.Point;

import tiles.IGameTile;

public class SceneryTile implements IGameTile {	
	
	private Point myPoint;
	
	public SceneryTile(Point p) {
		this.myPoint = p;
	}
	
	public SceneryTile(IGameTile gt) {
		this(gt.getPoint());
	}
	
	@Override
	public boolean isWalkable() {
		return false;
	}

	@Override
	public boolean isPlaceable() {
		return true;
	}

	@Override
	public Point getPoint() {
		return myPoint;
	}

}
