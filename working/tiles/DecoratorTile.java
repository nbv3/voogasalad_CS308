package tiles;

import java.awt.Point;
import java.util.Observable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tiles.implementations.PathTile;
import view.IView;

public class DecoratorTile extends Observable implements IGameTile, IView {
	
	private IGameTile myImplementation;
	private ImageView myImageView;
	
	public DecoratorTile(Point p) {
		myImplementation = new PathTile(p);
		setImage(new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("scenery_grass_1.png"))));
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
	public Point getPoint() {
		return myImplementation.getPoint();
	}
	
	public IGameTile getImplementation() {
		return myImplementation;
	}
	
	public void setImplementation(IGameTile gt) {
		this.myImplementation = gt;
	}

	@Override
	public ImageView getView() {
		return myImageView;
	}

	@Override
	public void setImage(ImageView iv) {
		myImageView = iv;
		setChanged();
		notifyObservers();
	}
	
}
