package tiles.implementations;

import java.awt.Point;

import javafx.geometry.Point2D;
import tiles.IGameTile;

public class PathTile implements IGameTile {
		
	private Point2D myPoint;
	
	public PathTile(Point2D p) {
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
	public Point2D getPoint() {
		return myPoint;
	}

}
