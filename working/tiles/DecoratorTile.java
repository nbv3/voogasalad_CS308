package tiles;

import javafx.geometry.Point2D;
import tiles.implementations.PathTile;
import view.ObservableBoundingBox;
import view.ViewableObject;

public class DecoratorTile extends ViewableObject implements IGameTile {
	
	private IGameTile myImplementation;
	
	public DecoratorTile(int id, Point2D p, double width, double height) {
		super(id, new ObservableBoundingBox(p, width, height));
		myImplementation = new PathTile(p);
	}

	@Override
	public boolean isWalkable() {
		return myImplementation.isWalkable();
	}

	@Override
	public boolean isPlaceable() {
		return myImplementation.isPlaceable();
	}

	@Override
	public Point2D getPoint() {
		return myImplementation.getPoint();
	}
	
	public IGameTile getImplementation() {
		return myImplementation;
	}
	
	public void setImplementation(IGameTile gt) {
		this.myImplementation = gt;
	}
	
}
