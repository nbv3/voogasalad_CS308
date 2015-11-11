package tiles;

import java.awt.Point;

public class SceneryTile extends AbstractGameTile {	
	
	public SceneryTile(Point p) {
		super(p);
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
