package tiles.implementations;

import javafx.geometry.Point2D;
import tiles.IGameTile;

public class SceneryTile implements IGameTile {	
	
	private Point2D myPoint;
	
	public SceneryTile(Point2D p) {
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
	public Point2D getPoint() {
		return myPoint;
	}

}
