package tiles.implementations;

import java.awt.Point;

import tiles.AbstractGameTile;
import tiles.IGameTile;

public class SceneryTile extends AbstractGameTile {	
	
	public SceneryTile(Point p) {
		super(p);
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

}
